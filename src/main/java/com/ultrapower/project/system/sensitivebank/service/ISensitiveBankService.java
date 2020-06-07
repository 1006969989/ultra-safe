package com.ultrapower.project.system.sensitivebank.service;

import com.ultrapower.project.system.sensitivebank.domain.SensitiveBank;
import java.util.List;

/**
 * 涉敏人员库Service接口
 *
 * @author wangcong
 * @date 2020-06-07
 */
public interface ISensitiveBankService
{
    /**
     * 查询涉敏人员库
     *
     * @param uuid 涉敏人员库ID
     * @return 涉敏人员库
     */
    public SensitiveBank selectSensitiveBankById(String uuid);

    /**
     * 查询涉敏人员库列表
     *
     * @param sensitiveBank 涉敏人员库
     * @return 涉敏人员库集合
     */
    public List<SensitiveBank> selectSensitiveBankList(SensitiveBank sensitiveBank);

    /**
     * 新增涉敏人员库
     *
     * @param sensitiveBank 涉敏人员库
     * @return 结果
     */
    public int insertSensitiveBank(SensitiveBank sensitiveBank);

    /**
     * 修改涉敏人员库
     *
     * @param sensitiveBank 涉敏人员库
     * @return 结果
     */
    public int updateSensitiveBank(SensitiveBank sensitiveBank);

    /**
     * 批量删除涉敏人员库
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSensitiveBankByIds(String ids);

    /**
     * 删除涉敏人员库信息
     *
     * @param uuid 涉敏人员库ID
     * @return 结果
     */
    public int deleteSensitiveBankById(String uuid);
}
