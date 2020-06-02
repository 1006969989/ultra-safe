package com.ultrapower.project.system.resgroup.controller;

import java.util.List;
import java.util.Random;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ultrapower.common.utils.UUIDUtils;
import com.ultrapower.common.utils.poi.ExcelUtil;
import com.ultrapower.framework.aspectj.lang.annotation.Log;
import com.ultrapower.framework.aspectj.lang.enums.BusinessType;
import com.ultrapower.framework.web.controller.BaseController;
import com.ultrapower.framework.web.domain.AjaxResult;
import com.ultrapower.framework.web.domain.Ztree;
import com.ultrapower.framework.web.page.TableDataInfo;
import com.ultrapower.project.system.resgroup.domain.Resgroup;
import com.ultrapower.project.system.resgroup.service.IResgroupService;

/**
 * 业务系统Controller
 *
 * @author mint
 * @date 2020-05-18
 */
@Controller
@RequestMapping("/system/resgroup")
public class ResgroupController extends BaseController {
	private String prefix = "system/resgroup";

	@Autowired
	private IResgroupService resgroupService;

	@RequiresPermissions("system:resgroup:view")
	@GetMapping()
	public String resgroup() {
		return prefix + "/resgroup";
	}

	/**
	 * 加载业务系统列表树
	 */
	@GetMapping("/treeData")
	@ResponseBody
	public List<Ztree> treeData() {
		List<Ztree> ztrees = resgroupService.selectResGroupTree(new Resgroup());
		return ztrees;
	}

	/**
	 * 查询业务系统列表
	 */
	@RequiresPermissions("system:resgroup:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Resgroup resgroup) {
		startPage();
		List<Resgroup> list = resgroupService.selectResgroupList(resgroup);
		return getDataTable(list);
	}

	/**
	 * 导出业务系统列表
	 */
	@RequiresPermissions("system:resgroup:export")
	@PostMapping("/export")
	@ResponseBody
	public AjaxResult export(Resgroup resgroup) {
		List<Resgroup> list = resgroupService.selectResgroupList(resgroup);
		ExcelUtil<Resgroup> util = new ExcelUtil<Resgroup>(Resgroup.class);
		return util.exportExcel(list, "resgroup");
	}

	/**
	 * 新增业务系统
	 */
	@GetMapping("/add")
	public String add() {
		return prefix + "/add";
	}

	/**
	 * 新增保存业务系统
	 */
	@RequiresPermissions("system:resgroup:add")
	@Log(title = "业务系统", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Resgroup resgroup) {
		resgroup.setResgroupuuid(UUIDUtils.get32UUIDWithOutLine());
		return toAjax(resgroupService.insertResgroup(resgroup));
	}

	/**
	 * 修改业务系统
	 */
	@GetMapping("/edit/{resId}")
	public String edit(@PathVariable("resId") Long resId, ModelMap mmap) {
		Resgroup resgroup = resgroupService.selectResgroupById(resId);
		mmap.put("resgroup", resgroup);
		return prefix + "/edit";
	}

	/**
	 * 修改保存业务系统
	 */
	@RequiresPermissions("system:resgroup:edit")
	@Log(title = "业务系统", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Resgroup resgroup) {
		return toAjax(resgroupService.updateResgroup(resgroup));
	}

	/**
	 * 删除业务系统
	 */
	@RequiresPermissions("system:resgroup:remove")
	@Log(title = "业务系统", businessType = BusinessType.DELETE)
	@PostMapping("/remove")
	@ResponseBody
	public AjaxResult remove(String ids) {
		return toAjax(resgroupService.deleteResgroupByIds(ids));
	}

	/**
	 * 选择部门树
	 */
	@GetMapping("/selectResGroupTree/{resGroupId}")
	public String selectResGroupTree(@PathVariable("resGroupId") Long resGroupId, ModelMap mmap) {
		mmap.put("resgroup", resgroupService.selectResgroupById(resGroupId));
		return prefix + "/tree";
	}

	/**
	 * 选择部门树
	 */
	@GetMapping("/selectMResGroupTree/{resgroupids}")
	public String selectResGroupTree(@PathVariable("resgroupids") String resgroupids, ModelMap mmap) {
		mmap.put("resgroupids", resgroupids);
		return prefix + "/multichoosetree";
	}
}
