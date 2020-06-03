package com.ultrapower.project.system.physecsys.mapper;

import com.ultrapower.project.system.physecsys.domain.PhySecSys;

import java.util.List;

/**
 * 物理安全情况Mapper接口
 *
 * @author ruoyi
 * @date 2020-05-25
 */
public interface PhySecSysMapper
{
    /**
     * 查询物理安全情况
     *
     * @param uuid 物理安全情况ID
     * @return 物理安全情况
     */
    public PhySecSys selectPhySecSysById(String uuid);

    /**
     * 查询物理安全情况列表
     *
     * @param
     * @return 物理安全情况集合
     */
    public List<PhySecSys> selectPhySecSysList(PhySecSys phySecSys);

    /**
     * 新增物理安全情况
     *
     * @param phySecSys 物理安全情况
     * @return 结果
     */
    public int insertPhySecSys(PhySecSys phySecSys);

    /**
     * 修改物理安全情况
     *
     * @param phySecSys 物理安全情况
     * @return 结果
     */
    public int updatePhySecSys(PhySecSys phySecSys);

    /**
     * 删除物理安全情况
     *
     * @param uuid 物理安全情况ID
     * @return 结果
     */
    public int deletePhySecSysById(String uuid);

    /**
     * 批量删除物理安全情况
     *
     * @param uuids 需要删除的数据ID
     * @return 结果
     */
    public int deletePhySecSysByIds(String[] uuids);
}
