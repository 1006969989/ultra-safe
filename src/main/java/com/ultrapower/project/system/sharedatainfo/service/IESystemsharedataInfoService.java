package com.ultrapower.project.system.sharedatainfo.service;

import com.ultrapower.project.system.sharedatainfo.domain.ESystemsharedataInfo;

import java.util.List;

/**
 * 系统共享数据Service接口
 *
 * @author ruoyi
 * @date 2020-06-01
 */
public interface IESystemsharedataInfoService
{
    /**
     * 查询系统共享数据
     *
     * @param uuid 系统共享数据ID
     * @return 系统共享数据
     */
    public ESystemsharedataInfo selectESystemsharedataInfoById(String uuid);

    /**
     * 查询系统共享数据列表
     *
     * @param eSystemsharedataInfo 系统共享数据
     * @return 系统共享数据集合
     */
    public List<ESystemsharedataInfo> selectESystemsharedataInfoList(ESystemsharedataInfo eSystemsharedataInfo);

    /**
     * 新增系统共享数据
     *
     * @param eSystemsharedataInfo 系统共享数据
     * @return 结果
     */
    public int insertESystemsharedataInfo(ESystemsharedataInfo eSystemsharedataInfo);

    /**
     * 修改系统共享数据
     *
     * @param eSystemsharedataInfo 系统共享数据
     * @return 结果
     */
    public int updateESystemsharedataInfo(ESystemsharedataInfo eSystemsharedataInfo);

    /**
     * 批量删除系统共享数据
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteESystemsharedataInfoByIds(String ids);

    /**
     * 删除系统共享数据信息
     *
     * @param uuid 系统共享数据ID
     * @return 结果
     */
    public int deleteESystemsharedataInfoById(String uuid);
    /**
     * 导入系统共享数据
     *
     * @param eSystemsharedataInfoList 系统共享数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @return 结果
     */
    public String importData(List<ESystemsharedataInfo> eSystemsharedataInfoList, Boolean isUpdateSupport) ;
}