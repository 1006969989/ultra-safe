package com.ultrapower.project.system.authapplyaudit.controller;

import java.io.*;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

import com.ultrapower.common.utils.poi.ExcelUtil;
import com.ultrapower.common.utils.text.Convert;
import com.ultrapower.framework.aspectj.lang.annotation.Log;
import com.ultrapower.framework.aspectj.lang.enums.BusinessType;
import com.ultrapower.framework.web.controller.BaseController;
import com.ultrapower.framework.web.domain.AjaxResult;
import com.ultrapower.framework.web.page.TableDataInfo;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import com.ultrapower.project.system.authapplyaudit.domain.AuthApplyAudit;
import com.ultrapower.project.system.authapplyaudit.service.IAuthApplyAuditService;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 人员权限申请记录稽核表Controller
 *
 * @author ruoyi
 * @date 2020-05-27
 */
@Controller
@RequestMapping("/system/authapplyaudit")
public class AuthApplyAuditController extends BaseController
{
    private String prefix = "system/authapplyaudit";

    @Autowired
    private IAuthApplyAuditService authApplyAuditService;

    @RequiresPermissions("system:authapplyaudit:view")
    @GetMapping()
    public String authapplyaudit()
    {
        return prefix + "/authapplyaudit";
    }

    /**
     * 查询人员权限申请记录稽核表列表
     */
    @RequiresPermissions("system:authapplyaudit:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(AuthApplyAudit authApplyAudit)
    {
        startPage();
        List<AuthApplyAudit> list = authApplyAuditService.selectAuthApplyAuditList(authApplyAudit);
        if(list !=null && list.size() > 0){

        }
        return getDataTable(list);
    }

    /**
     * 导出人员权限申请记录稽核表列表
     */
    @RequiresPermissions("system:authapplyaudit:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(AuthApplyAudit authApplyAudit)
    {
        List<AuthApplyAudit> list = authApplyAuditService.selectAuthApplyAuditList(authApplyAudit);
        ExcelUtil<AuthApplyAudit> util = new ExcelUtil<AuthApplyAudit>(AuthApplyAudit.class);
        return util.exportExcel(list, "authapplyaudit");
    }

    /**
     * 新增人员权限申请记录稽核表
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存人员权限申请记录稽核表
     */
    @RequiresPermissions("system:authapplyaudit:add")
    @Log(title = "人员权限申请记录稽核表", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@RequestParam(value = "file", required = false) MultipartFile file, AuthApplyAudit authApplyAudit) {

        try {
            if(file != null){
                uploadImg(file,authApplyAudit);
            }

            return toAjax(authApplyAuditService.insertAuthApplyAudit(authApplyAudit));
        } catch (Exception e) {
            String msg = "数据添加失败";
            e.printStackTrace();
            return error(msg);
        }
    }

    /**
     * 修改人员权限申请记录稽核表
     */
    @GetMapping("/edit/{uuid}")
    public String edit(@PathVariable("uuid") String uuid, ModelMap mmap)
    {
        AuthApplyAudit authApplyAudit = authApplyAuditService.selectAuthApplyAuditById(uuid);
        try {
            if (authApplyAudit == null) {
                authApplyAudit = new AuthApplyAudit();
            } else {
                if(authApplyAudit.getAuthApplyImg() != null && !"".equals(authApplyAudit.getAuthApplyImg())){
                    String imgPath = authApplyAudit.getAuthApplyImg();
                    if(imgPath.indexOf("static") != -1){
                        imgPath = imgPath.substring(7,imgPath.length());
                        mmap.put("imgPath",imgPath);
                    }else {
                        mmap.put("imgPath",authApplyAudit.getAuthApplyImg());
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        mmap.put("authApplyAudit", authApplyAudit);
        return prefix + "/edit";
    }

    /**
     * 修改保存人员权限申请记录稽核表
     */
    @RequiresPermissions("system:authapplyaudit:edit")
    @Log(title = "人员权限申请记录稽核表", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@RequestParam(value = "file", required = false) MultipartFile file,AuthApplyAudit authApplyAudit) {
        AuthApplyAudit audit = authApplyAuditService.selectAuthApplyAuditById(authApplyAudit.getUuid());
        if(audit == null || audit.getUuid() == null){
            String msg = "不存在这条数据";
            return error(msg);
        }
        //原来的图片
        String originalImgPath = audit.getAuthApplyImg();
        try{
            //上传图片
            if(file != null){
                uploadImg(file,authApplyAudit);
                //判断有没有修改图片，有就删除原来的图片
                String originalFilename = file.getOriginalFilename();
                if(originalFilename != null && !"".equals(originalFilename)){
                    if(originalImgPath != null && !"".equals(originalImgPath)){
                        deleteImg(originalImgPath);
                    }
                }
            }
            return toAjax(authApplyAuditService.updateAuthApplyAudit(authApplyAudit));
        }catch (Exception e){
            String msg = "数据编辑失败";
            e.printStackTrace();
            return error(msg);
        }

    }

    /**
     * 删除人员权限申请记录稽核表
     */
    @RequiresPermissions("system:authapplyaudit:remove")
    @Log(title = "人员权限申请记录稽核表", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids) throws IOException{
        List<AuthApplyAudit> authApplyAuditList = authApplyAuditService.selectAuthApplyAuditListByIds(Convert.toStrArray(ids));
        if(authApplyAuditList != null && authApplyAuditList.size() > 0){
            for(int i = 0; i < authApplyAuditList.size();i++) {
                AuthApplyAudit authApplyAudit = authApplyAuditList.get(i);
                String imgUrl = authApplyAudit.getAuthApplyImg();
                // 图片上传的路径
                if(imgUrl == null || "".equals(imgUrl)){
                    continue;
                }
                ClassPathResource classPathResource = new ClassPathResource(imgUrl);
                if(classPathResource.exists()){
                    //删除上传的图片
                    File file = classPathResource.getFile();
                    if(file.exists() && !file.isDirectory()){
                        file.delete();
                    }
                }
            }
        }
        return toAjax(authApplyAuditService.deleteAuthApplyAuditByIds(ids));
    }

    public void uploadImg(MultipartFile file,AuthApplyAudit authApplyAudit) throws Exception{

        File targetFile = null;
        // 获取图片原始文件名
        String originalFilename = file.getOriginalFilename();

        if(originalFilename != null && !"".equals(originalFilename)) {
            // 获取上传图片的扩展名(jpg/png/...)
            String extension = originalFilename.substring(originalFilename.lastIndexOf(".")).toLowerCase();

            // 文件名使用当前时间
            String fileName = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()) + new Random().nextInt(1000) + extension;

            String projectPath = System.getProperty("user.dir").replaceAll("\\\\", "/");
            // 图片上传的相对路径（因为相对路径放到页面上就可以显示图片）
            String path = projectPath + "/src/main/resources/static/img/authapplyaudit";

            File dir = new File(path);
            if (!dir.exists() && !dir.isDirectory()) {
                dir.mkdir();
            }
            //将图片存入文件夹
            targetFile = new File(dir, fileName);
            file.transferTo(targetFile);
            // 保存resources目录下的图片路径
            String imgUrl = "static/img/authapplyaudit/" + fileName;
            authApplyAudit.setAuthApplyImg(imgUrl);
        }
    }

    public void deleteImg(String imgPath) throws Exception{
        // 图片上传的路径
        if(imgPath == null || "".equals(imgPath)){
            return;
        }
        ClassPathResource classPathResource = new ClassPathResource(imgPath);
        if(classPathResource.exists()){
            //删除上传的图片
            File file = classPathResource.getFile();
            if(file.exists() && !file.isDirectory()){
                file.delete();
            }
        }
    }
}
