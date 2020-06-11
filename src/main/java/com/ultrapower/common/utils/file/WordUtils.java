package com.ultrapower.common.utils.file;

import com.deepoove.poi.XWPFTemplate;
import com.ultrapower.common.utils.Md5Utils;
import com.ultrapower.common.utils.StringUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.Assert;

import java.io.File;
import java.io.InputStream;

public class WordUtils {

    private static int counter = 0;

    /**
     * 根据模板填充内容生成word
     * 调用方法参考下面的main方法，详细文档参考官方文档
     * Poi-tl模板引擎官方文档：http://deepoove.com/poi-tl/
     *
     * @param templatePath word模板文件路径
     * @param fileDir      生成的文件存放地址
     * @param fileName     生成的文件名,不带格式。假如要生成abc.docx，则fileName传入abc即可
     * @param datas     替换的参数集合
     * @return 生成word成功返回生成的文件的路径，失败返回空字符串
     */
    public static String createWord(String templatePath, String fileDir, String fileName, Object datas) throws Exception{

        Assert.notNull(templatePath, "word模板文件路径不能为空");
        Assert.notNull(fileDir, "生成的文件存放地址不能为空");
        Assert.notNull(fileName, "生成的文件名不能为空");

        File dir = new File(fileDir);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        String filePath = fileDir + fileName;

        ClassPathResource classPathResource = new ClassPathResource(templatePath);
        InputStream inputStream = classPathResource.getInputStream();
        XWPFTemplate template = XWPFTemplate.compile(inputStream).render(datas);
        // 将填充之后的模板写入filePath
        template.writeToFile(filePath);
        template.close();

        return filePath;
    }

    /**
     * 编码文件名
     */
    public static String encodingFilename(String filename) {
        String extension = FilenameUtils.getExtension(filename);
        if (StringUtils.isEmpty(extension))
        {
            extension = MimeTypeUtils.getExtension(filename);
        }
        filename = filename.replace("." + extension, "");
        filename = Md5Utils.hash(filename + System.nanoTime() + counter++) + "." + extension;
        return filename;
    }

}
