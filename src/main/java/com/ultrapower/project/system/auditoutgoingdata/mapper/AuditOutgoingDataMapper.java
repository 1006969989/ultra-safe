package com.ultrapower.project.system.auditoutgoingdata.mapper;

import com.ultrapower.project.system.auditoutgoingdata.domain.AuditOutgoingData;
import java.util.List;

/**
 * 外送数据接口审计Mapper接口
 *
 * @author ruoyi
 * @date 2020-06-03
 */
public interface AuditOutgoingDataMapper
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
     * 删除外送数据接口审计
     *
     * @param uuid 外送数据接口审计ID
     * @return 结果
     */
    public int deleteAuditOutgoingDataById(String uuid);

    /**
     * 批量删除外送数据接口审计
     *
     * @param uuids 需要删除的数据ID
     * @return 结果
     */
    public int deleteAuditOutgoingDataByIds(String[] uuids);
}
