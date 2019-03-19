package com.wooyoo.learning.controller;

import com.wooyoo.learning.model.dto.FileDto;
import com.wooyoo.learning.service.FileTreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fileTree")
public class FileTreeController {


    @Autowired
    FileTreeService fileTreeService;

    @RequestMapping("/getList")
    public Object getFileList(@RequestBody FileDto fileDto){

        try {
            return  fileTreeService.getFileTreeList(fileDto);
        }catch (Exception e){
            e.printStackTrace();
            return  " controller error";

        }

    }




}
