package com.ultrapower.project.system.matrix.service;

import com.ultrapower.project.system.matrix.domain.EMatrixDetail;

import java.util.List;

/**
 * 矩阵明细Service接口
 *
 * @author ruoyi
 * @date 2020-05-19
 */
public interface IEMatrixDetailService
{
    /**
     * 查询矩阵明细
     *
     * @param uuid 矩阵明细ID
     * @return 矩阵明细
     */
    public EMatrixDetail selectEMatrixDetailById(String uuid);

    /**
     * 查询矩阵明细列表
     *
     * @param eMatrixDetail 矩阵明细
     * @return 矩阵明细集合
     */
    public List<EMatrixDetail> selectEMatrixDetailList(EMatrixDetail eMatrixDetail);

    /**
     * 新增矩阵明细
     *
     * @param eMatrixDetail 矩阵明细
     * @return 结果
     */
    public int insertEMatrixDetail(EMatrixDetail eMatrixDetail);

    /**
     * 修改矩阵明细
     *
     * @param eMatrixDetail 矩阵明细
     * @return 结果
     */
    public int updateEMatrixDetail(EMatrixDetail eMatrixDetail);

    /**
     * 批量删除矩阵明细
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteEMatrixDetailByIds(String ids);

    /**
     * 删除矩阵明细信息
     *
     * @param uuid 矩阵明细ID
     * @return 结果
     */
    public int deleteEMatrixDetailById(String uuid);
}