package com.wooyoo.learning.model.dto;

import java.io.File;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class FileTree  extends  CommTree{

    private String directory;
    private String fileName;

    public FileTree() {
    }

    public FileTree(String directory, String fileName){
        this.directory = directory;
        this.fileName = fileName;


    }

    public String getDirectory() {
        return directory;
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }

    public String getFileName() {
     /*   System.out.println("hhhhhhhhhhh");*/
        return fileName;

    }

    public void setFileName(String fileName) {
        this.fileName = fileName;

    }

    public static void main(String[] args) {

        FileTree fileTree = new FileTree();

        for (Method method : fileTree.getClass().getMethods()) {

            Modifier.isStatic(method.getModifiers());
            Modifier.isPublic( method.getModifiers());

            //FileTree.print();
            //new FileTree().print();
            System.out.println(method);
        }



    }
}
