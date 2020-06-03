package com.ultrapower.project.system.sign.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.ultrapower.common.constant.Constants;
import com.ultrapower.common.exception.file.FileNameLengthLimitExceededException;
import com.ultrapower.common.exception.file.InvalidExtensionException;
import com.ultrapower.common.utils.DateUtils;
import com.ultrapower.common.utils.StringUtils;
import com.ultrapower.common.utils.file.FileUploadUtils;
import com.ultrapower.common.utils.file.FileUtils;
import com.ultrapower.common.utils.file.MimeTypeUtils;
import com.ultrapower.common.utils.poi.ExcelUtil;
import com.ultrapower.framework.aspectj.lang.annotation.Log;
import com.ultrapower.framework.aspectj.lang.enums.BusinessType;
import com.ultrapower.framework.config.RuoYiConfig;
import com.ultrapower.framework.web.controller.BaseController;
import com.ultrapower.framework.web.domain.AjaxResult;
import com.ultrapower.framework.web.page.TableDataInfo;
import com.ultrapower.project.system.physecannex.domain.Annex;
import com.ultrapower.project.system.physecsys.domain.PhySecSys;
import com.ultrapower.project.system.sign.domain.FileInfo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import com.ultrapower.project.system.sign.domain.LettersSign;
import com.ultrapower.project.system.sign.service.ILettersSignService;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 责任书和保密协议签署情况Controller
 *
 * @author 王聪
 * @date 2020-06-01
 */
@Controller
@RequestMapping("/system/sign")
public class LettersSignController extends BaseController
{
    private String prefix = "system/sign";

    @Autowired
    private ILettersSignService lettersSignService;

    @RequiresPermissions("system:sign:view")
    @GetMapping()
    public String sign()
    {
        return prefix + "/sign";
    }

