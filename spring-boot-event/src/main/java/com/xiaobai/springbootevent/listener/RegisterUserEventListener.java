package com.xiaobai.springbootevent.listener;

import com.xiaobai.springbootevent.Entity.EmailDetail;
import com.xiaobai.springbootevent.Entity.User;
import com.xiaobai.springbootevent.dao.EmailDetailDao;
import com.xiaobai.springbootevent.dao.UserDao;
import com.xiaobai.springbootevent.event.SendEmailEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import java.util.Date;
import java.util.Optional;

/**
 * @author xiaobai
 * @description: 事件监听器
 * @date 2021/7/22 10:58 上午
 */
@Slf4j
@Component
public class RegisterUserEventListener {

    @Autowired
    private UserDao userDao;

    @Autowired
    private EmailDetailDao emailDetailDao;

    //事件异步处理实现第一种方式：使用@Async注解
    //@Async
    //@EventListener
    //可以使用condition属性指定限制的条件
    @EventListener(condition = "#event.userId > 14")
    //@TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT,condition = "#event.userId >=10")
    public void sendEmail(SendEmailEvent event) {
        log.info("监听到事件:{}", event.getUserId());
        Optional<User> optional = userDao.findById(event.getUserId());
        if (optional.isPresent()) {
            User user = optional.get();
            try {
                //TODO 处理发送邮件业务
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //保存邮件发送结果
            EmailDetail emailDetail = EmailDetail.builder().userId(user.getId()).email(user.getEmail()).sendTime(System.currentTimeMillis()).build();
            log.info("保存邮件发送结果:{}", emailDetail);
            emailDetailDao.save(emailDetail);
        }

    }
}
