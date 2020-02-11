package com.xiaobai.javacode.condition;

/**
 * @author xiaobai
 * @description: windows系统 list命令
 * @date 2020/2/11 2:10 下午
 */
public class WindowsListService implements ListService {

    @Override
    public String showListCmd() {
        return "dir";
    }
}
