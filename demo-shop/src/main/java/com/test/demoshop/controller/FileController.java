package com.test.demoshop.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

@RestController
@RequestMapping("/file")
@CrossOrigin(maxAge = 3600)
public class FileController {
    private final String CHUNK_DIR = System.getProperty("user.dir") + File.separator + "chunk";
    private final String COMPLETE_DIR = System.getProperty("user.dir") + File.separator + "complete";
    @PostMapping("/upload")
    public String upload(@RequestParam("chunk") MultipartFile chunk,
                         @RequestParam("chunkIndex") int chunkIndex,
                         @RequestParam("totalChunks") int totalChunk,
                         @RequestParam("fileName") String fileName) {

        try {
            // 创建临时目录，保存切片
            File chunkDir = new File(CHUNK_DIR);
            if (!chunkDir.exists()) {
                chunkDir.mkdirs();
            }
            // 保存当前切片
            File chunkFile = new File(CHUNK_DIR +  "-chunk-" + chunkIndex + fileName);
            chunk.transferTo(chunkFile);
            if (chunkIndex == totalChunk - 1) {
                Path completePath = Path.of(COMPLETE_DIR + File.separator + fileName);
                for (int i = 0; i < totalChunk; i++) {
                    Path chunkPath = Path.of(CHUNK_DIR+ "-chunk-" + i + fileName);
                    Files.write(completePath, Files.readAllBytes(chunkPath), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                    Files.delete(chunkPath); // 删除临时块文件
                }
            }
            return "块 " + chunkIndex + " 上传成功";
        }catch (Exception e) {
            e.printStackTrace();
            return "上传失败: " + e.getMessage();
        }
    }
}
