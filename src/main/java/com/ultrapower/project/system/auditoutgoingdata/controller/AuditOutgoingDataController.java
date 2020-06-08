package com.ultrapower.project.system.auditoutgoingdata.controller;

import com.ultrapower.common.exception.BusinessException;
import com.ultrapower.common.utils.file.ImageUploadUtils;
import com.ultrapower.common.utils.poi.ExcelUtil;
import com.ultrapower.common.utils.text.Convert;
import com.ultrapower.framework.aspectj.lang.annotation.Log;
import com.ultrapower.framework.aspectj.lang.enums.BusinessType;
import com.ultrapower.framework.web.controller.BaseController;
import com.ultrapower.framework.web.domain.AjaxResult;
import com.ultrapower.framework.web.page.TableDataInfo;
import com.ultrapower.project.system.auditoutgoingdata.domain.AuditOutgoingData;
import com.ultrapower.project.system.auditoutgoingdata.service.IAuditOutgoingDataService;
import com.ultrapower.project.system.user.domain.User;
import org.apache.poi.ss.usermodel.PictureData;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * 外送数据接口审计Controller
 *
 * @author ruoyi
 * @date 2020-06-03
 */
@Controller
@RequestMapping("/system/auditoutgoingdata")
public class AuditOutgoingDataController extends BaseController
{
    private String prefix = "system/auditoutgoingdata";

    @Autowired
    private IAuditOutgoingDataService auditOutgoingDataService;

    //每一个模块上传图片都会把图片放到img/模块名/...  文件夹中
    private String module = "auditoutgoingdata";

    @RequiresPermissions("system:auditoutgoingdata:view")
    @GetMapping()
    public String auditoutgoingdata()
    {
        return prefix + "/auditoutgoingdata";
    }

    /**
     * 查询外送数据接口审计列表
     */
    @RequiresPermissions("system:auditoutgoingdata:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(AuditOutgoingData auditOutgoingData)
    {
        startPage();
        List<AuditOutgoingData> list = auditOutgoingDataService.selectAuditOutgoingDataList(auditOutgoingData);
        return getDataTable(list);
    }

    /**
     * 导出外送数据接口审计列表
     */
    @RequiresPermissions("system:auditoutgoingdata:export")
    @Log(title = "外送数据接口审计", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(AuditOutgoingData auditOutgoingData)
    {
        List<AuditOutgoingData> list = auditOutgoingDataService.selectAuditOutgoingDataList(auditOutgoingData);
        ExcelUtil<AuditOutgoingData> util = new ExcelUtil<AuditOutgoingData>(AuditOutgoingData.class);
        return util.exportExcel(list, "外送数据接口审计数据");
    }

    /**
     * 导入外送数据接口审计列表
     */
    @RequiresPermissions("system:auditoutgoingdata:import")
    @Log(title = "外送数据接口审计", businessType = BusinessType.IMPORT)
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file,boolean updateSupport) throws Exception{
        ExcelUtil<AuditOutgoingData> util = new ExcelUtil<>(AuditOutgoingData.class);
        List<AuditOutgoingData> auditOutgoingDataList = util.importExcel(file.getInputStream());
        if(auditOutgoingDataList == null || auditOutgoingDataList.size() == 0){
            return error("导入外送数据接口数据为空！");
        }
        String message = auditOutgoingDataService.importAuditOutgoingData(auditOutgoingDataList, updateSupport);
        return AjaxResult.success(message);
    }

    /**
     * 导入外送数据接口审计列表 模板
     */
    @RequiresPermissions("system:auditoutgoingdata:view")
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<AuditOutgoingData> util = new ExcelUtil<>(AuditOutgoingData.class);
        return util.importTemplateExcel("外送数据接口审计数据");
    }

    /**
     * 新增外送数据接口审计
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存外送数据接口审计
     */
    @RequiresPermissions("system:auditoutgoingdata:add")
    @Log(title = "外送数据接口审计", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@RequestParam(value = "file", required = false) MultipartFile file,
                              AuditOutgoingData auditOutgoingData, HttpServletRequest request) {

        //图片访问的URI
        String returnUrl = ImageUploadUtils.getImageReturnUrl(request,module);
        //当前项目路径
        String destDir = ImageUploadUtils.getImageProjectPath(module);
        try {
            String imagePath = ImageUploadUtils.uploadImage(file, destDir,returnUrl);
            if(imagePath != null && !"".equals(imagePath)){
                auditOutgoingData.setNetStruts(imagePath);
            }
        }catch (Exception e){
            e.printStackTrace();
            return error(e.getMessage());
        }
        return toAjax(auditOutgoingDataService.insertAuditOutgoingData(auditOutgoingData));
    }

