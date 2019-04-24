package com.wooyoo.learning.util;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.pool2.impl.GenericKeyedObjectPoolConfig;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

public class DBCPUtils {

    private static BasicDataSource dataSource=new BasicDataSource();

    static {
        initDataSource();

    }
    private  static  void  initDataSource(){

        Yaml yaml = new Yaml();
        URL url = DBCPUtils.class.getClassLoader().getResource("application.yml");

        try{
            Map<String,Map<String,Map<String,String>>> map = (Map) yaml.load(new FileInputStream(url.getFile()));
            Map<String, String> datasource = map.get("spring").get("datasource");

            dataSource.setUrl(datasource.get("url"));
            dataSource.setUsername(datasource.get("username"));
            dataSource.setPassword(datasource.get("password"));
            dataSource.setDriverClassName(datasource.get("driver-class-name"));
            //初始连接数
            dataSource.setInitialSize(10);
            // 最大连接数
            dataSource.setMaxTotal(30);
            //最大空闲数
            dataSource.setMaxIdle(10);
            //最小空闲数
            dataSource.setMinIdle(5);
            //最长等待时间(ms)
            //dataSource.setMaxWaitMillis(1000);
            //指定时间内未使用连接则关闭(s)
            dataSource.setRemoveAbandonedTimeout(100);

            dataSource.setTestOnBorrow(true);
            dataSource.setTestOnReturn(true);

            //程序中的连接不使用后是否被连接池回收
            dataSource.setRemoveAbandonedOnBorrow(true);
            dataSource.setRemoveAbandonedOnMaintenance(true);
            //dataSource.setBlo
            //dataSource.set




            //dataSource.setValidationQuery("select dbtime * mysql");
        }catch(Exception e){
            e.printStackTrace();
        }


    }
    public  static Connection getConnection() {

        try{
          return   dataSource.getConnection();
        }catch (Exception e){

            e.printStackTrace();
            throw new RuntimeException(e);

        }
    }



}
