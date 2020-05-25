package com.ultrapower.project.system.type.service;

import com.ultrapower.common.utils.text.Convert;
import com.ultrapower.project.system.type.domain.ESensitiveType;
import com.ultrapower.project.system.type.mapper.ESensitiveTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 涉敏数据类型Service业务层处理
 *
 * @author ruoyi
 * @date 2020-05-20
 */
@Service
public class ESensitiveTypeServiceImpl implements IESensitiveTypeService
{
    @Autowired
    private ESensitiveTypeMapper eSensitiveTypeMapper;

    /**
     * 查询涉敏数据类型
     *
     * @param uuid 涉敏数据类型ID
     * @return 涉敏数据类型
     */
    @Override
    public ESensitiveType selectESensitiveTypeById(String uuid)
    {
        return eSensitiveTypeMapper.selectESensitiveTypeById(uuid);
    }

    /**
     * 查询涉敏数据类型列表
     *
     * @param eSensitiveType 涉敏数据类型
     * @return 涉敏数据类型
     */
    @Override
    public List<ESensitiveType> selectESensitiveTypeList(ESensitiveType eSensitiveType)
    {
        return eSensitiveTypeMapper.selectESensitiveTypeList(eSensitiveType);
    }

    /**
     * 新增涉敏数据类型
     *
     * @param eSensitiveType 涉敏数据类型
     * @return 结果
     */
    @Override
    public int insertESensitiveType(ESensitiveType eSensitiveType)
    {
        return eSensitiveTypeMapper.insertESensitiveType(eSensitiveType);
    }

    /**
     * 修改涉敏数据类型
     *
     * @param eSensitiveType 涉敏数据类型
     * @return 结果
     */
    @Override
    public int updateESensitiveType(ESensitiveType eSensitiveType)
    {
        return eSensitiveTypeMapper.updateESensitiveType(eSensitiveType);
    }

    /**
     * 删除涉敏数据类型对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteESensitiveTypeByIds(String ids)
    {
        return eSensitiveTypeMapper.deleteESensitiveTypeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除涉敏数据类型信息
     *
     * @param uuid 涉敏数据类型ID
     * @return 结果
     */
    @Override
    public int deleteESensitiveTypeById(String uuid)
    {
        return eSensitiveTypeMapper.deleteESensitiveTypeById(uuid);
    }
}