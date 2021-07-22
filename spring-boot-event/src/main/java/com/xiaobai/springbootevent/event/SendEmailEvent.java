package com.xiaobai.springbootevent.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * @author xiaobai
 * @description: 发送邮件事件类
 * @date 2021/7/22 10:39 上午
 */
@Getter
public class SendEmailEvent extends ApplicationEvent {


    private Long userId;

    public SendEmailEvent(Object source, Long userId) {
        super(source);
        this.userId = userId;
    }
}
