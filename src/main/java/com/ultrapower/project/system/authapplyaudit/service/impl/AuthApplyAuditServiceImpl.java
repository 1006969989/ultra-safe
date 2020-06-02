package com.ultrapower.project.system.authapplyaudit.service.impl;

import com.ultrapower.common.utils.DateUtils;
import com.ultrapower.common.utils.security.ShiroUtils;
import com.ultrapower.common.utils.text.Convert;
import com.ultrapower.project.system.authapplyaudit.domain.AuthApplyAudit;
import com.ultrapower.project.system.authapplyaudit.mapper.AuthApplyAuditMapper;
import com.ultrapower.project.system.authapplyaudit.service.IAuthApplyAuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 人员权限申请记录稽核表Service业务层处理
 *
 * @author ruoyi
 * @date 2020-05-27
 */
@Service
public class AuthApplyAuditServiceImpl implements IAuthApplyAuditService
{
    @Autowired
    private AuthApplyAuditMapper authApplyAuditMapper;

    /**
     * 查询人员权限申请记录稽核表
     *
     * @param uuid 人员权限申请记录稽核表ID
     * @return 人员权限申请记录稽核表
     */
    @Override
    public AuthApplyAudit selectAuthApplyAuditById(String uuid)
    {
        return authApplyAuditMapper.selectAuthApplyAuditById(uuid);
    }

    @Override
    public List<AuthApplyAudit> selectAuthApplyAuditListByIds(String[] ids) {

        return authApplyAuditMapper.selectAuthApplyAuditListByIds(ids);
    }

    /**
     * 查询人员权限申请记录稽核表列表
     *
     * @param authApplyAudit 人员权限申请记录稽核表
     * @return 人员权限申请记录稽核表
     */
    @Override
    public List<AuthApplyAudit> selectAuthApplyAuditList(AuthApplyAudit authApplyAudit)
    {
        return authApplyAuditMapper.selectAuthApplyAuditList(authApplyAudit);
    }

    /**
     * 新增人员权限申请记录稽核表
     *
     * @param authApplyAudit 人员权限申请记录稽核表
     * @return 结果
     */
    @Override
    public int insertAuthApplyAudit(AuthApplyAudit authApplyAudit)
    {
        authApplyAudit.setCreateTime(DateUtils.parseDate(DateUtils.getTime()));
        authApplyAudit.setCreateUserid(ShiroUtils.getLoginName());
        return authApplyAuditMapper.insertAuthApplyAudit(authApplyAudit);
    }

    /**
     * 修改人员权限申请记录稽核表
     *
     * @param authApplyAudit 人员权限申请记录稽核表
     * @return 结果
     */
    @Override
    public int updateAuthApplyAudit(AuthApplyAudit authApplyAudit)
    {
        authApplyAudit.setModifyUserid(ShiroUtils.getLoginName());
        authApplyAudit.setModifyTime(DateUtils.parseDate(DateUtils.getTime()));
        return authApplyAuditMapper.updateAuthApplyAudit(authApplyAudit);
    }

    /**
     * 删除人员权限申请记录稽核表对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteAuthApplyAuditByIds(String ids)
    {
        return authApplyAuditMapper.deleteAuthApplyAuditByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除人员权限申请记录稽核表信息
     *
     * @param uuid 人员权限申请记录稽核表ID
     * @return 结果
     */
    @Override
    public int deleteAuthApplyAuditById(String uuid)
    {
        return authApplyAuditMapper.deleteAuthApplyAuditById(uuid);
    }
}
