package com.wooyoo.learning.controller;

import com.wooyoo.learning.data.Person;
import com.wooyoo.learning.model.dto.FileDto;
import com.wooyoo.learning.service.FileTreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/fileTree")
public class FileTreeController {


    @Autowired
    Person person;


    @Value("${jdbc.password}")
    String username;

    @Autowired
    FileTreeService fileTreeService;

    @RequestMapping("/getList")
    public Object getFileList(@RequestBody FileDto fileDto, HttpServletRequest request){

        try {

            return  fileTreeService.getFileTreeList(fileDto);
        }catch (Exception e){
            e.printStackTrace();
            return  " controller error";

        }

    }


    public static void main(String[] args) {


        //new FileTreeController().getFileList();

        Method method = null;

        Map<String,Method> map = new HashMap<>();
        map.put("getList",method);
        map.put("getList2",method);
        map.put("getList3",method);


        //

        ApplicationContext applicationContext;

        method.getDeclaringClass(); // FileTreeController.class
        method.getClass(); // Method.class



        //method.invoke(new FileTreeController(),new Object[]{});


        System.out.println();


    }




}
