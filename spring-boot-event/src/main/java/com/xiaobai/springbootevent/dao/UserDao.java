package com.xiaobai.springbootevent.dao;

import com.xiaobai.springbootevent.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author xiaobai
 * @description: 用户持久化类
 * @date 2021/7/22 10:34 上午
 */
public interface UserDao extends JpaRepository<User, Long> {
}
