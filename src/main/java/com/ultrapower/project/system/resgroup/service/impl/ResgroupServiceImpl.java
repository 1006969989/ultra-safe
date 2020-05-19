package com.ultrapower.project.system.resgroup.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ultrapower.common.constant.UserConstants;
import com.ultrapower.common.utils.DateUtils;
import com.ultrapower.common.utils.text.Convert;
import com.ultrapower.framework.web.domain.Ztree;
import com.ultrapower.project.system.resgroup.domain.Resgroup;
import com.ultrapower.project.system.resgroup.mapper.ResgroupMapper;
import com.ultrapower.project.system.resgroup.service.IResgroupService;

/**
 * 业务系统Service业务层处理
 *
 * @author mint
 * @date 2020-05-18
 */
@Service
public class ResgroupServiceImpl implements IResgroupService {
	@Autowired
	private ResgroupMapper resgroupMapper;

	/**
	 * 查询业务系统
	 *
	 * @param resId 业务系统ID
	 * @return 业务系统
	 */
	@Override
	public Resgroup selectResgroupById(Long resId) {
		return resgroupMapper.selectResgroupById(resId);
	}

	/**
	 * 查询业务系统列表
	 *
	 * @param resgroup 业务系统
	 * @return 业务系统
	 */
	@Override
	public List<Resgroup> selectResgroupList(Resgroup resgroup) {
		return resgroupMapper.selectResgroupList(resgroup);
	}

	/**
	 * 新增业务系统
	 *
	 * @param resgroup 业务系统
	 * @return 结果
	 */
	@Override
	public int insertResgroup(Resgroup resgroup) {
		resgroup.setCreateTime(DateUtils.getNowDate());
		return resgroupMapper.insertResgroup(resgroup);
	}

	/**
	 * 修改业务系统
	 *
	 * @param resgroup 业务系统
	 * @return 结果
	 */
	@Override
	public int updateResgroup(Resgroup resgroup) {
		resgroup.setUpdateTime(DateUtils.getNowDate());
		return resgroupMapper.updateResgroup(resgroup);
	}

	/**
	 * 删除业务系统对象
	 *
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	@Override
	public int deleteResgroupByIds(String ids) {
		return resgroupMapper.deleteResgroupByIds(Convert.toStrArray(ids));
	}

	/**
	 * 删除业务系统信息
	 *
	 * @param resId 业务系统ID
	 * @return 结果
	 */
	@Override
	public int deleteResgroupById(Long resId) {
		return resgroupMapper.deleteResgroupById(resId);
	}

	@Override
	public List<Ztree> selectResGroupTree(Resgroup resgroup) {
		List<Resgroup> resgroupList = resgroupMapper.selectResGroupTree(resgroup);
		List<Ztree> ztrees = initZtree(resgroupList);
		return ztrees;
	}

	/**
	 * 对象转业务系统树
	 *
	 * @param resgrouplist 业务系统数据
	 * @return 业务系统树结构列表
	 */
	public List<Ztree> initZtree(List<Resgroup> resgrouplist) {
		List<Ztree> ztrees = new ArrayList<Ztree>();
		for (Resgroup resgroup : resgrouplist) {
			if (UserConstants.ISLOGICDELETE.equals(resgroup.getDelFlag())) {
				Ztree ztree = new Ztree();
				ztree.setId(resgroup.getResId());
				ztree.setpId(resgroup.getParentId());
				ztree.setName(resgroup.getGroupName());
				ztree.setTitle(resgroup.getGroupName());
				ztrees.add(ztree);
			}
		}
		return ztrees;
	}
}
