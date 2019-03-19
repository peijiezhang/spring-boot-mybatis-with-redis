package com.wooyoo.learning.service.impl;


import com.wooyoo.learning.dao.FileTreeDao;
import com.wooyoo.learning.model.dto.FileDto;
import com.wooyoo.learning.service.FileTreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FileTreeServiceImpl  implements FileTreeService {


    @Autowired
    FileTreeDao fileTreeDao;

    @Override
    public Object getFileTreeList(FileDto fileDto) {

        try{
            return fileTreeDao.getFileTreeList(fileDto);
        }catch (Exception e){

            e.printStackTrace();
            return "service  error";

        }

    }
}
