package com.ultrapower.project.system.subacc.domain;


import com.ultrapower.framework.aspectj.lang.annotation.Excel;
import com.ultrapower.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 涉敏资产库对象 sensitive_res_subacc
 *
 * @author ruoyi
 * @date 2020-06-04
 */
public class SensitiveResSubacc extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键编号 */
    @Excel(name = "主键编号")
    private String uuid;

    /** 资产名称 */
    @Excel(name = "资产名称")
    private String resname;

    /** 资产IP */
    @Excel(name = "资产IP")
    private String resip;

    /** 所属系统 */
    @Excel(name = "所属系统")
    private String belongsystem;

    /** 所属子系统 */
    @Excel(name = "所属子系统")
    private String subsystem;

    /** 是否加金库策略 */
    @Excel(name = "是否加金库策略")
    private String isjksys;

    /** 涉敏对象类型 */
    @Excel(name = "涉敏对象类型")
    private String senobjtype;

    /** 涉敏对象 */
    @Excel(name = "涉敏对象")
    private String senobject;

    /** 创建人主账号id */
    @Excel(name = "创建人主账号id")
    private String createuserid;

    /** 创建时间 */
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createtime;

    /** 变更时间 */
    private Date modifytime;

    /** 变更人主账号id */
    @Excel(name = "变更人主账号id")
    private String modifyuserid;

    /** 状态 0：正常 1：历史涉敏 */
    @Excel(name = "状态 0：正常 1：历史涉敏")
    private String status;

    /** 删除涉敏原因: 0：数据变更为非涉敏  1：非涉敏,录入失误 */
    @Excel(name = "删除涉敏原因: 0：数据变更为非涉敏  1：非涉敏,录入失误")
    private String delreason;

    /**  */
    private String groupuuid;

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public void setUuid(String uuid)
    {
        this.uuid = uuid;
    }

    public String getUuid()
    {
        return uuid;
    }
    public void setResname(String resname)
    {
        this.resname = resname;
    }

    public String getResname()
    {
        return resname;
    }
    public void setResip(String resip)
    {
        this.resip = resip;
    }

    public String getResip()
    {
        return resip;
    }
    public void setBelongsystem(String belongsystem)
    {
        this.belongsystem = belongsystem;
    }

    public String getBelongsystem()
    {
        return belongsystem;
    }
    public void setSubsystem(String subsystem)
    {
        this.subsystem = subsystem;
    }

    public String getSubsystem()
    {
        return subsystem;
    }
    public void setIsjksys(String isjksys)
    {
        this.isjksys = isjksys;
    }

    public String getIsjksys()
    {
        return isjksys;
    }
    public void setSenobjtype(String senobjtype)
    {
        this.senobjtype = senobjtype;
    }

    public String getSenobjtype()
    {
        return senobjtype;
    }
    public void setSenobject(String senobject)
    {
        this.senobject = senobject;
    }

    public String getSenobject()
    {
        return senobject;
    }
    public void setCreateuserid(String createuserid)
    {
        this.createuserid = createuserid;
    }

    public String getCreateuserid()
    {
        return createuserid;
    }
    public void setModifytime(Date modifytime)
    {
        this.modifytime = modifytime;
    }

    public Date getModifytime()
    {
        return modifytime;
    }
    public void setModifyuserid(String modifyuserid)
    {
        this.modifyuserid = modifyuserid;
    }

    public String getModifyuserid()
    {
        return modifyuserid;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }
    public void setDelreason(String delreason)
    {
        this.delreason = delreason;
    }

    public String getDelreason()
    {
        return delreason;
    }
    public void setGroupuuid(String groupuuid)
    {
        this.groupuuid = groupuuid;
    }

    public String getGroupuuid()
    {
        return groupuuid;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("uuid", getUuid())
                .append("resname", getResname())
                .append("resip", getResip())
                .append("belongsystem", getBelongsystem())
                .append("subsystem", getSubsystem())
                .append("isjksys", getIsjksys())
                .append("senobjtype", getSenobjtype())
                .append("senobject", getSenobject())
                .append("createtime", getCreatetime())
                .append("createuserid", getCreateuserid())
                .append("modifytime", getModifytime())
                .append("modifyuserid", getModifyuserid())
                .append("status", getStatus())
                .append("delreason", getDelreason())
                .append("groupuuid", getGroupuuid())
                .toString();
    }
}
