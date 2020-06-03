package com.ultrapower.project.system.sign.domain;

import com.ultrapower.framework.aspectj.lang.annotation.Excel;

public class FileInfo {
    private static final long serialVersionUID = 1L;

    /** 文件名 */
    private String fileName;

    /** 文件路径 */
    private String filePath;

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
    public String getFileName() {
        return fileName;
    }
    public String getFilePath() {
        return filePath;
    }

    public FileInfo(String fileName, String filePath) {
        this.fileName = fileName;
        this.filePath = filePath;
    }

    @Override
    public String toString() {
        return "FileInfo{" +
                "fileName='" + fileName + '\'' +
                ", filePath='" + filePath + '\'' +
                '}';
    }
}
