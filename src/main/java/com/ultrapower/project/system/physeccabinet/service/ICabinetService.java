package com.ultrapower.project.system.physeccabinet.service;

import com.ultrapower.project.system.physeccabinet.domain.Cabinet;

import java.util.List;

/**
 * 物理安全情况涉及机柜Service接口
 *
 * @author 王聪
 * @date 2020-05-25
 */
public interface ICabinetService
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
     * 批量删除物理安全情况涉及机柜
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCabinetByIds(String ids);

    /**
     * 删除物理安全情况涉及机柜信息
     *
     * @param uuid 物理安全情况涉及机柜ID
     * @return 结果
     */
    public int deleteCabinetById(String uuid);

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
