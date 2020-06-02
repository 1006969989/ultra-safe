package com.ultrapower.project.system.sharedatainfo.service;


import com.ultrapower.common.exception.BusinessException;
import com.ultrapower.common.utils.StringUtils;
import com.ultrapower.common.utils.security.ShiroUtils;
import com.ultrapower.common.utils.text.Convert;
import com.ultrapower.project.system.sharedatainfo.domain.ESystemsharedataInfo;
import com.ultrapower.project.system.sharedatainfo.mapper.ESystemsharedataInfoMapper;
import com.ultrapower.project.system.user.service.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 系统共享数据Service业务层处理
 *
 * @author ruoyi
 * @date 2020-06-01
 */
@Service
public class ESystemsharedataInfoServiceImpl implements IESystemsharedataInfoService
{
    private static final Logger log = LoggerFactory.getLogger(ESystemsharedataInfoServiceImpl.class);

    @Autowired
    private ESystemsharedataInfoMapper eSystemsharedataInfoMapper;

    /**
     * 查询系统共享数据
     *
     * @param uuid 系统共享数据ID
     * @return 系统共享数据
     */
    @Override
    public ESystemsharedataInfo selectESystemsharedataInfoById(String uuid)
    {
        return eSystemsharedataInfoMapper.selectESystemsharedataInfoById(uuid);
    }

    /**
     * 查询系统共享数据列表
     *
     * @param eSystemsharedataInfo 系统共享数据
     * @return 系统共享数据
     */
    @Override
    public List<ESystemsharedataInfo> selectESystemsharedataInfoList(ESystemsharedataInfo eSystemsharedataInfo)
    {
        return eSystemsharedataInfoMapper.selectESystemsharedataInfoList(eSystemsharedataInfo);
    }

    /**
     * 新增系统共享数据
     *
     * @param eSystemsharedataInfo 系统共享数据
     * @return 结果
     */
    @Override
    public int insertESystemsharedataInfo(ESystemsharedataInfo eSystemsharedataInfo)
    {
        return eSystemsharedataInfoMapper.insertESystemsharedataInfo(eSystemsharedataInfo);
    }

    /**
     * 修改系统共享数据
     *
     * @param eSystemsharedataInfo 系统共享数据
     * @return 结果
     */
    @Override
    public int updateESystemsharedataInfo(ESystemsharedataInfo eSystemsharedataInfo)
    {
        return eSystemsharedataInfoMapper.updateESystemsharedataInfo(eSystemsharedataInfo);
    }

    /**
     * 删除系统共享数据对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteESystemsharedataInfoByIds(String ids)
    {
        return eSystemsharedataInfoMapper.deleteESystemsharedataInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除系统共享数据信息
     *
     * @param uuid 系统共享数据ID
     * @return 结果
     */
    @Override
    public int deleteESystemsharedataInfoById(String uuid)
    {
        return eSystemsharedataInfoMapper.deleteESystemsharedataInfoById(uuid);
    }
    /**
     * 导入用户数据
     *
     * @param eSystemsharedataInfoListList        用户数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @return 结果
     */
    @Override
    public String importData(List<ESystemsharedataInfo> eSystemsharedataInfoListList, Boolean isUpdateSupport) {
        if (StringUtils.isNull(eSystemsharedataInfoListList) || eSystemsharedataInfoListList.size() == 0) {
            throw new BusinessException("导入数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (ESystemsharedataInfo eSystemsharedataInfo : eSystemsharedataInfoListList) {
            try {
                // 验证是否存在这条数据
                ESystemsharedataInfo e = eSystemsharedataInfoMapper.selectESystemsharedataInfoById(eSystemsharedataInfo.getUuid());
                if (StringUtils.isNull(e)) {
                    this.insertESystemsharedataInfo(eSystemsharedataInfo);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、导入成功");
                } else if (isUpdateSupport) {
                    this.updateESystemsharedataInfo(eSystemsharedataInfo);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、更新成功");
                } else {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、 已存在");
                }
            } catch (Exception e) {
                failureNum++;
                String msg = "<br/>" + failureNum + "、 导入失败：";
                failureMsg.append(msg + e.getMessage());
                log.error(msg, e);
            }
        }
        if (failureNum > 0) {
            failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
            throw new BusinessException(failureMsg.toString());
        } else {
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        }
        return successMsg.toString();
    }
}