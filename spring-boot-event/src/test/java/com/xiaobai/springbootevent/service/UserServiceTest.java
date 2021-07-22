package com.xiaobai.springbootevent.service;

import com.xiaobai.springbootevent.BaseTest;
import com.xiaobai.springbootevent.Entity.User;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * @author xiaobai
 * @description: TODO
 * @date 2021/7/22 11:24 上午
 */
public class UserServiceTest extends BaseTest {

    @Resource
    private UserService userService;

    @Test
    public void createdUserTest() {

        User user = User.builder().firstName("1").lastName("1").email("123@qq.com").build();
        User user1 = userService.created(user);
        System.out.println(user1);
    }
}
