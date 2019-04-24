package com.wooyoo.learning.memcached;

import net.spy.memcached.CASResponse;
import net.spy.memcached.CASValue;
import net.spy.memcached.MemcachedClient;
import net.spy.memcached.internal.OperationFuture;

import java.net.InetSocketAddress;
import java.util.concurrent.Future;

public class MemcachedJava {

    public static void main(String[] args) {
        try{



            // 本地连接 Memcached 服务
            MemcachedClient mcc = new MemcachedClient(new InetSocketAddress("192.168.8.18", 11211));
            System.out.println("Connection to server sucessful.");

            Future fo = mcc.set("runoob", 900, "Free Education");


            // 查看存储状态
            System.out.println("set status:" + fo.get());

            // 输出值
            System.out.println("runoob value in cache - " + mcc.get("runoob"));

            // 添加
            fo = mcc.add("runoob", 900, "memcached");

            // 打印状态
            System.out.println("add status:" + fo.get());

            // 添加新key
            fo = mcc.add("codingground", 900, "All Free Compilers");

            // 打印状态
            System.out.println("add status:" + fo.get());

            // 输出
            System.out.println("codingground value in cache - " + mcc.get("codingground"));



            // 添加新的 key
            fo = mcc.replace("runoob", 900, "Largest Tutorials' Library");

            // 输出执行 set 方法后的状态
            System.out.println("replace status:" + fo.get());

            // 获取键对应的值
            System.out.println("runoob value in cache - " + mcc.get("runoob"));



            // 输出执行 set 方法后的状态
            System.out.println("append status:" + fo.get());

            // 获取键对应的值
            System.out.println("runoob value in cache - " + mcc.get("codingground"));


            // 通过 gets 方法获取 CAS token（令牌）
            CASValue casValue = mcc.gets("runoob");

            // 输出 CAS token（令牌） 值
            System.out.println("CAS token - " + casValue);

            // 尝试使用cas方法来更新数据
            CASResponse casresp = mcc.cas("runoob", casValue.getCas(), 900, "Largest Tutorials-Library");

            // 输出 CAS 响应信息
            System.out.println("CAS Response - " + casresp);

            // 输出值
            System.out.println("runoob value in cache - " + mcc.get("runoob"));

            // 关闭连接
            mcc.shutdown();
        }catch(Exception ex){
            System.out.println( ex.getMessage() );
        }
    }
}
