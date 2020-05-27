package com.ultrapower.project.system.range.domain;

import com.ultrapower.framework.aspectj.lang.annotation.Excel;
import com.ultrapower.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;



/**
 * 涉敏数据范围对象 e_sensitive_range
 *
 * @author ruoyi
 * @date 2020-05-23
 */
public class ESensitiveRange extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    @Excel(name = "主键")
    private String uuid;

    /** 子类编号 */
    @Excel(name = "子类编号")
    private String subclassuuid;

    /** 范围 */
    @Excel(name = "范围")
    private String range;

    /** 类别编号 */
    @Excel(name = "类别编号")
    private String locationuuid;

    /** 对应数据 */
    @Excel(name = "对应数据")
    private String data;

    public void setUuid(String uuid)
    {
        this.uuid = uuid;
    }

    public String getUuid()
    {
        return uuid;
    }
    public void setSubclassuuid(String subclassuuid)
    {
        this.subclassuuid = subclassuuid;
    }

    public String getSubclassuuid()
    {
        return subclassuuid;
    }
    public void setRange(String range)
    {
        this.range = range;
    }

    public String getRange()
    {
        return range;
    }
    public void setLocationuuid(String locationuuid)
    {
        this.locationuuid = locationuuid;
    }

    public String getLocationuuid()
    {
        return locationuuid;
    }
    public void setData(String data)
    {
        this.data = data;
    }

    public String getData()
    {
        return data;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("uuid", getUuid())
                .append("subclassuuid", getSubclassuuid())
                .append("range", getRange())
                .append("locationuuid", getLocationuuid())
                .append("data", getData())
                .toString();
    }
}