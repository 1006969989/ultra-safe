package com.ultrapower.project.system.authapplyaudit.mapper;

import com.ultrapower.project.system.authapplyaudit.domain.AuthApplyAudit;
import java.util.List;

/**
 * 人员权限申请记录稽核表Mapper接口
 *
 * @author ruoyi
 * @date 2020-05-27
 */
public interface AuthApplyAuditMapper
{
    /**
     * 查询人员权限申请记录稽核表
     *
     * @param uuid 人员权限申请记录稽核表ID
     * @return 人员权限申请记录稽核表
     */
    public AuthApplyAudit selectAuthApplyAuditById(String uuid);

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
     * 删除人员权限申请记录稽核表
     *
     * @param uuid 人员权限申请记录稽核表ID
     * @return 结果
     */
    public int deleteAuthApplyAuditById(String uuid);

    /**
     * 批量删除人员权限申请记录稽核表
     *
     * @param uuids 需要删除的数据ID
     * @return 结果
     */
    public int deleteAuthApplyAuditByIds(String[] uuids);

    /**
     * 查询人员权限申请记录稽核表
     *
     * @param uuids 人员权限申请记录稽核表ID
     * @return 人员权限申请记录稽核表
     */
    public List<AuthApplyAudit> selectAuthApplyAuditListByIds(String[] uuids);
}
