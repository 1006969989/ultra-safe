package com.ultrapower.project.system.physecannex.service;

import com.ultrapower.project.system.physecannex.domain.Annex;
import java.util.List;

/**
 * 物理安全情况附件Service接口
 *
 * @author 王聪
 * @date 2020-05-27
 */
public interface IAnnexService
{
    /**
     * 查询物理安全情况附件
     *
     * @param uuid 物理安全情况附件ID
     * @return 物理安全情况附件
     */
    public Annex selectAnnexById(String uuid);

    /**
     * 查询物理安全情况附件列表
     *
     * @param annex 物理安全情况附件
     * @return 物理安全情况附件集合
     */
    public List<Annex> selectAnnexList(Annex annex);

    /**
     * 新增物理安全情况附件
     *
     * @param annex 物理安全情况附件
     * @return 结果
     */
    public int insertAnnex(Annex annex);

    /**
     * 修改物理安全情况附件
     *
     * @param annex 物理安全情况附件
     * @return 结果
     */
    public int updateAnnex(Annex annex);

    /**
     * 批量删除物理安全情况附件
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteAnnexByIds(String ids);

    /**
     * 删除物理安全情况附件信息
     *
     * @param uuid 物理安全情况附件ID
     * @return 结果
     */
    public int deleteAnnexById(String uuid);

    //新增
    /**
     * 修改物理安全情况附件，用于靠挂到系统
     *
     * @param systemuuid 需要靠挂到哪个系统
     * @return 结果
     */
    public int updateAnnexToSys(String systemuuid);
    /**
     * 删除物理安全情况附件
     *
     * @param systemuuid 物所属系统ID
     * @return 结果
     */
    public int deleteAnnexBySystemUuid(String systemuuid);
}
