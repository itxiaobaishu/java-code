package com.xiaobai.springbootevent.service.impl;

import com.xiaobai.springbootevent.Entity.User;
import com.xiaobai.springbootevent.dao.UserDao;
import com.xiaobai.springbootevent.event.SendEmailEvent;
import com.xiaobai.springbootevent.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author xiaobai
 * @description:
 * @date 2021/7/22 11:11 上午
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private UserDao userDao;
    private ApplicationEventPublisher applicationEventPublisher;

    public UserServiceImpl(UserDao userDao, ApplicationEventPublisher applicationEventPublisher) {
        this.userDao = userDao;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public User created(User user) {
        log.info("保存用户信息:{}", user);
        userDao.save(user);
        //发布事件
        applicationEventPublisher.publishEvent(new SendEmailEvent(this, user.getId()));
        return user;
    }

    @Override
    public User findOne(Long id) {
        Optional<User> optional = userDao.findById(id);
        return optional.isPresent() ? optional.get() : new User();
    }
}
