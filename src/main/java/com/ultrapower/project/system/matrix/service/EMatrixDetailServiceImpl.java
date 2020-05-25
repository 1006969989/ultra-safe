package com.ultrapower.project.system.matrix.service;

import com.ultrapower.common.utils.text.Convert;
import com.ultrapower.project.system.matrix.domain.EMatrixDetail;
import com.ultrapower.project.system.matrix.mapper.EMatrixDetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 矩阵明细Service业务层处理
 *
 * @author ruoyi
 * @date 2020-05-19
 */
@Service
public class EMatrixDetailServiceImpl implements IEMatrixDetailService
{
    @Autowired
    private EMatrixDetailMapper eMatrixDetailMapper;

    /**
     * 查询矩阵明细
     *
     * @param uuid 矩阵明细ID
     * @return 矩阵明细
     */
    @Override
    public EMatrixDetail selectEMatrixDetailById(String uuid)
    {
        return eMatrixDetailMapper.selectEMatrixDetailById(uuid);
    }

    /**
     * 查询矩阵明细列表
     *
     * @param eMatrixDetail 矩阵明细
     * @return 矩阵明细
     */
    @Override
    public List<EMatrixDetail> selectEMatrixDetailList(EMatrixDetail eMatrixDetail)
    {
        return eMatrixDetailMapper.selectEMatrixDetailList(eMatrixDetail);
    }

    /**
     * 新增矩阵明细
     *
     * @param eMatrixDetail 矩阵明细
     * @return 结果
     */
    @Override
    public int insertEMatrixDetail(EMatrixDetail eMatrixDetail)
    {
        return eMatrixDetailMapper.insertEMatrixDetail(eMatrixDetail);
    }

    /**
     * 修改矩阵明细
     *
     * @param eMatrixDetail 矩阵明细
     * @return 结果
     */
    @Override
    public int updateEMatrixDetail(EMatrixDetail eMatrixDetail)
    {
        return eMatrixDetailMapper.updateEMatrixDetail(eMatrixDetail);
    }

    /**
     * 删除矩阵明细对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteEMatrixDetailByIds(String ids)
    {
        return eMatrixDetailMapper.deleteEMatrixDetailByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除矩阵明细信息
     *
     * @param uuid 矩阵明细ID
     * @return 结果
     */
    @Override
    public int deleteEMatrixDetailById(String uuid)
    {
        return eMatrixDetailMapper.deleteEMatrixDetailById(uuid);
    }
}