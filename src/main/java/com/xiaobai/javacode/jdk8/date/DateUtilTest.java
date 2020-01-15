package com.xiaobai.javacode.jdk8.date;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;

/**
 * @author xiaobai
 * @description: TODO
 * @date 2020/1/14 2:59 下午
 */
public class DateUtilTest {

    public static void main(String[] args) {
//        System.out.println(DateUtil.getSystemMillis());
//        System.out.println(System.currentTimeMillis());

//        System.out.println(DateUtil.getToday());
//        System.out.println(DateUtil.getYesterday());
//        System.out.println(DateUtil.getTomorrow());

//        System.out.println(DateUtil.getDate());

//        System.out.println(DateUtil.format(DateUtil.DTSHORT, LocalDate.now()));

//        System.out.println( LocalDateTime.now().plusDays(1));

//        System.out.println(DateUtil.between(ChronoUnit.MINUTES, LocalTime.now().plusMinutes(20), LocalTime.now()));

        Temporal temporal = DateUtil.add(LocalDateTime.now(), 51, ChronoUnit.MINUTES);
        String format = DateUtil.format(DateUtil.SIMPLE, temporal);
        System.out.println(format);

//        DateUtil.test();
    }
}
