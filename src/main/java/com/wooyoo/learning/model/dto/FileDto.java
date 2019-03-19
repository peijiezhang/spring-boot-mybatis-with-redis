package com.wooyoo.learning.model.dto;

import java.io.Serializable;

public class FileDto implements Serializable {

    String fileRoute;

    public String getFileRoute() {
        return fileRoute;
    }

    public void setFileRoute(String fileRoute) {
        this.fileRoute = fileRoute;
    }
}
