package com.xiaobai.springbootevent.service;

import com.xiaobai.springbootevent.Entity.User;

/**
 * @author xiaobai
 * @description: 用户service
 * @date 2021/7/22 10:37 上午
 */
public interface UserService {

    User created(User user);

    User findOne(Long id);
}
