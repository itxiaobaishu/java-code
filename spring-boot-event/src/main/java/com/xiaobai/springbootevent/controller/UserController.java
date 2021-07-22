package com.xiaobai.springbootevent.controller;

import com.xiaobai.springbootevent.Entity.User;
import com.xiaobai.springbootevent.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiaobai
 * @description:
 * @date 2021/7/22 2:16 下午
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/created")
    public User createUser() {
        User user = User.builder().lastName("san").firstName("zhang").email("99@qq.com").build();
        return userService.created(user);
    }
}
