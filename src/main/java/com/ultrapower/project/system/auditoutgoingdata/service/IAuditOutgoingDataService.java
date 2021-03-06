package com.ultrapower.project.system.auditoutgoingdata.service;

import com.ultrapower.project.system.auditoutgoingdata.domain.AuditOutgoingData;
import java.util.List;

/**
 * 外送数据接口审计Service接口
 *
 * @author ruoyi
 * @date 2020-06-03
 */
public interface IAuditOutgoingDataService
{
    /**
     * 查询外送数据接口审计
     *
     * @param uuid 外送数据接口审计ID
     * @return 外送数据接口审计
     */
    public AuditOutgoingData selectAuditOutgoingDataById(String uuid);

    /**
     * 查询外送数据接口审计
     *
     * @param uuids 外送数据接口审计uuid数组
     * @return 外送数据接口审计
     */
    public List<AuditOutgoingData> selectAuditOutgoingDataByIds(String[] uuids);

    /**
     * 查询外送数据接口审计列表
     *
     * @param auditOutgoingData 外送数据接口审计
     * @return 外送数据接口审计集合
     */
    public List<AuditOutgoingData> selectAuditOutgoingDataList(AuditOutgoingData auditOutgoingData);

    /**
     * 新增外送数据接口审计
     *
     * @param auditOutgoingData 外送数据接口审计
     * @return 结果
     */
    public int insertAuditOutgoingData(AuditOutgoingData auditOutgoingData);

    /**
     * 修改外送数据接口审计
     *
     * @param auditOutgoingData 外送数据接口审计
     * @return 结果
     */
    public int updateAuditOutgoingData(AuditOutgoingData auditOutgoingData);

    /**
     * 批量删除外送数据接口审计
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteAuditOutgoingDataByIds(String ids);

    /**
     * 删除外送数据接口审计信息
     *
     * @param uuid 外送数据接口审计ID
     * @return 结果
     */
    public int deleteAuditOutgoingDataById(String uuid);

    /**
     * 导入外送数据接口审计数据
     *
     * @param auditOutgoingDataList 外送数据接口审计导入的数据
     * @param  updateSupport 是否更新已存在的数据
     * @return 结果
     */
    public String importAuditOutgoingData(List<AuditOutgoingData> auditOutgoingDataList,boolean updateSupport);
}
