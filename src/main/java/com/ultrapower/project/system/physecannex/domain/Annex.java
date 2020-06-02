package com.ultrapower.project.system.physecannex.domain;

import com.ultrapower.framework.aspectj.lang.annotation.Excel;
import com.ultrapower.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 物理安全情况附件对象 e_rel_system_annex
 *
 * @author 王聪
 * @date 2020-05-27
 */
public class Annex extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    @Excel(name = "主键")
    private String uuid;

    /** 所属系统 */
    @Excel(name = "所属系统")
    private String systemuuid;

    /** 附件名称 */
    @Excel(name = "附件名称")
    private String annex;

    /** 附件路径 */
    @Excel(name = "附件路径")
    private String ftppath;

    public void setUuid(String uuid)
    {
        this.uuid = uuid;
    }

    public String getUuid()
    {
        return uuid;
    }
    public void setSystemuuid(String systemuuid)
    {
        this.systemuuid = systemuuid;
    }

    public String getSystemuuid()
    {
        return systemuuid;
    }
    public void setAnnex(String annex)
    {
        this.annex = annex;
    }

    public String getAnnex()
    {
        return annex;
    }
    public void setFtppath(String ftppath)
    {
        this.ftppath = ftppath;
    }

    public String getFtppath()
    {
        return ftppath;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("uuid", getUuid())
            .append("systemuuid", getSystemuuid())
            .append("annex", getAnnex())
            .append("ftppath", getFtppath())
            .toString();
    }
}
