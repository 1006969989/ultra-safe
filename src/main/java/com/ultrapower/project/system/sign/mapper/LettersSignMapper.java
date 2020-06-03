package com.ultrapower.project.system.sign.mapper;

import com.ultrapower.project.system.sign.domain.LettersSign;
import java.util.List;

/**
 * 责任书和保密协议签署情况Mapper接口
 *
 * @author 王聪
 * @date 2020-06-01
 */
public interface LettersSignMapper
{
    /**
     * 查询责任书和保密协议签署情况
     *
     * @param uuid 责任书和保密协议签署情况ID
     * @return 责任书和保密协议签署情况
     */
    public LettersSign selectLettersSignById(String uuid);

    /**
     * 查询责任书和保密协议签署情况列表
     *
     * @param lettersSign 责任书和保密协议签署情况
     * @return 责任书和保密协议签署情况集合
     */
    public List<LettersSign> selectLettersSignList(LettersSign lettersSign);

    /**
     * 新增责任书和保密协议签署情况
     *
     * @param lettersSign 责任书和保密协议签署情况
     * @return 结果
     */
    public int insertLettersSign(LettersSign lettersSign);

    /**
     * 修改责任书和保密协议签署情况
     *
     * @param lettersSign 责任书和保密协议签署情况
     * @return 结果
     */
    public int updateLettersSign(LettersSign lettersSign);

    /**
     * 删除责任书和保密协议签署情况
     *
     * @param uuid 责任书和保密协议签署情况ID
     * @return 结果
     */
    public int deleteLettersSignById(String uuid);

    /**
     * 批量删除责任书和保密协议签署情况
     *
     * @param uuids 需要删除的数据ID
     * @return 结果
     */
    public int deleteLettersSignByIds(String[] uuids);
}
