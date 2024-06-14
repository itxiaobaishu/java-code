package com.xiaobai.javacode.distributedLock;

import com.alibaba.fastjson.JSONObject;
import redis.clients.jedis.Jedis;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 简单的去实现了基于Redis的分布式锁功能(肯定存在很多问题)，
 * 其中value保存的是json格式的数据来实现锁的可重入性，这里就会存在一个性能的开销(不断的解析json格式)，
 * 这里存在一个问题是过期时间的设置，如果我们设置的是10，如果某节点获得锁之后，执行的很慢超过了十秒，
 * 此时别的节点就可以获得锁，一种解决方案就是在获得锁的节点中开启一个线程去更新锁的过期时间，
 * 当节点执行完成之后关掉这个线程，如果获取锁的节点宕机之后，也可以通过过期时间来解决。
 *
 * @author xiaobai 2024/06/12 08:47
 */
public class MyLockForRedis implements MyLock {

    private final long TIME_WAIT = 50L;

    @Override
    public void lock(String key) {
        tryLock(key);
    }

    @Override
    public void unlock(String key) {
        Jedis redis = new Jedis("127.0.0.1", 6379);
        String json = redis.get(key);
        LockValue lockValue = JSONObject.parseObject(json, LockValue.class);
        if (getRepeatKeyV().equals(lockValue.getRepeatKey())) {
            if (lockValue.getTime() > 1) {
                lockValue.setTime(lockValue.getTime() - 1);
                redis.set(key, JSONObject.toJSONString(lockValue));
            } else {
                redis.del(key);
            }
        }
        redis.close();
    }

    @Override
    public boolean tryLock(String key) {
        Jedis redis = new Jedis("127.0.0.1", 6379);
        try {
            for (; ; ) {
                //原写法：redis.set(key,JSONObject.toJSONString(new LockValue()),"NX","EX",200000)
                if ("OK".equals(redis.setnx(key, JSONObject.toJSONString(new LockValue())))) {
                    return true;
                } else {
                    String json = redis.get(key);
                    LockValue lockValue = JSONObject.parseObject(json, LockValue.class);
                    if (lockValue != null && getRepeatKeyV().equals(lockValue.getRepeatKey())) {
                        lockValue.setTime(lockValue.getTime() + 1);
                        redis.set(key, JSONObject.toJSONString(lockValue));
                        return true;
                    }
                }
                try {
                    Thread.sleep(TIME_WAIT);
                } catch (InterruptedException e) {
                }
            }
        } finally {
            redis.close();
        }
    }

    private static class LockValue {

        private int time = 1;

        private String repeatKey = getRepeatKeyV();

        public int getTime() {
            return time;
        }

        public void setTime(int time) {
            this.time = time;
        }

        public String getRepeatKey() {
            return repeatKey;
        }

        public void setRepeatKey(String repeatKey) {
            this.repeatKey = repeatKey;
        }

        @Override
        public String toString() {
            return "{time=" + time + ", repeatKey=\"" + repeatKey + "\"}";
        }
    }

    private static String getRepeatKeyV() {
        String host = "";
        try {
            host = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return host + Thread.currentThread().getName();//采用节点ip+线程名来做重入判断 }
    }

}
