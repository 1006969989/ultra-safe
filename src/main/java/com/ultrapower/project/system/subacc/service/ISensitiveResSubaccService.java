package com.ultrapower.project.system.subacc.service;

import com.ultrapower.project.system.subacc.domain.SensitiveResSubacc;

import java.util.List;

/**
 * 涉敏资产库Service接口
 *
 * @author ruoyi
 * @date 2020-06-04
 */
public interface ISensitiveResSubaccService
{
    /**
     * 查询涉敏资产库
     *
     * @param uuid 涉敏资产库ID
     * @return 涉敏资产库
     */
    public SensitiveResSubacc selectSensitiveResSubaccById(String uuid);

    /**
     * 查询涉敏资产库列表
     *
     * @param sensitiveResSubacc 涉敏资产库
     * @return 涉敏资产库集合
     */
    public List<SensitiveResSubacc> selectSensitiveResSubaccList(SensitiveResSubacc sensitiveResSubacc);

    /**
     * 新增涉敏资产库
     *
     * @param sensitiveResSubacc 涉敏资产库
     * @return 结果
     */
    public int insertSensitiveResSubacc(SensitiveResSubacc sensitiveResSubacc);

    /**
     * 修改涉敏资产库
     *
     * @param sensitiveResSubacc 涉敏资产库
     * @return 结果
     */
    public int updateSensitiveResSubacc(SensitiveResSubacc sensitiveResSubacc);

    /**
     * 批量删除涉敏资产库
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSensitiveResSubaccByIds(String ids);

    /**
     * 删除涉敏资产库信息
     *
     * @param uuid 涉敏资产库ID
     * @return 结果
     */
    public int deleteSensitiveResSubaccById(String uuid);
    /**
     * 导入涉敏资产库数据
     *
     * @param sensitiveResSubaccsList 涉敏资产库数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @return 结果
     */
    public String importData(List<SensitiveResSubacc> sensitiveResSubaccsList, Boolean isUpdateSupport) ;
}