package com.test.demoshop.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.cache.annotation.Cacheable;

import java.sql.Date;


/**
 * @Author 李楠
 * @Date 2025-03-07 星期五 19:42:06
 * @Description
 */
@Data
@Entity
@Table(name = "user")
@Schema(description= "学生信息")
public class User  {
    @Id
    @Schema(description = "主键ID", required = true, example = "1")
    @Column @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Schema(description = "用户名称", required = true, example = "李楠")
    private String username;
    @Schema(description = "用户密码", required = true, example = "李楠")
    private String password;
    @Column(unique = true)
    private Date birthday;
    @Column(name = "create_time")
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
