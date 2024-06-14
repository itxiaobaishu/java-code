package com.xiaobai.javacode.distributedLock;

import javax.sql.DataSource;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 简单的去实现了用mysql来做分布式锁的过程(性能不是太友好，也会存在很多问题)，
 * 逻辑就是通过设定需要锁定的资源为主键，加锁的时候往数据库中添加数据，此时只会有添加成功的节点会获得锁，
 * 当调用完成之后删掉数据，也就是表明释放锁。
 * 针对重入锁，采用了一个重入key和重入次数两个字段来实现重入，
 * 如果当前节点已经获得锁，需要再次获得锁的时候，直接对次数+1操作，
 * 释放锁的时候做-1操作。当为1的时候再释放就需要删除节点。
 *
 * @author xiaobai 2024/06/12 08:33
 */
public class MyLockFromMysql implements MyLock {

    private DataSource dataSource;

    public MyLockFromMysql(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void lock(String key) {
        if (!tryLock(key)) {
            throw new RuntimeException();
        }
    }

    @Override
    public void unlock(String key) {
        String repeatKey = getRepeatKey();
        if (hasRepeatLock(key, repeatKey)) {
            updateLock(key, repeatKey, -1);
        } else if (!deleteLock(key, repeatKey)) {
            throw new RuntimeException();
        }
    }

    @Override
    public boolean tryLock(String key) {
        String repeatKey = getRepeatKey();
        if (hasLock(key, repeatKey)) {
            return updateLock(key, repeatKey, 1);
        }
        for (; ; ) {
            if (addLock(key, repeatKey)) {
                break;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
        }
        return true;
    }

    private String getRepeatKey() {
        String host = "";
        try {
            host = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return host + Thread.currentThread().getName();//采用节点ip+线程名来做重入判 断
    }

    /**
     * 根据key和repeatKey判断当前是否已经获得锁 * @param key 锁定的资源
     *
     * @param repeatKey 可重入标识
     * @return
     */
    private boolean hasLock(String key, String repeatKey) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            connection = dataSource.getConnection();
            statement = connection.prepareStatement(
                    "SELECT repeat_time FROM locks WHERE lock_key = ? AND repeat_key =?");
            statement.setString(1, key);
            statement.setString(2, repeatKey);
            rs = statement.executeQuery();
            return rs.next();
        } catch (Exception e) {
            return false;
        } finally {
            close(rs);
            close(statement);
            close(connection);
        }
    }

    /**
     * 判断当前是否有重入锁 * @param key
     *
     * @param repeatKey * @return
     */
    private boolean hasRepeatLock(String key, String repeatKey) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            connection = dataSource.getConnection();
            statement = connection.prepareStatement(
                    "SELECT repeat_time FROM locks WHERE lock_key = ? AND repeat_key =? AND repeat_time>1 ");
            statement.setString(1, key);
            statement.setString(2, repeatKey);
            rs = statement.executeQuery();
            return rs.next();
        } catch (Exception e) {
            return false;
        } finally {
            close(rs);
            close(statement);
            close(connection);
        }
    }

    /**
     * 如果当前线程没有获得锁直接添加一条数据去竞争锁 * @param key 锁定的资源
     *
     * @param repeatKey 可重入标识
     * @return
     */
    private boolean addLock(String key, String repeatKey) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = dataSource.getConnection();
            statement = connection.prepareStatement(
                    "INSERT INTO locks (lock_key, repeat_key, repeat_time, update_time)VALUES( ?,?,1, now())");
            statement.setString(1, key);
            statement.setString(2, repeatKey);
            return statement.executeUpdate() > 0;
        } catch (Exception e) {
            return false;
        } finally {
            close(statement);
            close(connection);
        }
    }

    private boolean updateLock(String key, String repeatKey, int upDown) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = dataSource.getConnection();
            statement = connection.prepareStatement(
                    "UPDATE locks set repeat_time = repeat_time + ?, update_time = now()WHERE lock_key = ? AND repeat_key =?");
            statement.setInt(1, upDown);
            statement.setString(2, key);
            statement.setString(3, repeatKey);
            return statement.executeUpdate() > 0;
        } catch (Exception e) {
            return false;
        } finally {
            close(statement);
            close(connection);
        }
    }

    private boolean deleteLock(String key, String repeatKey) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = dataSource.getConnection();
            statement = connection.prepareStatement("DELETE FROM locks  WHERE lock_key = ? ");
            statement.setString(1, key);
            return statement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            close(statement);
            close(connection);
        }
    }

    private void close(AutoCloseable close) {
        if (close != null) {
            try {
                close.close();
            } catch (Exception e) {
            }
        }
    }
}
