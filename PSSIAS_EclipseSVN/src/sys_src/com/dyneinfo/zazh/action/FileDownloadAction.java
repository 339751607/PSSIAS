package com.dyneinfo.zazh.action;



import java.io.InputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;

public class FileDownloadAction implements Action {

    private String inputPath;
    public void setInputPath(String value) {
        inputPath = value;
    }

    public InputStream getInputStream() throws Exception {
        return ServletActionContext.getServletContext().getResourceAsStream(inputPath);
    }

    public String execute() throws Exception {
        return SUCCESS;
    }
    
}
