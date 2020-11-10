package com.xiaobai.javacode.condition;

/**
 * @author xiaobai
 * @description: linux系统下的list命令
 * @date 2020/2/11 2:12 下午
 */
public class LinuxListService implements ListService {

    @Override
    public String showListCmd() {
        return "ls";
    }
}