    /**
     * 修改外送数据接口审计
     */
    @GetMapping("/edit/{uuid}")
    public String edit(@PathVariable("uuid") String uuid, ModelMap mmap)
    {
        AuditOutgoingData auditOutgoingData = auditOutgoingDataService.selectAuditOutgoingDataById(uuid);
        mmap.put("auditOutgoingData", auditOutgoingData);
        return prefix + "/edit";
    }

    /**
     * 修改保存外送数据接口审计
     */
    @RequiresPermissions("system:auditoutgoingdata:edit")
    @Log(title = "外送数据接口审计", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@RequestParam(value = "file", required = false) MultipartFile file,
                               AuditOutgoingData auditOutgoingData, HttpServletRequest request) {
        //先判断图片有没有更新，更新了才上传
        if(file != null && file.getOriginalFilename() != null && !"".equals(file.getOriginalFilename())){
            //图片访问的URI
            String returnUrl = ImageUploadUtils.getImageReturnUrl(request,module);
            //当前项目路径
            String destDir = ImageUploadUtils.getImageProjectPath(module);

            //打成jar包之后，class下的路径
            String imageClassPath = ImageUploadUtils.getImageClassPath(module);
            try {
                //上传新的图片
                String imagePath = ImageUploadUtils.uploadImage(file, destDir,returnUrl);
                String oldImgPath = null;

                //查找原来的图片路径
                AuditOutgoingData auditData = auditOutgoingDataService.selectAuditOutgoingDataById(auditOutgoingData.getUuid());
                if(auditData != null && auditData.getNetStruts() != null && !"".equals(auditData.getNetStruts())){
                    oldImgPath = auditData.getNetStruts();
                }

                //删除原来图片
                if(oldImgPath != null && !"".equals(oldImgPath)){
                    ImageUploadUtils.deleteImageFile(destDir,imageClassPath,oldImgPath);
                }
                //成功上传之后，把新图片访问路径保存到数据表中
                if(imagePath != null && !"".equals(imagePath)){
                    auditOutgoingData.setNetStruts(imagePath);
                }

            }catch (Exception e){
                e.printStackTrace();
                return error(e.getMessage());
            }
        }
        return toAjax(auditOutgoingDataService.updateAuditOutgoingData(auditOutgoingData));
    }

    /**
     * 删除外送数据接口审计
     */
    @RequiresPermissions("system:auditoutgoingdata:remove")
    @Log(title = "外送数据接口审计", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {

        //当前项目路径
        String destDir = ImageUploadUtils.getImageProjectPath(module);
        //打成jar包之后，class下的路径
        String imageClassPath = ImageUploadUtils.getImageClassPath(module);
        try {
            //删除图片
            List<AuditOutgoingData> dataList = auditOutgoingDataService.selectAuditOutgoingDataByIds(Convert.toStrArray(ids));
            if (dataList != null && dataList.size() > 0) {
                for (int i = 0; i < dataList.size(); i++) {
                    AuditOutgoingData auditData = dataList.get(i);
                    String oldImgPath = auditData.getNetStruts();
                    if (oldImgPath != null && !"".equals(oldImgPath)) {
                        ImageUploadUtils.deleteImageFile(destDir,imageClassPath,oldImgPath);
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return error(e.getMessage());
        }
        return toAjax(auditOutgoingDataService.deleteAuditOutgoingDataByIds(ids));
    }

    /**
     * 打开外送数据接口审计详情页
     */
    @GetMapping("/detail/{uuid}")
    public String detail(@PathVariable("uuid") String uuid, ModelMap mmap)
    {
        AuditOutgoingData auditOutgoingData = auditOutgoingDataService.selectAuditOutgoingDataById(uuid);
        mmap.put("auditOutgoingData", auditOutgoingData);
        return prefix + "/detail";
    }
}
