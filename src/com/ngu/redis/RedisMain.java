package com.ngu.redis;

import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * @Author: 李良超
 * @Date: Created in 2019/4/30 16:07
 * @Description:
 */
public class RedisMain {
    public static void main(String[] args) {
        // 连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost", 6379);
        System.out.println("连接成功！");
        System.out.println("服务运行状态：" + jedis.ping());

        jedis.set("name", "liliangchao");
        System.out.println("my name is " + jedis.get("name"));

        jedis.lpush("list", "user1");
        jedis.lpush("list", "user2");
        jedis.lpush("list", "user3");
        jedis.lpush("list", "user4");
        List<String> list = jedis.lrange("list", 0, 3);
        for (String user : list) {
            System.out.println("user：" + user);
        }
    }
}
