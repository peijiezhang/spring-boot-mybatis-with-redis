package com.wooyoo.learning.dao.impl;

import com.wooyoo.learning.dao.FileTreeDao;
import com.wooyoo.learning.model.dto.FileDto;
import com.wooyoo.learning.model.dto.FileTree;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.LinkedList;
import java.util.List;


@Repository
public class FileTreeDaoImpl  implements FileTreeDao {


    @Override
    public Object getFileTreeList(FileDto fileDto) {


        FileTree mainFileTree = new FileTree();

        Object fileTreeList = getChildrenFile(fileDto.getFileRoute(), mainFileTree);

        return fileTreeList;
    }


    // http://cypse.swift.oudianyun.com/read/readTree?a=b#/soaZkTreeList?nsCode=ones2.5-prod&envCode=branch&type=1&zkNamespace=%2F
    // http://      --> scheme也叫protocol  常见的有 file://   ftp  和sftp 协议(ftp 未加密 sftp加密文件的文件传输协议,效率比ftp低)  https加密的http协议
    // cypse.swift.oudianyun.com --> 域名 也是 serverName
    // port 就是  80
    //read/readTree requestUrl
    // ?a=b requestParam
    // #/soaZkTreeList?nsCode=ones2.5-prod&envCode=branch&type=1&zkNamespace=%2F
    public Object  getChildrenFile(String path, FileTree fileTree) {

        List<FileTree> mainTreeList  = new LinkedList<>();
        List<FileTree>  childTreeList  = new LinkedList<>();

        File file = new File(path);
        if (file.exists()) {
            File[] files = file.listFiles();
            if (null == files || files.length == 0) {

                System.out.println("文件夹是空的!");

            } else {
                for (File detailFile : files) {
                    FileTree childrenTree = new FileTree();
                    if (detailFile.isDirectory()) {
                        //childrenTree.setLeaf(false);
                        childrenTree.setDirectory(detailFile.getName());
                        childrenTree.setText(detailFile.getName());
                        childTreeList.add(childrenTree);
                        fileTree.setChildren(childTreeList);

                        getChildrenFile(detailFile.getPath(),childrenTree);
                    } else {

                        fileTree.setLeaf(true);
                        childrenTree.setText(detailFile.getName());
                        childrenTree.setFileName(detailFile.getName());
                        childTreeList.add(childrenTree);
                        fileTree.setChildren(childTreeList);

                    }

                }

                mainTreeList.add(fileTree);
            }
        } else {
            System.out.println("文件不存在!");
        }
        return  mainTreeList;
    }

}
