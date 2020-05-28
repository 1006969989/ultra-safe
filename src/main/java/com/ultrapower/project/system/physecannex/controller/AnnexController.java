package com.ultrapower.project.system.physecannex.controller;

import java.io.IOException;
import java.util.List;

import com.ultrapower.common.constant.Constants;
import com.ultrapower.common.utils.StringUtils;
import com.ultrapower.common.utils.file.FileUploadUtils;
import com.ultrapower.common.utils.file.FileUtils;
import com.ultrapower.common.utils.poi.ExcelUtil;
import com.ultrapower.common.utils.text.Convert;
import com.ultrapower.framework.aspectj.lang.annotation.Log;
import com.ultrapower.framework.aspectj.lang.enums.BusinessType;
import com.ultrapower.framework.config.RuoYiConfig;
import com.ultrapower.framework.web.controller.BaseController;
import com.ultrapower.framework.web.domain.AjaxResult;
import com.ultrapower.framework.web.page.TableDataInfo;
import com.ultrapower.project.system.physecsys.domain.PhySecSys;
import com.ultrapower.project.system.physecsys.service.IPhySecSysService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import com.ultrapower.project.system.physecannex.domain.Annex;
import com.ultrapower.project.system.physecannex.service.IAnnexService;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 物理安全情况附件Controller
 *
 * @author 王聪
 * @date 2020-05-27
 */
@Controller
@RequestMapping("/system/physecannex")
public class AnnexController extends BaseController
{
    private String prefix = "system/physecannex";

    @Autowired
    private IAnnexService annexService;
    @Autowired
    private IPhySecSysService phySecSysService;

    @RequiresPermissions("system:physecannex:view")
    @GetMapping()
    public String physecannex()
    {
        return prefix + "/physecannex";
    }

    /**
     * 查询物理安全情况附件列表
     */
    @RequiresPermissions("system:physecannex:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Annex annex)
    {
        startPage();
        List<Annex> list = annexService.selectAnnexList(annex);
        return getDataTable(list);
    }

    /**
     * 导出物理安全情况附件列表
     */
    @RequiresPermissions("system:physecannex:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Annex annex)
    {
        List<Annex> list = annexService.selectAnnexList(annex);
        ExcelUtil<Annex> util = new ExcelUtil<Annex>(Annex.class);
        return util.exportExcel(list, "physecannex");
    }

    /**
     * 新增物理安全情况附件
     */
    @GetMapping("/add/{uuid}")
    public String add(@PathVariable("uuid") String uuid, ModelMap mmap)
    {
        System.out.println(uuid);
        mmap.put("uuid", uuid);
        return prefix + "/add";
    }
    /**
     * 新增保存物理安全情况附件
     */
    @RequiresPermissions("system:physecannex:add")
    @Log(title = "物理安全情况附件", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@RequestParam("file") MultipartFile file, Annex annex) throws IOException
    {
        // 上传文件保存路径
        String savePath = RuoYiConfig.getUploadPath();//来自配置
        System.out.println("savePath= "+savePath);
        // 上传并返回新文件实际路径
        String filePath = FileUploadUtils.upload(savePath, file);//实际上传路径
        annex.setFtppath(filePath);//写入实际路径
        annex.setAnnex(file.getOriginalFilename());//写入文件名称
        System.out.println(annex);
        System.out.println("filePath= "+filePath);
        //FileUtils.deleteFile(filePath);
        return toAjax(annexService.insertAnnex(annex));
    }

    @GetMapping("/download/{uuid}")
    public void resourceDownload(@PathVariable("uuid")String uuid, HttpServletRequest request, HttpServletResponse response)
            throws Exception
    {
        //获取数据库Annex对象
        Annex annex = annexService.selectAnnexById(uuid);
        // 本地资源路径
        String localPath = RuoYiConfig.getProfile();
        // 数据库资源地址
        String downloadPath = localPath + StringUtils.substringAfter(annex.getFtppath(), Constants.RESOURCE_PREFIX);
        // 下载名称
        //String downloadName = StringUtils.substringAfterLast(downloadPath, "/");
        String downloadName=annex.getAnnex();
        response.setCharacterEncoding("utf-8");
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition",
                "attachment;fileName=" + FileUtils.setFileDownloadHeader(request, downloadName));
        FileUtils.writeBytes(downloadPath, response.getOutputStream());
    }

    /**
     * 修改物理安全情况附件
     */
    @GetMapping("/edit/{uuid}")
    public String edit(@PathVariable("uuid") String uuid, ModelMap mmap)
    {
        Annex annex = annexService.selectAnnexById(uuid);
        mmap.put("annex", annex);
        return prefix + "/edit";
    }

    /**
     * 修改保存物理安全情况附件
     */
    @RequiresPermissions("system:physecannex:edit")
    @Log(title = "物理安全情况附件", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Annex annex)
    {
        return toAjax(annexService.updateAnnex(annex));
    }

    /**
     * 删除物理安全情况附件
     */
    @RequiresPermissions("system:physecannex:remove")
    @Log(title = "物理安全情况附件", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        String[] id= Convert.toStrArray(ids);
        Annex annex=annexService.selectAnnexById(id[0]);
        String localPath = RuoYiConfig.getProfile();
        // 数据库资源地址
        String downloadPath = localPath + StringUtils.substringAfter(annex.getFtppath(), Constants.RESOURCE_PREFIX);
        boolean flag=FileUtils.deleteFile(downloadPath);
        int tag=annexService.deleteAnnexByIds(ids);
        if(flag && tag==1){
            return toAjax(tag);
        }else{
            return toAjax(0);
        }
    }

    //new
    //打开附件维护页面
    @GetMapping("/showAnnex/{uuid}")
    public String showAnnex(@PathVariable("uuid") String uuid, ModelMap mmap)
    {
        PhySecSys phySecSys = phySecSysService.selectPhySecSysById(uuid);
        mmap.put("phySecSys", phySecSys);
        return prefix + "/physecannex";
    }
}
