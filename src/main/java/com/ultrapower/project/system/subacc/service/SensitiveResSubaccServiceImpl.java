package com.ultrapower.project.system.subacc.service;

import com.ultrapower.common.exception.BusinessException;
import com.ultrapower.common.utils.StringUtils;
import com.ultrapower.common.utils.text.Convert;
import com.ultrapower.project.system.subacc.domain.SensitiveResSubacc;
import com.ultrapower.project.system.subacc.mapper.SensitiveResSubaccMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 涉敏资产库Service业务层处理
 *
 * @author ruoyi
 * @date 2020-06-04
 */
@Service
public class SensitiveResSubaccServiceImpl implements ISensitiveResSubaccService
{
    private static final Logger log = LoggerFactory.getLogger(SensitiveResSubaccServiceImpl.class);
    @Autowired
    private SensitiveResSubaccMapper sensitiveResSubaccMapper;

    /**
     * 查询涉敏资产库
     *
     * @param uuid 涉敏资产库ID
     * @return 涉敏资产库
     */
    @Override
    public SensitiveResSubacc selectSensitiveResSubaccById(String uuid)
    {
        return sensitiveResSubaccMapper.selectSensitiveResSubaccById(uuid);
    }

    /**
     * 查询涉敏资产库列表
     *
     * @param sensitiveResSubacc 涉敏资产库
     * @return 涉敏资产库
     */
    @Override
    public List<SensitiveResSubacc> selectSensitiveResSubaccList(SensitiveResSubacc sensitiveResSubacc)
    {
        return sensitiveResSubaccMapper.selectSensitiveResSubaccList(sensitiveResSubacc);
    }

    /**
     * 新增涉敏资产库
     *
     * @param sensitiveResSubacc 涉敏资产库
     * @return 结果
     */
    @Override
    public int insertSensitiveResSubacc(SensitiveResSubacc sensitiveResSubacc)
    {
        return sensitiveResSubaccMapper.insertSensitiveResSubacc(sensitiveResSubacc);
    }

    /**
     * 修改涉敏资产库
     *
     * @param sensitiveResSubacc 涉敏资产库
     * @return 结果
     */
    @Override
    public int updateSensitiveResSubacc(SensitiveResSubacc sensitiveResSubacc)
    {
        return sensitiveResSubaccMapper.updateSensitiveResSubacc(sensitiveResSubacc);
    }

    /**
     * 删除涉敏资产库对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSensitiveResSubaccByIds(String ids)
    {
        return sensitiveResSubaccMapper.deleteSensitiveResSubaccByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除涉敏资产库信息
     *
     * @param uuid 涉敏资产库ID
     * @return 结果
     */
    @Override
    public int deleteSensitiveResSubaccById(String uuid)
    {
        return sensitiveResSubaccMapper.deleteSensitiveResSubaccById(uuid);
    }

    /**
     * 导入涉敏资产库数据
     *
     * @param sensitiveResSubaccsList        涉敏资产库数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @return 结果
     */
    public String importData(List<SensitiveResSubacc> sensitiveResSubaccsList, Boolean isUpdateSupport){
        if (StringUtils.isNull(sensitiveResSubaccsList) || sensitiveResSubaccsList.size() == 0) {
            throw new BusinessException("导入数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (SensitiveResSubacc sensitiveResSubacc : sensitiveResSubaccsList) {
            try {
                // 验证是否存在这条数据
                SensitiveResSubacc s = sensitiveResSubaccMapper.selectSensitiveResSubaccById(sensitiveResSubacc.getUuid());
                if (StringUtils.isNull(s)) {
                    this.insertSensitiveResSubacc(sensitiveResSubacc);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、导入成功");
                } else if (isUpdateSupport) {
                    this.updateSensitiveResSubacc(sensitiveResSubacc);
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