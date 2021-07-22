package com.xiaobai.springbootevent.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author xiaobai
 * @description: 邮件详情
 * @date 2021/7/22 10:24 上午
 */
@Data
@Builder
@Entity
@Table(name = "t_email_detail")
@NoArgsConstructor
@AllArgsConstructor
public class EmailDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "send_time")
    private Long sendTime;

    private String email;

}
