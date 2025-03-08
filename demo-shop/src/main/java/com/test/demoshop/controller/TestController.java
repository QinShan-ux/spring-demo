package com.test.demoshop.controller;

import com.test.demoshop.entity.User;
import com.test.demoshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

/**
 * @Author 李楠
 * @Date 2025-03-07 星期五 19:30:41
 * @Description
 */
@RestController
@RequestMapping("test")
public class TestController {
    @Autowired
    public UserRepository userRepository;
    @GetMapping("/hello")
    public String create(){
        return "Hello World";
    }
    @PostMapping("add")
    public @ResponseBody String add(@RequestParam String name,@RequestParam String password){
        User user = new User();
        user.setUsername(name);
        user.setPassword(password);
        user.setBirthday(new Date(System.currentTimeMillis()));
        user.setCreateTime(new Date(System.currentTimeMillis()));
        userRepository.save(user);
        return "Save";
    }
    @GetMapping("get")
    public Iterable<User> get(){
        return userRepository.findAll();
    }
}
