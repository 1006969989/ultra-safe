package com.ultrapower.project.system.matrix.controller;

import com.ultrapower.common.utils.poi.ExcelUtil;
import com.ultrapower.framework.aspectj.lang.annotation.Log;
import com.ultrapower.framework.aspectj.lang.enums.BusinessType;
import com.ultrapower.framework.web.controller.BaseController;
import com.ultrapower.framework.web.domain.AjaxResult;
import com.ultrapower.framework.web.page.TableDataInfo;
import com.ultrapower.project.system.matrix.domain.EMatrixDetail;
import com.ultrapower.project.system.matrix.service.IEMatrixDetailService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 矩阵明细Controller
 *
 * @author ruoyi
 * @date 2020-05-20
 */
@Controller
@RequestMapping("/system/matrix")
public class EMatrixDetailController extends BaseController
{
    private String prefix = "system/matrix";

    @Autowired
    private IEMatrixDetailService eMatrixDetailService;

    @RequiresPermissions("system:matrix:view")
    @GetMapping()
    public String matrix()
    {
        return prefix + "/matrix";
    }

    /**
     * 查询矩阵明细列表
     */
    @RequiresPermissions("system:matrix:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(EMatrixDetail eMatrixDetail)
    {
        startPage();
        List<EMatrixDetail> list = eMatrixDetailService.selectEMatrixDetailList(eMatrixDetail);
        return getDataTable(list);
    }

    /**
     * 导出矩阵明细列表
     */
    @RequiresPermissions("system:matrix:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(EMatrixDetail eMatrixDetail)
    {
        List<EMatrixDetail> list = eMatrixDetailService.selectEMatrixDetailList(eMatrixDetail);
        ExcelUtil<EMatrixDetail> util = new ExcelUtil<EMatrixDetail>(EMatrixDetail.class);
        return util.exportExcel(list, "matrix");
    }

    /**
     * 新增矩阵明细
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存矩阵明细
     */
    @RequiresPermissions("system:matrix:add")
    @Log(title = "矩阵明细", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(EMatrixDetail eMatrixDetail)
    {
        return toAjax(eMatrixDetailService.insertEMatrixDetail(eMatrixDetail));
    }

    /**
     * 修改矩阵明细
     */
    @GetMapping("/edit/{uuid}")
    public String edit(@PathVariable("uuid") String uuid, ModelMap mmap)
    {
        EMatrixDetail eMatrixDetail = eMatrixDetailService.selectEMatrixDetailById(uuid);
        mmap.put("eMatrixDetail", eMatrixDetail);
        return prefix + "/edit";
    }

    /**
     * 修改保存矩阵明细
     */
    @RequiresPermissions("system:matrix:edit")
    @Log(title = "矩阵明细", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(EMatrixDetail eMatrixDetail)
    {
        return toAjax(eMatrixDetailService.updateEMatrixDetail(eMatrixDetail));
    }

    /**
     * 删除矩阵明细
     */
    @RequiresPermissions("system:matrix:remove")
    @Log(title = "矩阵明细", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(eMatrixDetailService.deleteEMatrixDetailByIds(ids));
    }
}