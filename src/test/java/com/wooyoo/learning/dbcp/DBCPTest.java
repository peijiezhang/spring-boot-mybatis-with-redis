package com.wooyoo.learning.dbcp;

import com.wooyoo.learning.util.DBCPUtils;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.junit.Test;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.concurrent.*;

public class DBCPTest {


    @Test
    public  void test() throws InterruptedException {


     /*   Yaml yaml = new Yaml();
        URL url = DBCPUtils.class.getClassLoader().getResource("application.yml");

        try {
            Map<String,Map<String,Map<String,String>>> map = (Map) yaml.load(new FileInputStream(url.getFile()));
            Map<String, String> datasource = map.get("spring").get("datasource");
            System.out.println(datasource.get("url"));
            System.out.println(datasource.get("username"));
            System.out.println(datasource.get("password"));
            System.out.println(datasource.get("driver-class-name"));

        }catch (Exception e){

            new RuntimeException(e);
        }*/

        int maxThreadSize = 3000;
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(maxThreadSize);

        ExecutorService executorService = Executors.newFixedThreadPool( maxThreadSize);




        for ( int i =0 ;i <= 1 ; i++){


            scheduledExecutorService.execute(new Runnable() {
                @Override
                public void run() {
                    Connection connection = DBCPUtils.getConnection();
                    PreparedStatement preparedStatement = null;
                    try {
                        preparedStatement = connection.prepareStatement("select * from user");
                        ResultSet resultSet = preparedStatement.executeQuery();
                        while ( resultSet.next() ){
                            System.out.println(resultSet);
                        }

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }/*finally {
                        try {
                            connection.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }*/

                }
            });

            executorService.execute(new Runnable() {
                @Override
                public void run() {

                }
            });
      /*      scheduledExecutorService.execute( ()->{


                System.out.println(Thread.currentThread().getName() + " begin");


                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " begin");

            });*/

        }


        Thread.sleep(3000*1000);



    }
}
