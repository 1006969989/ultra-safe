package com.ultrapower.project.system.range.service;

import com.ultrapower.common.utils.text.Convert;
import com.ultrapower.project.system.range.domain.ESensitiveRange;
import com.ultrapower.project.system.range.mapper.ESensitiveRangeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 涉敏数据范围Service业务层处理
 *
 * @author ruoyi
 * @date 2020-05-20
 */
@Service
public class ESensitiveRangeServiceImpl implements IESensitiveRangeService
{
    @Autowired
    private ESensitiveRangeMapper eSensitiveRangeMapper;

    /**
     * 查询涉敏数据范围
     *
     * @param uuid 涉敏数据范围ID
     * @return 涉敏数据范围
     */
    @Override
    public ESensitiveRange selectESensitiveRangeById(String uuid)
    {
        return eSensitiveRangeMapper.selectESensitiveRangeById(uuid);
    }

    /**
     * 查询涉敏数据范围列表
     *
     * @param eSensitiveRange 涉敏数据范围
     * @return 涉敏数据范围
     */
    @Override
    public List<ESensitiveRange> selectESensitiveRangeList(ESensitiveRange eSensitiveRange)
    {
        return eSensitiveRangeMapper.selectESensitiveRangeList(eSensitiveRange);
    }

    /**
     * 新增涉敏数据范围
     *
     * @param eSensitiveRange 涉敏数据范围
     * @return 结果
     */
    @Override
    public int insertESensitiveRange(ESensitiveRange eSensitiveRange)
    {
        return eSensitiveRangeMapper.insertESensitiveRange(eSensitiveRange);
    }

    /**
     * 修改涉敏数据范围
     *
     * @param eSensitiveRange 涉敏数据范围
     * @return 结果
     */
    @Override
    public int updateESensitiveRange(ESensitiveRange eSensitiveRange)
    {
        return eSensitiveRangeMapper.updateESensitiveRange(eSensitiveRange);
    }

    /**
     * 删除涉敏数据范围对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteESensitiveRangeByIds(String ids)
    {
        return eSensitiveRangeMapper.deleteESensitiveRangeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除涉敏数据范围信息
     *
     * @param uuid 涉敏数据范围ID
     * @return 结果
     */
    @Override
    public int deleteESensitiveRangeById(String uuid)
    {
        return eSensitiveRangeMapper.deleteESensitiveRangeById(uuid);
    }
}