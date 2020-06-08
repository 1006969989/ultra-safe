package com.ultrapower.project.system.physecsys.service.impl;

import com.ultrapower.common.utils.text.Convert;
import com.ultrapower.project.system.physecsys.domain.PhySecSys;
import com.ultrapower.project.system.physecsys.mapper.PhySecSysMapper;
import com.ultrapower.project.system.physecsys.service.IPhySecSysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 物理安全情况Service业务层处理
 *
 * @author ruoyi
 * @date 2020-05-25
 */
@Service
public class PhySecSysServiceImpl implements IPhySecSysService
{
    @Autowired
    private PhySecSysMapper phySecSysMapper;

    /**
     * 查询物理安全情况
     *
     * @param uuid 物理安全情况ID
     * @return 物理安全情况
     */
    @Override
    public PhySecSys selectPhySecSysById(String uuid)
    {
        return phySecSysMapper.selectPhySecSysById(uuid);
    }

    /**
     * 查询物理安全情况列表
     *
     * @param phySecSys
     * @return 物理安全情况
     */
    @Override
    public List<PhySecSys> selectPhySecSysList(PhySecSys phySecSys)
    {
        return phySecSysMapper.selectPhySecSysList(phySecSys);
    }

    /**
     * 新增物理安全情况
     *
     * @param phySecSys 物理安全情况
     * @return 结果
     */
    @Override
    public int insertPhySecSys(PhySecSys phySecSys)
    {
        return phySecSysMapper.insertPhySecSys(phySecSys);
    }

    /**
     * 修改物理安全情况
     *
     * @param phySecSys 物理安全情况
     * @return 结果
     */
    @Override
    public int updatePhySecSys(PhySecSys phySecSys)
    {
        return phySecSysMapper.updatePhySecSys(phySecSys);
    }

    /**
     * 删除物理安全情况对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deletePhySecSysByIds(String ids)
    {
        return phySecSysMapper.deletePhySecSysByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除物理安全情况信息
     *
     * @param uuid 物理安全情况ID
     * @return 结果
     */
    @Override
    public int deletePhySecSysById(String uuid)
    {
        return phySecSysMapper.deletePhySecSysById(uuid);
    }
}
