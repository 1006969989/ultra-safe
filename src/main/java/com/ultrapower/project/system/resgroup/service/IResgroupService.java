package com.ultrapower.project.system.resgroup.service;

import com.ultrapower.framework.web.domain.Ztree;
import com.ultrapower.project.system.dept.domain.Dept;
import com.ultrapower.project.system.resgroup.domain.Resgroup;
import java.util.List;

/**
 * 业务系统Service接口
 *
 * @author mint
 * @date 2020-05-18
 */
public interface IResgroupService {
	/**
	 * 查询业务系统
	 *
	 * @param resId 业务系统ID
	 * @return 业务系统
	 */
	public Resgroup selectResgroupById(Long resId);

	/**
	 * 查询业务系统列表
	 *
	 * @param resgroup 业务系统
	 * @return 业务系统集合
	 */
	public List<Resgroup> selectResgroupList(Resgroup resgroup);

	/**
	 * 新增业务系统
	 *
	 * @param resgroup 业务系统
	 * @return 结果
	 */
	public int insertResgroup(Resgroup resgroup);

	/**
	 * 修改业务系统
	 *
	 * @param resgroup 业务系统
	 * @return 结果
	 */
	public int updateResgroup(Resgroup resgroup);

	/**
	 * 批量删除业务系统
	 *
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	public int deleteResgroupByIds(String ids);

	/**
	 * 删除业务系统信息
	 *
	 * @param resId 业务系统ID
	 * @return 结果
	 */
	public int deleteResgroupById(Long resId);

	/**
	 * 查询业务系统管理树
	 * 
	 * @param resgroup 业务部门信息
	 * @return 所有业务部门信息
	 */
	public List<Ztree> selectResGroupTree(Resgroup resgroup);
}
