package com.ultrapower.project.system.physeccabinet.mapper;

import com.ultrapower.project.system.physeccabinet.domain.Cabinet;

import java.util.List;

/**
 * 物理安全情况涉及机柜Mapper接口
 *
 * @author 王聪
 * @date 2020-05-25
 */
public interface CabinetMapper
{
    /**
     * 查询物理安全情况涉及机柜
     *
     * @param uuid 物理安全情况涉及机柜ID
     * @return 物理安全情况涉及机柜
     */
    public Cabinet selectCabinetById(String uuid);

    /**
     * 查询物理安全情况涉及机柜列表
     *
     * @param cabinet 物理安全情况涉及机柜
     * @return 物理安全情况涉及机柜集合
     */
    public List<Cabinet> selectCabinetList(Cabinet cabinet);

    /**
     * 新增物理安全情况涉及机柜
     *
     * @param cabinet 物理安全情况涉及机柜
     * @return 结果
     */
    public int insertCabinet(Cabinet cabinet);

    /**
     * 修改物理安全情况涉及机柜
     *
     * @param cabinet 物理安全情况涉及机柜
     * @return 结果
     */
    public int updateCabinet(Cabinet cabinet);

    /**
     * 删除物理安全情况涉及机柜
     *
     * @param uuid 物理安全情况涉及机柜ID
     * @return 结果
     */
    public int deleteCabinetById(String uuid);

    /**
     * 批量删除物理安全情况涉及机柜
     *
     * @param uuids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCabinetByIds(String[] uuids);

    //新增
    /**
     * 修改物理安全情况涉及机柜，用于靠挂到所属系统
     *
     * @param systemuuid 所属系统ID
     * @return 结果
     */
    public int updateCabinetToSys(String systemuuid);

    /**
     * 删除物理安全情况涉及机柜
     *
     * @param systemuuid 所属系统ID
     * @return 结果
     */
    public int deleteCabinetBySystemUuid(String systemuuid);
}
