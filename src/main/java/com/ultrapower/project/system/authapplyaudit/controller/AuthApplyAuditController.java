package com.ultrapower.project.system.authapplyaudit.controller;

import com.ultrapower.common.utils.file.ImageUploadUtils;
import com.ultrapower.common.utils.poi.ExcelUtil;
import com.ultrapower.common.utils.text.Convert;
import com.ultrapower.framework.aspectj.lang.annotation.Log;
import com.ultrapower.framework.aspectj.lang.enums.BusinessType;
import com.ultrapower.framework.web.controller.BaseController;
import com.ultrapower.framework.web.domain.AjaxResult;
import com.ultrapower.framework.web.page.TableDataInfo;
import com.ultrapower.project.system.authapplyaudit.domain.AuthApplyAudit;
import com.ultrapower.project.system.authapplyaudit.service.IAuthApplyAuditService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;


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

    //每一个模块上传图片都会把图片放到img/模块名/...  文件夹中
    private String module = "authapplyaudit";

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
    public AjaxResult addSave(@RequestParam(value = "file", required = false) MultipartFile file, AuthApplyAudit authApplyAudit,HttpServletRequest request) {

        try {
            //图片访问的URI
            String returnUrl = ImageUploadUtils.getImageReturnUrl(request,module);
            //当前项目路径
            String destDir = ImageUploadUtils.getImageProjectPath(module);

            String imagePath = ImageUploadUtils.uploadImage(file, destDir,returnUrl);
            if(imagePath != null && !"".equals(imagePath)){
                authApplyAudit.setAuthApplyImg(imagePath);
            }
        }catch (Exception e){
            e.printStackTrace();
            return error(e.getMessage());
        }

        return toAjax(authApplyAuditService.insertAuthApplyAudit(authApplyAudit));
    }

    /**
     * 修改人员权限申请记录稽核表
     */
    @GetMapping("/edit/{uuid}")
    public String edit(@PathVariable("uuid") String uuid, ModelMap mmap)
    {
        AuthApplyAudit authApplyAudit = authApplyAuditService.selectAuthApplyAuditById(uuid);
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
    public AjaxResult editSave(@RequestParam(value = "file", required = false) MultipartFile file,AuthApplyAudit authApplyAudit,HttpServletRequest request) {

        //先判断图片有没有更新，更新了才上传
        if(file != null && file.getOriginalFilename() != null && !"".equals(file.getOriginalFilename())){
            try {
                //图片访问的URI
                String returnUrl = ImageUploadUtils.getImageReturnUrl(request,module);

                //当前项目路径
                String destDir = ImageUploadUtils.getImageProjectPath(module);
                //打成jar包之后，class下的路径
                String imageClassPath = ImageUploadUtils.getImageClassPath(module);

                //上传新的图片
                String imagePath = ImageUploadUtils.uploadImage(file, destDir,returnUrl);
                String oldImgPath = null;

                //查找原来的图片路径
                AuthApplyAudit audit = authApplyAuditService.selectAuthApplyAuditById(authApplyAudit.getUuid());
                if(audit != null && audit.getAuthApplyImg() != null && !"".equals(audit.getAuthApplyImg())){
                    oldImgPath =audit.getAuthApplyImg();
                }

                //删除原来图片
                if(oldImgPath != null && !"".equals(oldImgPath)){
                    ImageUploadUtils.deleteImageFile(imageClassPath,oldImgPath);
                }
                //成功上传之后，把新图片访问路径保存到数据表中
                if(imagePath != null && !"".equals(imagePath)){
                    authApplyAudit.setAuthApplyImg(imagePath);
                }

            }catch (Exception e){
                e.printStackTrace();
                return error(e.getMessage());
            }
        }
        return toAjax(authApplyAuditService.updateAuthApplyAudit(authApplyAudit));
    }

    /**
     * 删除人员权限申请记录稽核表
     */
    @RequiresPermissions("system:authapplyaudit:remove")
    @Log(title = "人员权限申请记录稽核表", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids) throws IOException{

        try {
            //打成jar包之后，class下的路径
            String imageClassPath = ImageUploadUtils.getImageClassPath(module);

            List<AuthApplyAudit> authApplyAuditList = authApplyAuditService.selectAuthApplyAuditListByIds(Convert.toStrArray(ids));
            if (authApplyAuditList != null && authApplyAuditList.size() > 0) {
                for (int i = 0; i < authApplyAuditList.size(); i++) {
                    AuthApplyAudit authApplyAudit = authApplyAuditList.get(i);
                    String oldImgPath = authApplyAudit.getAuthApplyImg();
                    if (oldImgPath != null && !"".equals(oldImgPath)) {
                        ImageUploadUtils.deleteImageFile(imageClassPath, oldImgPath);
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return toAjax(authApplyAuditService.deleteAuthApplyAuditByIds(ids));
    }

}
