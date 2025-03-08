package com.test.demoshop.repository;

import com.test.demoshop.entity.User;
import org.springframework.data.repository.CrudRepository;


/**
 * @Author 李楠
 * @Date 2025-03-08 星期六 05:15:31
 * @Description
 */
public interface UserRepository extends CrudRepository<User,Integer> {

}
