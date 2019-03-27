package com.wooyoo.learning.design_model.reflect;

import org.junit.Test;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Properties;

public class ReflectTest {

    @Test
    public void reflectTest(){

       /* StaticProxyUser staticProxyUser = new StaticProxyUser(new DbUser());
        Class<? extends StaticProxyUser> aClass = staticProxyUser.getClass();
        System.out.println( "对象.getClass===>"+staticProxyUser.getClass());

        Class<StaticProxyUser> staticProxyUserClass = StaticProxyUser.class;
        System.out.println( "类.class===>"+ staticProxyUserClass);
        System.out.println( aClass == staticProxyUserClass);

        try {
            Class<?> staticProxyUser1 = Class.forName("com.wooyoo.learning.proxyPractice.impl.StaticProxyUser");

            Constructor<?>[] constructors = staticProxyUser1.getDeclaredConstructors();
            try {
                Constructor<?> declaredConstructor = staticProxyUser1.getDeclaredConstructor(null);
                System.out.println("declaredConstructor===>"+declaredConstructor);

            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
            for(Constructor constructor: constructors){

                System.out.println("constructors===>"+constructor);
            }
            System.out.println("Class.forName===>"+staticProxyUser1);
            System.out.println( staticProxyUser1 == staticProxyUserClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
*/

       /* try {
            Class<?> clazz= Class.forName("com.wooyoo.learning.model.dto.FileTree");
           *//* Field[] fields = clazz.getDeclaredFields();

            for(Field file:fields){
                System.out.println("file=====>"+file);
            }
            Field fileName = clazz.getDeclaredField("fileName");
            Object obj= clazz.getConstructor().newInstance();
            fileName.setAccessible(true);
            fileName.set(obj,"文件");
            FileTree fileTree = (FileTree) obj;
            System.out.println("fileTree=====>"+fileTree.getFileName());*//*
            Method fileNameMeethod = clazz.getMethod("setFileName", String.class);
            Object obj= clazz.getConstructor().newInstance();
            fileNameMeethod.invoke(obj,"文件2");
            System.out.println(fileNameMeethod);
            FileTree fileTree = (FileTree) obj;
            System.out.println("fileTree=====>"+fileTree.getFileName());


        } catch (Exception e) {
            e.printStackTrace();
        }
        */


//通过反射获取Class对象
        Class stuClass = null;//"cn.fanshe.Student"
        try {
            stuClass = Class.forName(getValue("className"));
            //2获取show()方法
            Method m = stuClass.getMethod(getValue("methodName"));//show
            //3.调用show()方法
            m.invoke(stuClass.getConstructor().newInstance());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public  String getValue(String key) throws IOException {
        Properties pro = new Properties();//获取配置文件的对象
        FileReader in = new FileReader("D:\\pro.txt");//获取输入流
        pro.load(in);//将流加载到配置文件对象中
        in.close();
        return pro.getProperty(key);//返回根据key获取的value值
    }

    @Test
    public void test(){

        ArrayList<String> strList = new ArrayList<>();
        strList.add("aaa");
        strList.add("bbb");
        //	strList.add(100);
        //获取ArrayList的Class对象，反向的调用add()方法，添加数据
        Class listClass = strList.getClass(); //得到 strList 对象的字节码 对象
        //获取add()方法
        Method m = null;
        try {
            m = listClass.getMethod("add", Object.class);
            m.invoke(strList, 100);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //调用add()方法
        //遍历集合
        for(Object obj : strList){
            System.out.println(obj);
        }
    }


}
