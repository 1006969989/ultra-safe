package com.ultrapower.project.system.type.domain;

import com.ultrapower.framework.aspectj.lang.annotation.Excel;
import com.ultrapower.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


/**
 * 涉敏数据类型对象 e_sensitive_type
 *
 * @author ruoyi
 * @date 2020-05-23
 */
public class ESensitiveType extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    @Excel(name = "主键")
    private String uuid;

    /** 类别名称 */
    @Excel(name = "类别名称")
    private String typename;

    public void setUuid(String uuid)
    {
        this.uuid = uuid;
    }

    public String getUuid()
    {
        return uuid;
    }
    public void setTypename(String typename)
    {
        this.typename = typename;
    }

    public String getTypename()
    {
        return typename;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("uuid", getUuid())
                .append("typename", getTypename())
                .toString();
    }
}