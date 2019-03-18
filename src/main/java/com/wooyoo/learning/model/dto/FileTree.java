package com.wooyoo.learning.model.dto;

import java.io.File;

public class FileTree  extends  CommTree{

    String directory;
    String fileName;

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
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
