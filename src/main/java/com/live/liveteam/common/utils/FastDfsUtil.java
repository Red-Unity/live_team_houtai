package com.live.liveteam.common.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import com.live.liveteam.common.constant.BizConfiguration;
import com.live.liveteam.common.constant.BizConstant;
import com.live.liveteam.common.enums.EnumResult;
import com.live.liveteam.common.exception.BizException;
import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.FileInfo;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @ClassName: FastDfsUtil
 * @Description: FastDfs文件管理简单工具类
 * @author linyuanbao
 * @date 2018年11月27日 下午6:10:16
 * @version V1.0
 */
public class FastDfsUtil {

    private static TrackerClient trackerClient = null;
    private static TrackerServer trackerServer = null;
    private static StorageServer storageServer = null;
    private static StorageClient storageClient = null;

    static {
        try {
            ClientGlobal.init("fdfs_client.conf");
            trackerClient = new TrackerClient();
            trackerServer = trackerClient.getConnection();
            storageClient = new StorageClient(trackerServer, storageServer);
        } catch (IOException | MyException e) {
            throw new RuntimeException("FastDfs工具类初始化失败!");
        }
    }



    /**
     * 调用上传图片，返回图片路径
     * @param file
     * @return
             * @throws IOException
     * @throws MyException
     */
    public static String Upload(MultipartFile file) {

        String originalFilename = file.getOriginalFilename();
        InputStream inputStream = null;
        String str = null;
        try {
            inputStream = file.getInputStream();
            str = fdfsUpload(inputStream, originalFilename);
        } catch (Exception e) {
            throw new BizException(EnumResult.UPLOAD_ERROR.getCode(),EnumResult.UPLOAD_ERROR.getMsg());
        }
        String path= BizConfiguration.FASTDFS_PREFIX_URL_HEAD+str;
        return path;
    }

    /**
     *
     * @Title: fdfsUpload
     * @Description: 通过文件流上传文件
     * @param @param inputStream 文件流
     * @param @param filename 文件名称
     * @param @return
     * @param @throws IOException
     * @param @throws MyException
     * @return String 返回文件在FastDfs的存储路径
     * @throws
     */
        public static String fdfsUpload(InputStream inputStream, String filename) throws IOException, MyException{
        String suffix = ""; //后缀名
        try{
            suffix = filename.substring(filename.lastIndexOf(".")+1);
        }catch (Exception e) {
            throw new RuntimeException("参数filename不正确!格式例如：a.png");
        }
        String savepath = ""; //FastDfs的存储路径
        ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
        byte[] buff = new byte[1024];
        int len = 0;
        while ((len = inputStream.read(buff)) != -1) {
            swapStream.write(buff, 0, len);
        }
        byte[] in2b = swapStream.toByteArray();
        String[] strings = storageClient.upload_file(in2b, suffix, null); //上传文件
        for (String str : strings) {
            savepath += "/" + str; //拼接路径
        }
        return savepath;
    }

    /**
     *
     * @Title: fdfsUpload
     * @Description: 本地文件上传
     * @param @param filepath 本地文件路径
     * @param @return
     * @param @throws IOException
     * @param @throws MyException
     * @return String 返回文件在FastDfs的存储路径
     * @throws
     */
    public static String fdfsUpload(String filepath) throws IOException, MyException{
        String suffix = ""; //后缀名
        try{
            suffix = filepath.substring(filepath.lastIndexOf(".")+1);
        }catch (Exception e) {
            throw new RuntimeException("上传的不是文件!");
        }
        String savepath = ""; //FastDfs的存储路径
        String[] strings = storageClient.upload_file(filepath, suffix, null); //上传文件
        for (String str : strings) {
            savepath += "/" + str; //拼接路径
        }
        return savepath;
    }

