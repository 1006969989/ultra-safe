package com.ultrapower.project.system.range.service;
import com.ultrapower.project.system.range.domain.ESensitiveRange;

import java.util.List;

/**
 * 涉敏数据范围Service接口
 *
 * @author ruoyi
 * @date 2020-05-20
 */
public interface IESensitiveRangeService
{
    /**
     * 查询涉敏数据范围
     *
     * @param uuid 涉敏数据范围ID
     * @return 涉敏数据范围
     */
    public ESensitiveRange selectESensitiveRangeById(String uuid);

    /**
     * 查询涉敏数据范围列表
     *
     * @param eSensitiveRange 涉敏数据范围
     * @return 涉敏数据范围集合
     */
    public List<ESensitiveRange> selectESensitiveRangeList(ESensitiveRange eSensitiveRange);

    /**
     * 新增涉敏数据范围
     *
     * @param eSensitiveRange 涉敏数据范围
     * @return 结果
     */
    public int insertESensitiveRange(ESensitiveRange eSensitiveRange);

    /**
     * 修改涉敏数据范围
     *
     * @param eSensitiveRange 涉敏数据范围
     * @return 结果
     */
    public int updateESensitiveRange(ESensitiveRange eSensitiveRange);

    /**
     * 批量删除涉敏数据范围
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteESensitiveRangeByIds(String ids);

    /**
     * 删除涉敏数据范围信息
     *
     * @param uuid 涉敏数据范围ID
     * @return 结果
     */
    public int deleteESensitiveRangeById(String uuid);
}