package com.ultrapower.project.system.sharedatainfo.controller;


import com.ultrapower.common.utils.poi.ExcelUtil;
import com.ultrapower.framework.aspectj.lang.annotation.Log;
import com.ultrapower.framework.aspectj.lang.enums.BusinessType;
import com.ultrapower.framework.web.controller.BaseController;
import com.ultrapower.framework.web.domain.AjaxResult;
import com.ultrapower.framework.web.page.TableDataInfo;
import com.ultrapower.project.system.physecsys.domain.PhySecSys;
import com.ultrapower.project.system.sharedatainfo.domain.ESystemsharedataInfo;
import com.ultrapower.project.system.sharedatainfo.service.IESystemsharedataInfoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 系统共享数据Controller
 *
 * @author ruoyi
 * @date 2020-06-01
 */
@Controller
@RequestMapping("/system/sharedatainfo")
public class ESystemsharedataInfoController extends BaseController
{
    private String prefix = "system/sharedatainfo";

    @Autowired
    private IESystemsharedataInfoService eSystemsharedataInfoService;

    @RequiresPermissions("system:sharedatainfo:view")
    @GetMapping()
    public String sharedatainfo()
    {
        return prefix + "/sharedatainfo";
    }

    /**
     * 查询系统共享数据列表
     */
    @RequiresPermissions("system:sharedatainfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ESystemsharedataInfo eSystemsharedataInfo)
    {
        startPage();
        List<ESystemsharedataInfo> list = eSystemsharedataInfoService.selectESystemsharedataInfoList(eSystemsharedataInfo);
        return getDataTable(list);
    }

    /**
     * 导出系统共享数据列表
     */
    @RequiresPermissions("system:sharedatainfo:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ESystemsharedataInfo eSystemsharedataInfo)
    {
        List<ESystemsharedataInfo> list = eSystemsharedataInfoService.selectESystemsharedataInfoList(eSystemsharedataInfo);
        ExcelUtil<ESystemsharedataInfo> util = new ExcelUtil<ESystemsharedataInfo>(ESystemsharedataInfo.class);
        return util.exportExcel(list, "sharedatainfo");
    }

    /**
     * 导入系统共享数据列表
     */
    @RequiresPermissions("system:sharedatainfo:import")
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<ESystemsharedataInfo> util = new ExcelUtil<ESystemsharedataInfo>(ESystemsharedataInfo.class);
        List<ESystemsharedataInfo> eSystemsharedataInfoList = util.importExcel(file.getInputStream());
        String message = eSystemsharedataInfoService.importData(eSystemsharedataInfoList, updateSupport);
        return AjaxResult.success(message);
    }
    /**
     * 新增系统共享数据
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存系统共享数据
     */
    @RequiresPermissions("system:sharedatainfo:add")
    @Log(title = "系统共享数据", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ESystemsharedataInfo eSystemsharedataInfo)
    {
        return toAjax(eSystemsharedataInfoService.insertESystemsharedataInfo(eSystemsharedataInfo));
    }

    /**
     * 修改系统共享数据
     */
    @GetMapping("/edit/{uuid}")
    public String edit(@PathVariable("uuid") String uuid, ModelMap mmap)
    {
        ESystemsharedataInfo eSystemsharedataInfo = eSystemsharedataInfoService.selectESystemsharedataInfoById(uuid);
        mmap.put("eSystemsharedataInfo", eSystemsharedataInfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存系统共享数据
     */
    @RequiresPermissions("system:sharedatainfo:edit")
    @Log(title = "系统共享数据", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ESystemsharedataInfo eSystemsharedataInfo)
    {
        return toAjax(eSystemsharedataInfoService.updateESystemsharedataInfo(eSystemsharedataInfo));
    }

    /**
     * 删除系统共享数据
     */
    @RequiresPermissions("system:sharedatainfo:remove")
    @Log(title = "系统共享数据", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(eSystemsharedataInfoService.deleteESystemsharedataInfoByIds(ids));
    }

    /**
     * 打开详情页
     */
    @GetMapping("/detail/{uuid}")
    public String detail(@PathVariable("uuid") String uuid, ModelMap mmap)
    {
        ESystemsharedataInfo eSystemsharedataInfo=eSystemsharedataInfoService.selectESystemsharedataInfoById(uuid);
        mmap.put("eSystemsharedataInfo", eSystemsharedataInfo);
        return prefix + "/detail";
    }
}