    /**
     *
     * @Title: fdfsDownload
     * @Description: 下载文件到目录
     * @param @param savepath 文件存储路径
     * @param @param localPath 下载目录
     * @param @return
     * @param @throws IOException
     * @param @throws MyException
     * @return boolean 返回是否下载成功
     * @throws
     */
    public static boolean fdfsDownload(String savepath, String localPath) throws IOException, MyException{
        String group = ""; //存储组
        String path = ""; //存储路径
        try{
            int secondindex = savepath.indexOf("/", 2); //第二个"/"索引位置
            group = savepath.substring(1, secondindex); //类似：group1
            path = savepath.substring(secondindex + 1); //类似：M00/00/00/wKgBaFv9Ad-Abep_AAUtbU7xcws013.png
        }catch (Exception e) {
            throw new RuntimeException("传入文件存储路径不正确!格式例如：/group1/M00/00/00/wKgBaFv9Ad-Abep_AAUtbU7xcws013.png");
        }
        int result = storageClient.download_file(group, path, localPath);
        if(result != 0){
            throw new RuntimeException("下载文件失败：文件路径不对或者文件已删除!");
        }
        return true;
    }

    /**
     *
     * @Title: fdfsDownload
     * @Description: 返回文件字符数组
     * @param @param savepath 文件存储路径
     * @param @return
     * @param @throws IOException
     * @param @throws MyException
     * @return byte[] 字符数组
     * @throws
     */
    public static byte[] fdfsDownload(String savepath) throws IOException, MyException{
        byte[] bs = null;
        String group = ""; //存储组
        String path = ""; //存储路径
        try{
            int secondindex = savepath.indexOf("/", 2); //第二个"/"索引位置
            group = savepath.substring(1, secondindex); //类似：group1
            path = savepath.substring(secondindex + 1); //类似：M00/00/00/wKgBaFv9Ad-Abep_AAUtbU7xcws013.png
        }catch (Exception e) {
            throw new RuntimeException("传入文件存储路径不正确!格式例如：/group1/M00/00/00/wKgBaFv9Ad-Abep_AAUtbU7xcws013.png");
        }
        bs = storageClient.download_file(group, path); //返回byte数组
        return bs;
    }

    /**
     *
     * @Title: fdfsDeleteFile
     * @Description: 删除文件
     * @param @param savepath 文件存储路径
     * @param @return
     * @param @throws IOException
     * @param @throws MyException
     * @return boolean 返回true表示删除成功
     * @throws
     */
    public static boolean fdfsDeleteFile(String savepath) throws IOException, MyException{
        String group = ""; //存储组
        String path = ""; //存储路径
        try{
            int secondindex = savepath.indexOf("/", 2); //第二个"/"索引位置
            group = savepath.substring(1, secondindex); //类似：group1
            path = savepath.substring(secondindex + 1); //类似：M00/00/00/wKgBaFv9Ad-Abep_AAUtbU7xcws013.png
        }catch (Exception e) {
            throw new RuntimeException("传入文件存储路径不正确!格式例如：/group1/M00/00/00/wKgBaFv9Ad-Abep_AAUtbU7xcws013.png");
        }
        int result = storageClient.delete_file(group, path); //删除文件，0表示删除成功
        if(result != 0){
            throw new RuntimeException("删除文件失败：文件路径不对或者文件已删除!");
        }
        return true;
    }

    /**
     *
     * @Title: fdfdFileInfo
     * @Description: 返回文件信息
     * @param @param savepath 文件存储路径
     * @param @return
     * @param @throws IOException
     * @param @throws MyException
     * @return FileInfo 文件信息
     * @throws
     */
    public static FileInfo fdfdFileInfo(String savepath) throws IOException, MyException{
        String group = ""; //存储组
        String path = ""; //存储路径
        try{
            int secondindex = savepath.indexOf("/", 2); //第二个"/"索引位置
            group = savepath.substring(1, secondindex); //类似：group1
            path = savepath.substring(secondindex + 1); //类似：M00/00/00/wKgBaFv9Ad-Abep_AAUtbU7xcws013.png
        }catch (Exception e) {
            throw new RuntimeException("传入文件存储路径不正确!格式例如：/group1/M00/00/00/wKgBaFv9Ad-Abep_AAUtbU7xcws013.png");
        }
        FileInfo fileInfo = storageClient.get_file_info(group, path);
        return fileInfo;
    }




}