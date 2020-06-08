package com.ultrapower.project.system.sensitivebank.service.impl;

import java.util.List;

import com.ultrapower.common.utils.text.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ultrapower.project.system.sensitivebank.mapper.SensitiveBankMapper;
import com.ultrapower.project.system.sensitivebank.domain.SensitiveBank;
import com.ultrapower.project.system.sensitivebank.service.ISensitiveBankService;

/**
 * 涉敏人员库Service业务层处理
 *
 * @author wangcong
 * @date 2020-06-07
 */
@Service
public class SensitiveBankServiceImpl implements ISensitiveBankService
{
    @Autowired
    private SensitiveBankMapper sensitiveBankMapper;

    /**
     * 查询涉敏人员库
     *
     * @param uuid 涉敏人员库ID
     * @return 涉敏人员库
     */
    @Override
    public SensitiveBank selectSensitiveBankById(String uuid)
    {
        return sensitiveBankMapper.selectSensitiveBankById(uuid);
    }

    /**
     * 查询涉敏人员库列表
     *
     * @param sensitiveBank 涉敏人员库
     * @return 涉敏人员库
     */
    @Override
    public List<SensitiveBank> selectSensitiveBankList(SensitiveBank sensitiveBank)
    {
        return sensitiveBankMapper.selectSensitiveBankList(sensitiveBank);
    }

    /**
     * 新增涉敏人员库
     *
     * @param sensitiveBank 涉敏人员库
     * @return 结果
     */
    @Override
    public int insertSensitiveBank(SensitiveBank sensitiveBank)
    {
        return sensitiveBankMapper.insertSensitiveBank(sensitiveBank);
    }

    /**
     * 修改涉敏人员库
     *
     * @param sensitiveBank 涉敏人员库
     * @return 结果
     */
    @Override
    public int updateSensitiveBank(SensitiveBank sensitiveBank)
    {
        return sensitiveBankMapper.updateSensitiveBank(sensitiveBank);
    }

    /**
     * 删除涉敏人员库对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSensitiveBankByIds(String ids)
    {
        return sensitiveBankMapper.deleteSensitiveBankByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除涉敏人员库信息
     *
     * @param uuid 涉敏人员库ID
     * @return 结果
     */
    @Override
    public int deleteSensitiveBankById(String uuid)
    {
        return sensitiveBankMapper.deleteSensitiveBankById(uuid);
    }
}
