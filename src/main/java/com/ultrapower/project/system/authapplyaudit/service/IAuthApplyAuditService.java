package com.ultrapower.project.system.authapplyaudit.service;

import com.ultrapower.project.system.authapplyaudit.domain.AuthApplyAudit;
import java.util.List;

/**
 * 人员权限申请记录稽核表Service接口
 *
 * @author ruoyi
 * @date 2020-05-27
 */
public interface IAuthApplyAuditService
{
    /**
     * 查询人员权限申请记录稽核表
     *
     * @param uuid 人员权限申请记录稽核表ID
     * @return 人员权限申请记录稽核表
     */
    public AuthApplyAudit selectAuthApplyAuditById(String uuid);

    /**
     * 查询人员权限申请记录稽核表
     *
     * @param ids 人员权限申请记录稽核表ID
     * @return 人员权限申请记录稽核表
     */
    public List<AuthApplyAudit> selectAuthApplyAuditListByIds(String[] ids);

    /**
     * 查询人员权限申请记录稽核表列表
     *
     * @param authApplyAudit 人员权限申请记录稽核表
     * @return 人员权限申请记录稽核表集合
     */
    public List<AuthApplyAudit> selectAuthApplyAuditList(AuthApplyAudit authApplyAudit);

    /**
     * 新增人员权限申请记录稽核表
     *
     * @param authApplyAudit 人员权限申请记录稽核表
     * @return 结果
     */
    public int insertAuthApplyAudit(AuthApplyAudit authApplyAudit);

    /**
     * 修改人员权限申请记录稽核表
     *
     * @param authApplyAudit 人员权限申请记录稽核表
     * @return 结果
     */
    public int updateAuthApplyAudit(AuthApplyAudit authApplyAudit);

    /**
     * 批量删除人员权限申请记录稽核表
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteAuthApplyAuditByIds(String ids);

    /**
     * 删除人员权限申请记录稽核表信息
     *
     * @param uuid 人员权限申请记录稽核表ID
     * @return 结果
     */
    public int deleteAuthApplyAuditById(String uuid);
}
