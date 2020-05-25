package com.ultrapower.project.system.type.controller;


import com.ultrapower.common.utils.poi.ExcelUtil;
import com.ultrapower.framework.aspectj.lang.annotation.Log;
import com.ultrapower.framework.aspectj.lang.enums.BusinessType;
import com.ultrapower.framework.web.controller.BaseController;
import com.ultrapower.framework.web.domain.AjaxResult;
import com.ultrapower.framework.web.page.TableDataInfo;
import com.ultrapower.project.system.type.domain.ESensitiveType;
import com.ultrapower.project.system.type.service.IESensitiveTypeService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 涉敏数据类型Controller
 *
 * @author ruoyi
 * @date 2020-05-20
 */
@Controller
@RequestMapping("/system/type")
public class ESensitiveTypeController extends BaseController
{
    private String prefix = "system/type";

    @Autowired
    private IESensitiveTypeService eSensitiveTypeService;

    @RequiresPermissions("system:type:view")
    @GetMapping()
    public String type()
    {
        return prefix + "/type";
    }

    /**
     * 查询涉敏数据类型列表
     */
    @RequiresPermissions("system:type:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ESensitiveType eSensitiveType)
    {
        startPage();
        List<ESensitiveType> list = eSensitiveTypeService.selectESensitiveTypeList(eSensitiveType);
        return getDataTable(list);
    }

    /**
     * 导出涉敏数据类型列表
     */
    @RequiresPermissions("system:type:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ESensitiveType eSensitiveType)
    {
        List<ESensitiveType> list = eSensitiveTypeService.selectESensitiveTypeList(eSensitiveType);
        ExcelUtil<ESensitiveType> util = new ExcelUtil<ESensitiveType>(ESensitiveType.class);
        return util.exportExcel(list, "type");
    }

    /**
     * 新增涉敏数据类型
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存涉敏数据类型
     */
    @RequiresPermissions("system:type:add")
    @Log(title = "涉敏数据类型", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ESensitiveType eSensitiveType)
    {
        return toAjax(eSensitiveTypeService.insertESensitiveType(eSensitiveType));
    }

    /**
     * 修改涉敏数据类型
     */
    @GetMapping("/edit/{uuid}")
    public String edit(@PathVariable("uuid") String uuid, ModelMap mmap)
    {
        ESensitiveType eSensitiveType = eSensitiveTypeService.selectESensitiveTypeById(uuid);
        mmap.put("eSensitiveType", eSensitiveType);
        return prefix + "/edit";
    }

    /**
     * 修改保存涉敏数据类型
     */
    @RequiresPermissions("system:type:edit")
    @Log(title = "涉敏数据类型", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ESensitiveType eSensitiveType)
    {
        return toAjax(eSensitiveTypeService.updateESensitiveType(eSensitiveType));
    }

    /**
     * 删除涉敏数据类型
     */
    @RequiresPermissions("system:type:remove")
    @Log(title = "涉敏数据类型", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(eSensitiveTypeService.deleteESensitiveTypeByIds(ids));
    }
}