package com.ultrapower.project.system.auditoutgoingdata.service.impl;

import com.ultrapower.common.exception.BusinessException;
import com.ultrapower.common.utils.DateUtils;
import com.ultrapower.common.utils.StringUtils;
import com.ultrapower.common.utils.security.ShiroUtils;
import com.ultrapower.common.utils.text.Convert;
import com.ultrapower.project.system.auditoutgoingdata.domain.AuditOutgoingData;
import com.ultrapower.project.system.auditoutgoingdata.mapper.AuditOutgoingDataMapper;
import com.ultrapower.project.system.auditoutgoingdata.service.IAuditOutgoingDataService;
import com.ultrapower.project.system.user.domain.User;
import com.ultrapower.project.system.user.mapper.UserMapper;
import com.ultrapower.project.system.user.service.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 外送数据接口审计Service业务层处理
 *
 * @author ruoyi
 * @date 2020-06-03
 */
@Service
public class AuditOutgoingDataServiceImpl implements IAuditOutgoingDataService {

    private static final Logger log = LoggerFactory.getLogger(AuditOutgoingDataServiceImpl.class);

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

    @Override
    public String importAuditOutgoingData(List<AuditOutgoingData> auditOutgoingDataList, boolean updateSupport) {
        if (StringUtils.isNull(auditOutgoingDataList) || auditOutgoingDataList.size() == 0) {
            throw new BusinessException("导入外送数据接口数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        //行数
        int count = 0;
        for(int i = 0; i < auditOutgoingDataList.size(); i++){
            AuditOutgoingData auditOutgoingData = auditOutgoingDataList.get(i);
            count = i + 1;
            try {
                //设置审计人员id
                User user = null;
                if(auditOutgoingData == null){
                    continue;
                }
                auditOutgoingData.setCreateTime(DateUtils.getNowDate());
                auditOutgoingData.setCreateUserid(ShiroUtils.getLoginName());

                if(auditOutgoingData.getAuditor() != null && !"".equals(auditOutgoingData.getAuditor())){
                    user = userMapper.selectUserByLoginName(auditOutgoingData.getAuditor());
                }
                if(user != null && user.getUserId() != null && !"".equals(user.getUserId())){
                    auditOutgoingData.setAuditorId(String.valueOf(user.getUserId()));
                }

                //插入数据
                auditOutgoingDataMapper.insertAuditOutgoingData(auditOutgoingData);
                successNum++;
                successMsg.append("<br/>第" + count + "行数据导入成功");

            } catch (Exception e) {
                failureNum++;
                String msg = "<br/>第" + count + "行数据导入失败：";
                failureMsg.append(msg + e.getMessage());
                log.error(msg, e);
            }
        }
        if (failureNum > 0) {
            failureMsg.insert(0, "很抱歉，部分导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
            throw new BusinessException(failureMsg.toString());
        }
        if(successNum > 0){
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        }
        return successMsg.toString();
    }
}
