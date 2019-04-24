package com.wooyoo.learning.redis;


import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

import java.util.ArrayList;
import java.util.List;

public class RedisPractice2 {

    public  static void main(String args[]){

        // 构建连接池配置信息
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        // 设置最大连接数
        poolConfig.setMaxTotal(50);

        //定义集群信息
        List<JedisShardInfo> shards = new ArrayList<JedisShardInfo>();
        shards.add(new JedisShardInfo("192.168.8.18",16389));

        // 定义集群连接池
        ShardedJedisPool shardedJedisPool = new ShardedJedisPool(poolConfig, shards);
        ShardedJedis shardedJedis = null;

        // 从连接池中获取到jedis分片对象
        shardedJedis =shardedJedisPool.getResource();

        System.out.println(shardedJedis.smembers("sets"));
    }

}
