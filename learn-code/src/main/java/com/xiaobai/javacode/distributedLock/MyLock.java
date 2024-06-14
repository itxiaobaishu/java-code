package com.xiaobai.javacode.distributedLock;

/**
 * description
 *
 * @author xiaobai 2024/06/12 08:41
 */
public interface MyLock {

    void lock(String key);

    void unlock(String key);

    boolean tryLock(String key);

}
