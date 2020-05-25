package com.ultrapower.project.system.range.controller;


import com.ultrapower.common.utils.poi.ExcelUtil;
import com.ultrapower.framework.aspectj.lang.annotation.Log;
import com.ultrapower.framework.aspectj.lang.enums.BusinessType;
import com.ultrapower.framework.web.controller.BaseController;
import com.ultrapower.framework.web.domain.AjaxResult;
import com.ultrapower.framework.web.page.TableDataInfo;
import com.ultrapower.project.system.range.domain.ESensitiveRange;
import com.ultrapower.project.system.range.service.IESensitiveRangeService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 涉敏数据范围Controller
 *
 * @author ruoyi
 * @date 2020-05-20
 */
@Controller
@RequestMapping("/system/range")
public class ESensitiveRangeController extends BaseController
{
    private String prefix = "system/range";

    @Autowired
    private IESensitiveRangeService eSensitiveRangeService;

    @RequiresPermissions("system:range:view")
    @GetMapping()
    public String range()
    {
        return prefix + "/range";
    }

    /**
     * 查询涉敏数据范围列表
     */
    @RequiresPermissions("system:range:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ESensitiveRange eSensitiveRange)
    {
        startPage();
        List<ESensitiveRange> list = eSensitiveRangeService.selectESensitiveRangeList(eSensitiveRange);
        return getDataTable(list);
    }

    /**
     * 导出涉敏数据范围列表
     */
    @RequiresPermissions("system:range:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ESensitiveRange eSensitiveRange)
    {
        List<ESensitiveRange> list = eSensitiveRangeService.selectESensitiveRangeList(eSensitiveRange);
        ExcelUtil<ESensitiveRange> util = new ExcelUtil<ESensitiveRange>(ESensitiveRange.class);
        return util.exportExcel(list, "range");
    }

    /**
     * 新增涉敏数据范围
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存涉敏数据范围
     */
    @RequiresPermissions("system:range:add")
    @Log(title = "涉敏数据范围", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ESensitiveRange eSensitiveRange)
    {
        return toAjax(eSensitiveRangeService.insertESensitiveRange(eSensitiveRange));
    }

    /**
     * 修改涉敏数据范围
     */
    @GetMapping("/edit/{uuid}")
    public String edit(@PathVariable("uuid") String uuid, ModelMap mmap)
    {
        ESensitiveRange eSensitiveRange = eSensitiveRangeService.selectESensitiveRangeById(uuid);
        mmap.put("eSensitiveRange", eSensitiveRange);
        return prefix + "/edit";
    }

    /**
     * 修改保存涉敏数据范围
     */
    @RequiresPermissions("system:range:edit")
    @Log(title = "涉敏数据范围", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ESensitiveRange eSensitiveRange)
    {
        return toAjax(eSensitiveRangeService.updateESensitiveRange(eSensitiveRange));
    }

    /**
     * 删除涉敏数据范围
     */
    @RequiresPermissions("system:range:remove")
    @Log(title = "涉敏数据范围", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(eSensitiveRangeService.deleteESensitiveRangeByIds(ids));
    }
}