package com.xiaobai.springbootevent.dao;

import com.xiaobai.springbootevent.Entity.EmailDetail;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author xiaobai
 * @description: 邮件详情持久化类
 * @date 2021/7/22 10:34 上午
 */
public interface EmailDetailDao extends JpaRepository<EmailDetail, Long> {
}
