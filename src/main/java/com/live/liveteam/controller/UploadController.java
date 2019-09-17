package com.live.liveteam.controller;


import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.live.liveteam.common.enums.EnumResult;
import com.live.liveteam.common.result.ResultVO;
import com.live.liveteam.common.utils.FastDfsUtil;
import com.live.liveteam.vo.UploadVo;
import org.csource.common.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 作者：木木豹
 * 时间2019-09-03 20:49
 * 描述：
 */
@Controller
@RequestMapping("upload")
public class UploadController {


    @Autowired
    private FastFileStorageClient fastClient;

    /**
     *上传单张图片
     * @param file
     * @throws IOException
     * @throws MyException
     */
    @PostMapping("addupload")
    public ResultVO<UploadVo> UploadFile(MultipartFile file) throws IOException, MyException {
        ResultVO<UploadVo> result = new ResultVO<UploadVo>();
        UploadVo uploadVo = new UploadVo();
        String uploadUrl="";
        if (file!=null){
          uploadUrl = FastDfsUtil.Upload(file);
          uploadVo.setUrl(uploadUrl);
          uploadVo.setFileName(file.getName());
          uploadVo.setFileType(file.getOriginalFilename());
        }
        result.setCode(EnumResult.SUCCESS.getCode());
        result.setMsg(EnumResult.SUCCESS.getMsg());
        result.setData(uploadVo);
        return  result;

    }
}
