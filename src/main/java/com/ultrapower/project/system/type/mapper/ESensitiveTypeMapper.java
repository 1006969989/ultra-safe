package com.ultrapower.project.system.type.mapper;

import com.ultrapower.project.system.type.domain.ESensitiveType;

import java.util.List;

/**
 * 涉敏数据类型Mapper接口
 *
 * @author ruoyi
 * @date 2020-05-20
 */
public interface ESensitiveTypeMapper
{
    /**
     * 查询涉敏数据类型
     *
     * @param uuid 涉敏数据类型ID
     * @return 涉敏数据类型
     */
    public ESensitiveType selectESensitiveTypeById(String uuid);

    /**
     * 查询涉敏数据类型列表
     *
     * @param eSensitiveType 涉敏数据类型
     * @return 涉敏数据类型集合
     */
    public List<ESensitiveType> selectESensitiveTypeList(ESensitiveType eSensitiveType);

    /**
     * 新增涉敏数据类型
     *
     * @param eSensitiveType 涉敏数据类型
     * @return 结果
     */
    public int insertESensitiveType(ESensitiveType eSensitiveType);

    /**
     * 修改涉敏数据类型
     *
     * @param eSensitiveType 涉敏数据类型
     * @return 结果
     */
    public int updateESensitiveType(ESensitiveType eSensitiveType);

    /**
     * 删除涉敏数据类型
     *
     * @param uuid 涉敏数据类型ID
     * @return 结果
     */
    public int deleteESensitiveTypeById(String uuid);

    /**
     * 批量删除涉敏数据类型
     *
     * @param uuids 需要删除的数据ID
     * @return 结果
     */
    public int deleteESensitiveTypeByIds(String[] uuids);
}