    /**
     * 查询责任书和保密协议签署情况列表
     */
    @RequiresPermissions("system:sign:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(LettersSign lettersSign)
    {
        startPage();
        List<LettersSign> list = lettersSignService.selectLettersSignList(lettersSign);
        return getDataTable(list);
    }

    /**
     * 导入责任书和保密协议签署情况
     */
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file) throws Exception
    {
        ExcelUtil<LettersSign> util = new ExcelUtil<LettersSign>(LettersSign.class);
        List<LettersSign> lettersSignList = util.importExcel(file.getInputStream());
        for(LettersSign lettersSign : lettersSignList){
            System.out.println(lettersSign.toString());
            lettersSign.setUuid(UUID.randomUUID().toString().replace("-", ""));
            lettersSign.setLogicdelete("0");
            lettersSign.setCreatetime(getNowDateToString());
            lettersSignService.insertLettersSign(lettersSign);
        }
        return AjaxResult.success("导入成功");
    }
    /**
     * 导出责任书和保密协议签署情况模板
     */
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate() throws Exception
    {
        ExcelUtil<LettersSign> util = new ExcelUtil<LettersSign>(LettersSign.class);
        return util.importTemplateExcel("责任安全书及保密协议签署情况导入模板");
    }
    /**
     * 导出责任书和保密协议签署情况列表
     */
    @RequiresPermissions("system:sign:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(LettersSign lettersSign)
    {
        List<LettersSign> list = lettersSignService.selectLettersSignList(lettersSign);
        ExcelUtil<LettersSign> util = new ExcelUtil<LettersSign>(LettersSign.class);
        return util.exportExcel(list, "责任安全书及保密协议签署情况");
    }

    /**
     * 新增责任书和保密协议签署情况
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存责任书和保密协议签署情况
     */
    @RequiresPermissions("system:sign:add")
    @Log(title = "责任书和保密协议签署情况", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(LettersSign lettersSign, @RequestParam("secretLetterFiles")MultipartFile[] secretLetterFiles, @RequestParam("respLetterFiles")MultipartFile[] respLetterFiles) throws IOException, InvalidExtensionException {
        String uuid= UUID.randomUUID().toString();
        uuid = uuid.replace("-", "");
        lettersSign.setUuid(uuid);
        lettersSign.setLogicdelete("0");
        System.out.println("lettersSign= "+lettersSign);
        //以下是文件上传部分
        String savePath = RuoYiConfig.getUploadPath();//来自配置
        System.out.println("secretLetterFiles大小= "+secretLetterFiles.length);
        for (MultipartFile secretLetterFile:secretLetterFiles) {
            System.out.println(secretLetterFile.getOriginalFilename());
            uploadFile("secretLetters",uuid,secretLetterFile);
        }
        for (MultipartFile respLetterFile:respLetterFiles) {
            System.out.println(respLetterFile.getOriginalFilename());
            uploadFile("respLetters",uuid,respLetterFile);
        }
        lettersSign.setSecretLetter(savePath+"/secretLetters/"+uuid);
        lettersSign.setRespLetter(savePath+"/respLetters/"+uuid);
        lettersSign.setCreatetime(getNowDateToString());
        return toAjax(lettersSignService.insertLettersSign(lettersSign));
    }

    /**
     * 修改责任书和保密协议签署情况
     */
    @GetMapping("/edit/{uuid}")
    public String edit(@PathVariable("uuid") String uuid, ModelMap mmap) throws IOException {
        LettersSign lettersSign = lettersSignService.selectLettersSignById(uuid);
        mmap.put("lettersSign", lettersSign);
        return prefix + "/edit";
    }

    /**
     * 修改保存责任书和保密协议签署情况
     */
    @RequiresPermissions("system:sign:edit")
    @Log(title = "责任书和保密协议签署情况", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(LettersSign lettersSign)
    {
        lettersSign.setModifyTime(getNowDateToString());
        return toAjax(lettersSignService.updateLettersSign(lettersSign));
    }

    /**
     * 删除责任书和保密协议签署情况
     */
    @RequiresPermissions("system:sign:remove")
    @Log(title = "责任书和保密协议签署情况", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(lettersSignService.deleteLettersSignByIds(ids));
    }

    /**
     * 打开详情页
     */
    @GetMapping("/detail/{uuid}")
    public String detail(@PathVariable("uuid") String uuid, ModelMap mmap)
    {
        LettersSign lettersSign = lettersSignService.selectLettersSignById(uuid);
        mmap.put("lettersSign", lettersSign);
        return prefix + "/detail";
    }

    //new
    /**
     * 进入保密协议签署情况页
     */
    @GetMapping("/secretLetters/{uuid}")
    public String secretLetters(@PathVariable("uuid") String uuid, ModelMap mmap){
        LettersSign lettersSign = lettersSignService.selectLettersSignById(uuid);
        mmap.put("lettersSign", lettersSign);
        return prefix + "/secretLetters";
    }
    /**
     * 进入责任书签署情况页
     */
    @GetMapping("/respLetters/{uuid}")
    public String respLetters(@PathVariable("uuid") String uuid, ModelMap mmap){
        LettersSign lettersSign = lettersSignService.selectLettersSignById(uuid);
        mmap.put("lettersSign", lettersSign);
        return prefix + "/respLetters";
    }
    /**
     * 文件添加页
     */
    @GetMapping("/uploadPage/{uuid}/{uploadType}")
    public String uploadPage(@PathVariable("uuid") String uuid, @PathVariable("uploadType") String uploadType,ModelMap mmap) {
        mmap.put("uuid", uuid);
        System.out.println("添加文件，uploadType为"+uploadType);//加上若依配置路径
        mmap.put("uploadType", uploadType);
        return prefix + "/addLetters";
    }

    /**
     * 新增文件
     */
    @PostMapping("/addLetters")
    @ResponseBody
    public AjaxResult addLetters(String uuid, String uploadType, @RequestParam("files")MultipartFile[] files) throws IOException, InvalidExtensionException {
        System.out.println("addLetters ()");
        System.out.println("uuid= "+uuid);
        System.out.println("uploadType= "+uploadType);
        LettersSign lettersSign = lettersSignService.selectLettersSignById(uuid);
        if(lettersSign.getSecretLetter()==null){
            lettersSign.setSecretLetter(RuoYiConfig.getUploadPath()+"/secretLetters/"+uuid);
        }else if(lettersSign.getRespLetter()==null){
            lettersSign.setRespLetter(RuoYiConfig.getUploadPath()+"/respLetters/"+uuid);
        }
        //以下是文件上传部分
        System.out.println("files= "+files.length);
        for (MultipartFile file:files) {
            System.out.println(file.getOriginalFilename());
            uploadFile(uploadType,uuid,file);
        }
        return toAjax(lettersSignService.updateLettersSign(lettersSign));
    }


    /**
     *获取secretLettersList
     */
    @PostMapping("/secretLettersList/{uuid}")
    @ResponseBody
    public TableDataInfo secretLettersList(@PathVariable("uuid") String uuid, ModelMap mmap) throws IOException {
        LettersSign lettersSign = lettersSignService.selectLettersSignById(uuid);
        mmap.put("lettersSign", lettersSign);
        List<FileInfo> secretLetters = null;
        if(lettersSign.getSecretLetter()!=null){
            secretLetters=readfile(lettersSign.getSecretLetter(),"secretLetters",uuid);
        }else{
            secretLetters=new ArrayList<FileInfo>();
        }
        return getDataTable(secretLetters);
    }
    /**
     * 获取respLettersList
     */
    @PostMapping("/respLettersList/{uuid}")
    @ResponseBody
    public TableDataInfo respLettersList(@PathVariable("uuid") String uuid, ModelMap mmap) throws IOException {
        LettersSign lettersSign = lettersSignService.selectLettersSignById(uuid);
        mmap.put("lettersSign", lettersSign);
        List<FileInfo> respLettersList =null;
        if(lettersSign.getRespLetter()!=null){
            respLettersList=readfile(lettersSign.getRespLetter(),"respLetters",uuid);
        }else{
            respLettersList=new ArrayList<FileInfo>();
            //respLettersList.add(new FileInfo());
        }
        return getDataTable(respLettersList);
    }
    /**
     * 删除文件
     */
    @PostMapping( "/removeFile")
    @ResponseBody
    public AjaxResult removeFile(String filePath)
    {
        System.out.println("删除"+RuoYiConfig.getUploadPath()+"/"+filePath);//加上若依配置路径
        return toAjax(FileUtils.deleteFile(RuoYiConfig.getUploadPath()+"/"+filePath));
    }

    //工具类
    //文件上传
    public static void uploadFile(String saveType,String signUuid, MultipartFile file) throws InvalidExtensionException, IOException {
        int fileNamelength = file.getOriginalFilename().length();
        if (fileNamelength > FileUploadUtils.DEFAULT_FILE_NAME_LENGTH)
        {
            throw new FileNameLengthLimitExceededException(FileUploadUtils.DEFAULT_FILE_NAME_LENGTH);
        }
        //判断文件类型
        //FileUploadUtils.assertAllowed(file, new String[]{"bmp", "gif", "jpg", "jpeg", "png"});
        FileUploadUtils.assertAllowed(file,MimeTypeUtils.DEFAULT_ALLOWED_EXTENSION);
        String fileName = file.getOriginalFilename();
        //整理自定义部分的文件路径
        fileName = saveType + File.separator + signUuid +File.separator+ fileName;
        //接入若依文件上传配置的根路径，并准备创建文件
        File desc = new File(RuoYiConfig.getUploadPath() + File.separator + fileName);
        //不存在时，创建文件夹
        if (!desc.getParentFile().exists())
        {
            desc.getParentFile().mkdirs();
        }
        //不存在时，创建文件
        if (!desc.exists())
        {
            desc.createNewFile();
        }
        //文件传送
        file.transferTo(desc);
    }
    //文件读取(转为List<fileInfo>)
    public static List<FileInfo> readfile(String filepath,String fileType,String uuid) throws FileNotFoundException, IOException {
        List<FileInfo> fileInfoList=new ArrayList<FileInfo>();
        try {
            File file = new File(filepath);
            if (!file.isDirectory()) {
                System.out.println("文件");
                /*System.out.println("path=" + file.getPath());
                System.out.println("absolutepath=" + file.getAbsolutePath());
                System.out.println("name=" + file.getName());*/
            } else if (file.isDirectory()) {
                System.out.println("文件夹");
                String[] filelist = file.list();
                for (int i = 0; i < filelist.length; i++) {
                    File readfile = new File(filepath + "\\" + filelist[i]);
                    if (!readfile.isDirectory()) {
                        //System.out.println("absolutepath="+ readfile.getAbsolutePath());
                        //System.out.println("name=" + readfile.getName());

                        //fileInfoList.add(new FileInfo(readfile.getName(),readfile.getAbsolutePath()));
                        //这里需要修改一下变成传入文件类型和uuid的
                        fileInfoList.add(new FileInfo(readfile.getName(),fileType+"/"+uuid+"/"+readfile.getName()));
                    } else if (readfile.isDirectory()) {
                        readfile(filepath + "\\" + filelist[i],fileType,uuid);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("readfile()   Exception:" + e.getMessage());
        }
        return fileInfoList;
    }
    @GetMapping("/download/{filePath}")
    public void resourceDownload(@PathVariable("filePath")String filePath, HttpServletRequest request, HttpServletResponse response)
            throws Exception
    {
        // 本地资源路径
        //String localPath = RuoYiConfig.getProfile();
        // 数据库资源地址
        //String downloadPath = localPath + StringUtils.substringAfter(filePath, Constants.RESOURCE_PREFIX);
        // 下载名称
        String downloadName = StringUtils.substringAfterLast(filePath, "/");
        response.setCharacterEncoding("utf-8");
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition",
                "attachment;fileName=" + FileUtils.setFileDownloadHeader(request, downloadName));
        FileUtils.writeBytes(filePath, response.getOutputStream());
    }

    //工具方法，获取时间并转为String
    public String getNowDateToString(){
        Date date = new Date();
        String strDateFormat = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
        return sdf.format(date);
    }

}
