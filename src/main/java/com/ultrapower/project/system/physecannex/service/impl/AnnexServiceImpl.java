package com.ultrapower.project.system.physecannex.service.impl;

import java.util.List;

import com.ultrapower.common.utils.text.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ultrapower.project.system.physecannex.mapper.AnnexMapper;
import com.ultrapower.project.system.physecannex.domain.Annex;
import com.ultrapower.project.system.physecannex.service.IAnnexService;

/**
 * 物理安全情况附件Service业务层处理
 *
 * @author 王聪
 * @date 2020-05-27
 */
@Service
public class AnnexServiceImpl implements IAnnexService
{
    @Autowired
    private AnnexMapper annexMapper;

    /**
     * 查询物理安全情况附件
     *
     * @param uuid 物理安全情况附件ID
     * @return 物理安全情况附件
     */
    @Override
    public Annex selectAnnexById(String uuid)
    {
        return annexMapper.selectAnnexById(uuid);
    }

    /**
     * 查询物理安全情况附件列表
     *
     * @param annex 物理安全情况附件
     * @return 物理安全情况附件
     */
    @Override
    public List<Annex> selectAnnexList(Annex annex)
    {
        return annexMapper.selectAnnexList(annex);
    }

    /**
     * 新增物理安全情况附件
     *
     * @param annex 物理安全情况附件
     * @return 结果
     */
    @Override
    public int insertAnnex(Annex annex)
    {
        return annexMapper.insertAnnex(annex);
    }

    /**
     * 修改物理安全情况附件
     *
     * @param annex 物理安全情况附件
     * @return 结果
     */
    @Override
    public int updateAnnex(Annex annex)
    {
        return annexMapper.updateAnnex(annex);
    }

    /**
     * 删除物理安全情况附件对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteAnnexByIds(String ids)
    {
        return annexMapper.deleteAnnexByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除物理安全情况附件信息
     *
     * @param uuid 物理安全情况附件ID
     * @return 结果
     */
    @Override
    public int deleteAnnexById(String uuid)
    {
        return annexMapper.deleteAnnexById(uuid);
    }

    @Override
    public int updateAnnexToSys(String systemuuid) {
        return annexMapper.updateAnnexToSys(systemuuid);
    }

    @Override
    public int deleteAnnexBySystemUuid(String systemuuid) {
        return annexMapper.deleteAnnexBySystemUuid(systemuuid);
    }
}
