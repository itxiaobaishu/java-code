package com.xiaobai.javacode.jdk8.date;

import com.xiaobai.javacode.constant.NumberConstant;
import org.joda.time.DateTime;
import org.joda.time.Seconds;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

/**
 * @author xiaobai
 * @description: 日期工具类 应用jdk8的Date API
 * @date 2020/1/14 2:48 下午
 */
public class DateUtil {

    /**
     * 完整时间 yyyy-MM-dd HH:mm:ss
     */
    public static final String SIMPLE = "yyyy-MM-dd HH:mm:ss";

    /**
     * 年月日(无下划线) yyyyMMdd
     */
    public static final String DTSHORT = "yyyyMMdd";

    /**
     * 获取当天剩余时间/秒
     */
    public static int getOverDaySecond() {
        DateTime dateTime = new DateTime().millisOfDay().withMaximumValue();
        return Seconds.secondsBetween(DateTime.now(), dateTime).getSeconds();
    }

    /**
     * 获取当月剩余的时间/秒
     *
     * @return
     */
    public static long getOverMonthSecond() {
        DateTime dateTime = DateTime.now().dayOfMonth().withMaximumValue().secondOfDay().withMaximumValue();
        return Seconds.secondsBetween(DateTime.now(), dateTime).getSeconds();
    }

    /**
     * 获取系统毫秒数 相当于System.currentTimeMillis()
     *
     * @return
     */
    public static long getSystemCurrentTimeMillis() {
        Clock clock = Clock.systemDefaultZone();
        return clock.millis();
    }

    /**
     * clock 转 java.util.Date
     *
     * @return
     */
    public static Date getDate() {
        Clock clock = Clock.systemDefaultZone();
        Instant instant = clock.instant();
        return Date.from(instant);
    }

    /**
     * 获取今天日期
     *
     * @return 返回格式, 如：2020-01-13
     */
    public static LocalDate getToday() {
        return LocalDate.now();
    }

    /**
     * 获取明天日期
     *
     * @return 返回格式, 如：2020-01-13
     */
    public static LocalDate getTomorrow() {
        return LocalDate.now().plus(NumberConstant.ONE, ChronoUnit.DAYS);
    }

    /**
     * 日期加操作
     *
     * @param temporal
     * @param amountToAdd
     * @param chronoUnit
     * @return
     */
    public static Temporal add(Temporal temporal, long amountToAdd, ChronoUnit chronoUnit) {
        return temporal.plus(amountToAdd, chronoUnit);
    }

    /**
     * 获取昨天日期
     *
     * @return 返回格式, 如：2020-01-13
     */
    public static LocalDate getYesterday() {
        return LocalDate.now().minusDays(NumberConstant.ONE);
    }

    /**
     * 获取某年某月第几天的日期
     *
     * @param year        年份，如：2020
     * @param month       月份，如：1
     * @param dayOfMounth 月中第几天，如：2
     * @return 返回格式, 如：2020-01-02
     */
    public static LocalDate getDate(int year, int month, int dayOfMounth) {
        return LocalDate.of(year, month, dayOfMounth);
    }

    /**
     * 日期格式化
     *
     * @param pattern  指定的格式
     * @param temporal LocalDateTime、LocalDate、LocalTime
     * @return
     */
    public static String format(String pattern, TemporalAccessor temporal) {
        return DateTimeFormatter.ofPattern(pattern).format(temporal);
    }

    /**
     * 比较两个时间的差，Temporal与ChronoUnit要匹配
     *
     * @param chronoUnit 计时单位
     * @param temporal1
     * @param temporal2
     * @return temporal2-temporal1的差
     */
    public static long between(ChronoUnit chronoUnit, Temporal temporal1, Temporal temporal2) {
        return chronoUnit.between(temporal1, temporal2);
    }

    public static void test() {

        long between = ChronoUnit.DAYS.between(getToday(), getTomorrow());
        System.out.println(between);
    }

}
