package com.xiaobai.javacode.condition;

/**
 * @author xiaobai
 * @description: mac系统下的list命令
 * @date 2020/2/11 2:40 下午
 */
public class MacListService implements ListService {

    @Override
    public String showListCmd() {
        return "ls";
    }
}
