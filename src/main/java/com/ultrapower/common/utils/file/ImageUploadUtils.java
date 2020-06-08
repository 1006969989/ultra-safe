package com.ultrapower.common.utils.file;

import com.ultrapower.common.exception.file.FileNameLengthLimitExceededException;
import com.ultrapower.common.exception.file.FileSizeLimitExceededException;
import org.apache.commons.fileupload.FileUploadException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ImageUploadUtils {

    /**
     * 默认大小 1M
     */
    public static final long DEFAULT_MAX_SIZE = 1 * 1024 * 1024;

    /**
     * 默认的文件名最大长度 100
     */
    public static final int DEFAULT_FILE_NAME_LENGTH = 100;

    /**
     * @param file 上传图片文件
     * @param resourcesPath 上传的路径，当前项目的resources/目录下
     * @param imgPath 存在在数据库的图片url，在页面访问的路径
     * @return 返回封装的图片路径
     * */
    public static String uploadImage(MultipartFile file,String resourcesPath,String imgPath) throws Exception{

        // 获取图片原始文件名
        String originalFilename = file.getOriginalFilename();

        if(originalFilename != null && !"".equals(originalFilename)) {

            //上传图片名称长度限制
            int fileNamelength = originalFilename.length();
            if (fileNamelength > FileUploadUtils.DEFAULT_FILE_NAME_LENGTH) {
                throw new FileNameLengthLimitExceededException(FileUploadUtils.DEFAULT_FILE_NAME_LENGTH);
            }

            //判断图片大小
            checkImageSize(file);

            // 获取上传图片的扩展名(jpg/png/...)
            String extension = originalFilename.substring(originalFilename.lastIndexOf(".")+1).toLowerCase();

            //判断是不是图片文件
            boolean flag = FileUploadUtils.isAllowedExtension(extension,MimeTypeUtils.IMAGE_EXTENSION);
            if(!flag){
                throw new FileUploadException("上传的文件不是图片");
            }

            //重新生成文件名
            String fileName = FileUploadUtils.extractFilename(file);
            File desc = getAbsoluteFile(resourcesPath, fileName);
            file.transferTo(desc);

            //项目打成jar包可能不存在src/main/resources/static...目录,路径可能直接是static/... 所以需要判断一下
            ClassPathResource classPathResource = new ClassPathResource("static/img" + File.separator + fileName);
            //如果不存在此图片,则上传
            if(!classPathResource.exists()){
                String path = classPathResource.getPath();
            }
            imgPath = imgPath + fileName;
        }
        return imgPath;
    }

    /**
     * 单个文件的删除
     * @param sourcePath resources目录下的图片路径
     * @param imageClassPath 项目打成jar包之后，图片在resources目录下的路径
     * @param oldImgPath 旧的文件路径
     * */
    public static void deleteImageFile(String sourcePath,String imageClassPath,String oldImgPath) throws Exception{

        String fileName = parseOldImgPath(oldImgPath);

        if(fileName != null) {
            //先删除main/resources下面的图片
            if (sourcePath != null && !"".equals(sourcePath)) {
                File sourceImgFile = new File(sourcePath + File.separator + fileName);
                if (sourceImgFile.exists() && !sourceImgFile.isDirectory()) {
                    sourceImgFile.delete();
                }
            }

            //项目打成jar包之后，直接删除static目录下
            if (imageClassPath != null && !"".equals(imageClassPath)) {
                ClassPathResource classPathResource = new ClassPathResource(imageClassPath + File.separator + fileName);
                if (classPathResource.exists()) {
                    //删除上传的图片
                    File file = classPathResource.getFile();
                    if (file.exists() && !file.isDirectory()) {
                        file.delete();
                    }
                }
            }
        }

    }

    /**
     * 图片大小校验
     * */
    public static void checkImageSize(MultipartFile file) throws Exception{
        if(file == null){
            throw new FileUploadException("file param is null");
        }
        long size = file.getSize();
        if (DEFAULT_MAX_SIZE != -1 && size > DEFAULT_MAX_SIZE)
        {
            throw new FileSizeLimitExceededException(DEFAULT_MAX_SIZE / 1024 / 1024);
        }
    }

    /**
     * 生成文件
     * */
    public static File getAbsoluteFile(String uploadDir, String fileName) throws IOException
    {
        File desc = new File(uploadDir + File.separator + fileName);

        if (!desc.getParentFile().exists())
        {
            desc.getParentFile().mkdirs();
        }
        if (!desc.exists())
        {
            desc.createNewFile();
        }
        return desc;
    }

    /**
     * 解析旧的图片路径，获取文件名称
     * */
    private static String parseOldImgPath(String oldImgPath) throws Exception{
        String fileName = "";

        if(oldImgPath != null && !"".equals(oldImgPath)){
            String[] oldImgPathArr = oldImgPath.split("/");
            //图片路径是2020/06/06/111.png，判断格式是不是有问题
            if(oldImgPathArr.length == 1){
                fileName = oldImgPath;
                return fileName;
            }
            for(int i = oldImgPathArr.length-1; i >= 0; i--){
                if(oldImgPathArr.length - 4 > 0 && i == oldImgPathArr.length-4){
                    fileName = oldImgPathArr[i] + fileName;
                    break;
                }
                fileName =oldImgPathArr[i] + File.separator + fileName;
            }
            if(fileName.endsWith(File.separator)){
                fileName = fileName.substring(0,fileName.length()-1);
            }
        }
        return fileName;
    }

    /**
     * 图片访问的URI，包含服务器地址、端口等
     * */
    public static String getImageReturnUrl(HttpServletRequest request,String module){
        //图片访问的URI，包含服务器地址、端口等
        String returnUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() +"/img/" + module + "/";
        return  returnUrl;
    }

    /**
     * 获取图片上传路径,当前的项目src/main/resources/static/...路径下
     * */
    public static String getImageProjectPath(String module){
        //当前项目路径
        String projectPath = System.getProperty("user.dir");
        String destDir = projectPath + File.separator + "src"+File.separator+"main"+ File.separator +"resources"+File.separator+"static"+ File.separator+"img"+File.separator+ module + File.separator;
        return destDir;
    }

    /**
     * 项目打成jar包之后，classes下的图片相对路径 classes/static/...
     * */
    public static String getImageClassPath(String module){
        //打成jar包之后，classes下的相对路径
        String imageClassPath = "static"+ File.separator+"img"+File.separator+ module + File.separator;
        return imageClassPath;
    }


}
