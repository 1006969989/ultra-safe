package com.ultrapower.project.system.physeccabinet.controller;

import com.ultrapower.common.utils.poi.ExcelUtil;
import com.ultrapower.framework.aspectj.lang.annotation.Log;
import com.ultrapower.framework.aspectj.lang.enums.BusinessType;
import com.ultrapower.framework.web.controller.BaseController;
import com.ultrapower.framework.web.domain.AjaxResult;
import com.ultrapower.framework.web.page.TableDataInfo;
import com.ultrapower.project.system.physeccabinet.domain.Cabinet;
import com.ultrapower.project.system.physeccabinet.service.ICabinetService;
import com.ultrapower.project.system.physecsys.domain.PhySecSys;
import com.ultrapower.project.system.physecsys.service.IPhySecSysService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 物理安全情况涉及机柜Controller
 *
 * @author 王聪
 * @date 2020-05-25
 */
@Controller
@RequestMapping("/system/physeccabinet")
public class CabinetController extends BaseController
{
    private String prefix = "system/physeccabinet";

    @Autowired
    private ICabinetService cabinetService;

    @Autowired
    private IPhySecSysService phySecSysService;

    @RequiresPermissions("system:physeccabinet:view")
    @GetMapping()
    public String physeccabinet()
    {
        return prefix + "/physeccabinet";
    }

    /**
     * 查询物理安全情况涉及机柜列表
     */
    @RequiresPermissions("system:physeccabinet:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Cabinet cabinet)
    {
        startPage();
        List<Cabinet> list = cabinetService.selectCabinetList(cabinet);
        return getDataTable(list);
    }

    /**
     * 导出物理安全情况涉及机柜列表
     */
    @RequiresPermissions("system:physeccabinet:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Cabinet cabinet)
    {
        List<Cabinet> list = cabinetService.selectCabinetList(cabinet);
        ExcelUtil<Cabinet> util = new ExcelUtil<Cabinet>(Cabinet.class);
        return util.exportExcel(list, "physeccabinet");
    }

    /**
     * 新增物理安全情况涉及机柜
     */
    /*@GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }*/
    @GetMapping("/add/{uuid}")
    public String add(@PathVariable("uuid") String uuid, ModelMap mmap)
    {
        System.out.println(uuid);
        mmap.put("uuid", uuid);
        return prefix + "/add";
    }

    /**
     * 新增保存物理安全情况涉及机柜
     */
    @RequiresPermissions("system:physeccabinet:add")
    @Log(title = "物理安全情况涉及机柜", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Cabinet cabinet)
    {
        return toAjax(cabinetService.insertCabinet(cabinet));
    }

    /**
     * 修改物理安全情况涉及机柜
     */
    @GetMapping("/edit/{uuid}")
    public String edit(@PathVariable("uuid") String uuid, ModelMap mmap)
    {
        Cabinet cabinet = cabinetService.selectCabinetById(uuid);
        mmap.put("cabinet", cabinet);
        return prefix + "/edit";
    }

    /**
     * 修改保存物理安全情况涉及机柜
     */
    @RequiresPermissions("system:physeccabinet:edit")
    @Log(title = "物理安全情况涉及机柜", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Cabinet cabinet)
    {
        return toAjax(cabinetService.updateCabinet(cabinet));
    }

    /**
     * 删除物理安全情况涉及机柜
     */
    @RequiresPermissions("system:physeccabinet:remove")
    @Log(title = "物理安全情况涉及机柜", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(cabinetService.deleteCabinetByIds(ids));
    }

    //打开机柜维护页面
    @GetMapping("/showCabinet/{uuid}")
    public String showCabinet(@PathVariable("uuid") String uuid, ModelMap mmap)
    {
        PhySecSys phySecSys = phySecSysService.selectPhySecSysById(uuid);
        mmap.put("phySecSys", phySecSys);
        return prefix + "/physeccabinet";
    }
}
