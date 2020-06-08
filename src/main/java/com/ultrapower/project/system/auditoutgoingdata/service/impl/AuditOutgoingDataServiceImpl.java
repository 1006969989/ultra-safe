package com.ultrapower.project.system.auditoutgoingdata.service.impl;

import java.util.List;
import com.ultrapower.common.utils.DateUtils;
import com.ultrapower.common.utils.security.ShiroUtils;
import com.ultrapower.project.system.user.domain.User;
import com.ultrapower.project.system.user.mapper.UserMapper;
import com.ultrapower.project.system.user.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ultrapower.project.system.auditoutgoingdata.mapper.AuditOutgoingDataMapper;
import com.ultrapower.project.system.auditoutgoingdata.domain.AuditOutgoingData;
import com.ultrapower.project.system.auditoutgoingdata.service.IAuditOutgoingDataService;
import com.ultrapower.common.utils.text.Convert;

/**
 * 外送数据接口审计Service业务层处理
 *
 * @author ruoyi
 * @date 2020-06-03
 */
@Service
public class AuditOutgoingDataServiceImpl implements IAuditOutgoingDataService
{
    @Autowired
    private AuditOutgoingDataMapper auditOutgoingDataMapper;

    @Autowired
    private UserMapper userMapper;

    /**
     * 查询外送数据接口审计
     *
     * @param uuid 外送数据接口审计ID
     * @return 外送数据接口审计
     */
    @Override
    public AuditOutgoingData selectAuditOutgoingDataById(String uuid)
    {
        return auditOutgoingDataMapper.selectAuditOutgoingDataById(uuid);
    }

    /**
     * 查询外送数据接口审计
     *
     * @param uuids 外送数据接口审计uuid数组
     * @return 外送数据接口审计
     */
    @Override
    public List<AuditOutgoingData> selectAuditOutgoingDataByIds(String[] uuids) {
        return auditOutgoingDataMapper.selectAuditOutgoingDataByIds(uuids);
    }

    /**
     * 查询外送数据接口审计列表
     *
     * @param auditOutgoingData 外送数据接口审计
     * @return 外送数据接口审计
     */
    @Override
    public List<AuditOutgoingData> selectAuditOutgoingDataList(AuditOutgoingData auditOutgoingData)
    {
        List<AuditOutgoingData> dataList = auditOutgoingDataMapper.selectAuditOutgoingDataList(auditOutgoingData);
        if(dataList != null && dataList.size() > 0){
            for(int i = 0; i < dataList.size(); i++){
                AuditOutgoingData data = dataList.get(i);
                if(data != null && data.getLogicdelete() != null && !"".equals(data.getLogicdelete())){
                    if("0".equals(data.getLogicdelete())){
                        data.setLogicdelete("否");
                    }else if("1".equals(data.getLogicdelete())){
                        data.setLogicdelete("是");
                    }
                }
            }
        }
        return dataList;
    }

    /**
     * 新增外送数据接口审计
     *
     * @param auditOutgoingData 外送数据接口审计
     * @return 结果
     */
    @Override
    public int insertAuditOutgoingData(AuditOutgoingData auditOutgoingData) {

        User user = null;
        if(auditOutgoingData != null){
            auditOutgoingData.setCreateTime(DateUtils.getNowDate());
            auditOutgoingData.setCreateUserid(ShiroUtils.getLoginName());

            if(auditOutgoingData.getAuditor() != null && !"".equals(auditOutgoingData.getAuditor())){
                user = userMapper.selectUserByLoginName(auditOutgoingData.getAuditor());
            }
        }
        if(user != null && user.getUserId() != null && !"".equals(user.getUserId())){
            auditOutgoingData.setAuditorId(String.valueOf(user.getUserId()));
        }
        return auditOutgoingDataMapper.insertAuditOutgoingData(auditOutgoingData);
    }

    /**
     * 修改外送数据接口审计
     *
     * @param auditOutgoingData 外送数据接口审计
     * @return 结果
     */
    @Override
    public int updateAuditOutgoingData(AuditOutgoingData auditOutgoingData)
    {
        if(auditOutgoingData != null){
            auditOutgoingData.setModifyUserid(ShiroUtils.getLoginName());
            auditOutgoingData.setModifyTime(DateUtils.getNowDate());
        }
        return auditOutgoingDataMapper.updateAuditOutgoingData(auditOutgoingData);
    }

    /**
     * 删除外送数据接口审计对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteAuditOutgoingDataByIds(String ids)
    {
        return auditOutgoingDataMapper.deleteAuditOutgoingDataByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除外送数据接口审计信息
     *
     * @param uuid 外送数据接口审计ID
     * @return 结果
     */
    @Override
    public int deleteAuditOutgoingDataById(String uuid)
    {
        return auditOutgoingDataMapper.deleteAuditOutgoingDataById(uuid);
    }
}
