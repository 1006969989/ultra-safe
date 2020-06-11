package com.ultrapower.project.system.subacc.controller;


import com.ultrapower.common.utils.poi.ExcelUtil;
import com.ultrapower.framework.aspectj.lang.annotation.Log;
import com.ultrapower.framework.aspectj.lang.enums.BusinessType;
import com.ultrapower.framework.web.controller.BaseController;
import com.ultrapower.framework.web.domain.AjaxResult;
import com.ultrapower.framework.web.page.TableDataInfo;
import com.ultrapower.project.system.subacc.domain.SensitiveResSubacc;
import com.ultrapower.project.system.subacc.service.ISensitiveResSubaccService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 涉敏资产库Controller
 *
 * @author ruoyi
 * @date 2020-06-04
 */
@Controller
@RequestMapping("/system/subacc")
public class SensitiveResSubaccController extends BaseController
{
    private String prefix = "system/subacc";

    @Autowired
    private ISensitiveResSubaccService sensitiveResSubaccService;

    @RequiresPermissions("system:subacc:view")
    @GetMapping()
    public String subacc()
    {
        return prefix + "/subacc";
    }

    /**
     * 查询涉敏资产库列表
     */
    @RequiresPermissions("system:subacc:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SensitiveResSubacc sensitiveResSubacc)
    {
        startPage();
        List<SensitiveResSubacc> list = sensitiveResSubaccService.selectSensitiveResSubaccList(sensitiveResSubacc);
        return getDataTable(list);
    }
    /**
     * 导入涉敏资产库列表
     */
    @RequiresPermissions("system:subacc:import")
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<SensitiveResSubacc> util = new ExcelUtil<SensitiveResSubacc>(SensitiveResSubacc.class);
        List<SensitiveResSubacc> sensitiveResSubaccList = util.importExcel(file.getInputStream());
        String message = sensitiveResSubaccService.importData(sensitiveResSubaccList, updateSupport);
        return AjaxResult.success(message);
    }
    /**
     * 导出涉敏资产库列表
     */
    @RequiresPermissions("system:subacc:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SensitiveResSubacc sensitiveResSubacc)
    {
        List<SensitiveResSubacc> list = sensitiveResSubaccService.selectSensitiveResSubaccList(sensitiveResSubacc);
        ExcelUtil<SensitiveResSubacc> util = new ExcelUtil<SensitiveResSubacc>(SensitiveResSubacc.class);
        return util.exportExcel(list, "subacc");
    }

    /**
     * 新增涉敏资产库
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存涉敏资产库
     */
    @RequiresPermissions("system:subacc:add")
    @Log(title = "涉敏资产库", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SensitiveResSubacc sensitiveResSubacc)
    {
        return toAjax(sensitiveResSubaccService.insertSensitiveResSubacc(sensitiveResSubacc));
    }

    /**
     * 修改涉敏资产库
     */
    @GetMapping("/edit/{uuid}")
    public String edit(@PathVariable("uuid") String uuid, ModelMap mmap)
    {
        SensitiveResSubacc sensitiveResSubacc = sensitiveResSubaccService.selectSensitiveResSubaccById(uuid);
        mmap.put("sensitiveResSubacc", sensitiveResSubacc);
        return prefix + "/edit";
    }

    /**
     * 修改保存涉敏资产库
     */
    @RequiresPermissions("system:subacc:edit")
    @Log(title = "涉敏资产库", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SensitiveResSubacc sensitiveResSubacc)
    {
        return toAjax(sensitiveResSubaccService.updateSensitiveResSubacc(sensitiveResSubacc));
    }

    /**
     * 删除涉敏资产库
     */
    @RequiresPermissions("system:subacc:remove")
    @Log(title = "涉敏资产库", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(sensitiveResSubaccService.deleteSensitiveResSubaccByIds(ids));
    }

    /**
     * 打开详情页
     */
    @GetMapping("/detail/{uuid}")
    public String detail(@PathVariable("uuid") String uuid, ModelMap mmap)
    {
        SensitiveResSubacc sensitiveResSubacc=sensitiveResSubaccService.selectSensitiveResSubaccById(uuid);
        mmap.put("sensitiveResSubacc", sensitiveResSubacc);
        return prefix + "/detail";
    }
}