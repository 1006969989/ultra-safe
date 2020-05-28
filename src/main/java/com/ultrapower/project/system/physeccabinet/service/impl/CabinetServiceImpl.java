package com.ultrapower.project.system.physeccabinet.service.impl;

import com.ultrapower.common.utils.text.Convert;
import com.ultrapower.project.system.physeccabinet.domain.Cabinet;
import com.ultrapower.project.system.physeccabinet.mapper.CabinetMapper;
import com.ultrapower.project.system.physeccabinet.service.ICabinetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 物理安全情况涉及机柜Service业务层处理
 *
 * @author 王聪
 * @date 2020-05-25
 */
@Service
public class CabinetServiceImpl implements ICabinetService
{
    @Autowired
    private CabinetMapper cabinetMapper;

    /**
     * 查询物理安全情况涉及机柜
     *
     * @param uuid 物理安全情况涉及机柜ID
     * @return 物理安全情况涉及机柜
     */
    @Override
    public Cabinet selectCabinetById(String uuid)
    {
        return cabinetMapper.selectCabinetById(uuid);
    }

    /**
     * 查询物理安全情况涉及机柜列表
     *
     * @param cabinet 物理安全情况涉及机柜
     * @return 物理安全情况涉及机柜
     */
    @Override
    public List<Cabinet> selectCabinetList(Cabinet cabinet)
    {
        return cabinetMapper.selectCabinetList(cabinet);
    }

    /**
     * 新增物理安全情况涉及机柜
     *
     * @param cabinet 物理安全情况涉及机柜
     * @return 结果
     */
    @Override
    public int insertCabinet(Cabinet cabinet)
    {
        return cabinetMapper.insertCabinet(cabinet);
    }

    /**
     * 修改物理安全情况涉及机柜
     *
     * @param cabinet 物理安全情况涉及机柜
     * @return 结果
     */
    @Override
    public int updateCabinet(Cabinet cabinet)
    {
        return cabinetMapper.updateCabinet(cabinet);
    }

    /**
     * 删除物理安全情况涉及机柜对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCabinetByIds(String ids)
    {
        return cabinetMapper.deleteCabinetByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除物理安全情况涉及机柜信息
     *
     * @param uuid 物理安全情况涉及机柜ID
     * @return 结果
     */
    @Override
    public int deleteCabinetById(String uuid)
    {
        return cabinetMapper.deleteCabinetById(uuid);
    }

    @Override
    public int updateCabinetToSys(String systemuuid) {
        return cabinetMapper.updateCabinetToSys(systemuuid);
    }

    @Override
    public int deleteCabinetBySystemUuid(String systemuuid) {
        return cabinetMapper.deleteCabinetBySystemUuid(systemuuid);
    }
}
