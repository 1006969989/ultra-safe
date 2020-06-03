package com.ultrapower.project.system.sign.service.impl;

import java.util.List;

import com.ultrapower.common.utils.text.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ultrapower.project.system.sign.mapper.LettersSignMapper;
import com.ultrapower.project.system.sign.domain.LettersSign;
import com.ultrapower.project.system.sign.service.ILettersSignService;

/**
 * 责任书和保密协议签署情况Service业务层处理
 *
 * @author 王聪
 * @date 2020-05-29
 */
@Service
public class LettersSignServiceImpl implements ILettersSignService
{
    @Autowired
    private LettersSignMapper lettersSignMapper;

    /**
     * 查询责任书和保密协议签署情况
     *
     * @param uuid 责任书和保密协议签署情况ID
     * @return 责任书和保密协议签署情况
     */
    @Override
    public LettersSign selectLettersSignById(String uuid)
    {
        return lettersSignMapper.selectLettersSignById(uuid);
    }

    /**
     * 查询责任书和保密协议签署情况列表
     *
     * @param lettersSign 责任书和保密协议签署情况
     * @return 责任书和保密协议签署情况
     */
    @Override
    public List<LettersSign> selectLettersSignList(LettersSign lettersSign)
    {
        return lettersSignMapper.selectLettersSignList(lettersSign);
    }

    /**
     * 新增责任书和保密协议签署情况
     *
     * @param lettersSign 责任书和保密协议签署情况
     * @return 结果
     */
    @Override
    public int insertLettersSign(LettersSign lettersSign)
    {
        return lettersSignMapper.insertLettersSign(lettersSign);
    }

    /**
     * 修改责任书和保密协议签署情况
     *
     * @param lettersSign 责任书和保密协议签署情况
     * @return 结果
     */
    @Override
    public int updateLettersSign(LettersSign lettersSign)
    {
        return lettersSignMapper.updateLettersSign(lettersSign);
    }

    /**
     * 删除责任书和保密协议签署情况对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteLettersSignByIds(String ids)
    {
        return lettersSignMapper.deleteLettersSignByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除责任书和保密协议签署情况信息
     *
     * @param uuid 责任书和保密协议签署情况ID
     * @return 结果
     */
    @Override
    public int deleteLettersSignById(String uuid)
    {
        return lettersSignMapper.deleteLettersSignById(uuid);
    }
}
