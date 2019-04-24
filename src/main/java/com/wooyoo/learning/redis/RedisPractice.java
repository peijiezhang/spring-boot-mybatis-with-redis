package com.wooyoo.learning.redis;

import com.alibaba.fastjson.JSON;
import com.wooyoo.learning.jsonModel.User;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.Iterator;
import java.util.Set;

public class RedisPractice {


    public static  void main(String args[]){

        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("192.168.8.18",16389);
        System.out.println("连接成功");

        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(5);
        config.setMaxTotal(100);


        config.setTestOnBorrow(false);



       JedisPool jedisPool = new JedisPool(config,"192.168.8.18",16389);

        User user = new User();
       user.setName("asd");
       jedis.set("asdasda" , JSON.toJSONString(user));

        String data = jedis.get("asdasda");



        jedis.set("hello","你好");
        jedis.expire("hello",10);
        //批量插入数据
        jedis.mset("key1","value1", "key2","value2","key3","value3","key4","value4");



        System.out.println("一次性删除key1,key2："+jedis.del(new String[]{"key1", "key2"}));
        String hello = jedis.get("hello");
        //查看服务是否运行
        System.out.println("服务正在运行: "+jedis.ping());
        System.out.println("获得数据: "+ hello);
        System.out.println("是否存在: "+jedis.exists("hello"));

        System.out.println("向sets集合中加入元素element1："+jedis.sadd("sets", "element1"));
        System.out.println("向sets集合中加入元素element1："+jedis.sadd("sets", "element1"));
        System.out.println("向sets集合中加入元素element2："+jedis.sadd("sets", "element2"));
        System.out.println("向sets集合中加入元素element3："+jedis.sadd("sets", "element3"));
        System.out.println("向sets集合中加入元素element4："+jedis.sadd("sets", "element4"));
        System.out.println("集合sets中删除元素element3："+jedis.srem("sets", "element3"));
        System.out.println("查看sets集合中的所有元素:"+jedis.smembers("sets"));
        System.out.println("判断element001是否在集合sets中："+jedis.sismember("sets", "element1"));

        Set<String> set = jedis.smembers("sets");
        Iterator<String> it=set.iterator() ;
        while(it.hasNext()){
            Object obj=it.next();
            System.out.println(obj);
        }


        System.out.println("SortedSet  ====================");
        System.out.println("zset中添加元素element001："+jedis.zadd("zset", 7.0, "element1"));
        System.out.println("zset中添加元素element002："+jedis.zadd("zset", 8.0, "element2"));
        System.out.println("zset中添加元素element003："+jedis.zadd("zset", 2.0, "element3"));
        System.out.println("zset中添加元素element004："+jedis.zadd("zset", 3.0, "element4"));
        System.out.println("zset集合中的所有元素："+jedis.zrange("zset", 0, -1));//按照权重值排序

        System.out.println("统计zset集合中的元素中个数："+jedis.zcard("zset"));
        System.out.println("统计zset集合中权重某个范围内（1.0——5.0），元素的个数："+jedis.zcount("zset", 1.0, 5.0));
        System.out.println("查看zset集合中element004的权重："+jedis.zscore("zset", "element004"));
        System.out.println("查看下标1到2范围内的元素值："+jedis.zrange("zset", 1, 2));



        System.out.println("Hash ====================");
        System.out.println("hashs中添加key001和value001键值对："+jedis.hset("hashs", "key001", "value001"));
        System.out.println("hashs中添加key002和value002键值对："+jedis.hset("hashs", "key002", "value002"));
        System.out.println("hashs中添加key003和value003键值对："+jedis.hset("hashs", "key003", "value003"));
        System.out.println("新增key004和4的整型键值对："+jedis.hincrBy("hashs", "key004", 4l));
        System.out.println("hashs中的所有值："+jedis.hvals("hashs"));

        System.out.println("hashs中删除key002键值对："+jedis.hdel("hashs", "key002"));
        System.out.println("hashs中的所有值："+jedis.hvals("hashs"));

        System.out.println("key004整型键值的值增加100："+jedis.hincrBy("hashs", "key004", 100l));
        System.out.println("hashs中的所有值："+jedis.hvals("hashs"));


        System.out.println("判断key003是否存在："+jedis.hexists("hashs", "key003"));
        System.out.println("获取key004对应的值："+jedis.hget("hashs", "key004"));
        System.out.println("批量获取key001和key003对应的值："+jedis.hmget("hashs", "key001", "key003"));
        System.out.println("获取hashs中所有的key："+jedis.hkeys("hashs"));
        System.out.println("获取hashs中所有的value："+jedis.hvals("hashs"));



    }
}
