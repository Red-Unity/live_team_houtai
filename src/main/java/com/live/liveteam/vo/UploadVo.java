package com.live.liveteam.vo;


import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

/**
 * 作者：木木豹
 * 时间2019-09-05 16:37
 * 描述：图片返回实体类
 */
public class UploadVo {

    @ApiModelProperty(value = "文件路径")
    private String url;
    @ApiModelProperty(value = "文件原名称")
    private String fileName;
    @ApiModelProperty(value = "文件类型")
    private String fileType;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }
}
