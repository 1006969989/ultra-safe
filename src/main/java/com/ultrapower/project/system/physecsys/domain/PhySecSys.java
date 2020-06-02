package com.ultrapower.project.system.physecsys.domain;

import com.ultrapower.framework.aspectj.lang.annotation.Excel;
import com.ultrapower.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 物理安全情况对象 physical_security_system
 *
 * @author ruoyi
 * @date 2020-05-25
 */
public class PhySecSys extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private String uuid;

    /** 系统名称 */
    @Excel(name = "系统名称")
    private String systemname;

    /** 机柜数量 */
    @Excel(name = "涉及机柜数量")
    private String cabinetnum;

    /** 采取物理安全的具体措施 */
    @Excel(name = "采取物理安全的具体措施（如加锁，围栏）")
    private String specificmeasure;

    /** 未采取物理安全措施的原因 */
    @Excel(name = "未采取物理安全措施的原因")
    private String reason;

    /** 是否逻辑删除  0  正常  1  删除 */
    private String logicdelete;

    /** 所属系统UUID */
    @Excel(name = "所属系统UUID")
    private String groupuuid;

    /** 创建时间 */
    @Excel(name = "创建时间")
    private String createtime;
    /** 修改时间 */
    private String modifytime;

    /** 创建用户编号 */
    private String createuserid;

    /** 修改用户编号 */
    private String modifyuserid;

    public void setUuid(String uuid)
    {
        this.uuid = uuid;
    }

    public String getUuid()
    {
        return uuid;
    }
    public void setSystemname(String systemname)
    {
        this.systemname = systemname;
    }

    public String getSystemname()
    {
        return systemname;
    }
    public void setCabinetnum(String cabinetnum)
    {
        this.cabinetnum = cabinetnum;
    }

    public String getCabinetnum()
    {
        return cabinetnum;
    }
    public void setSpecificmeasure(String specificmeasure)
    {
        this.specificmeasure = specificmeasure;
    }

    public String getSpecificmeasure()
    {
        return specificmeasure;
    }
    public void setReason(String reason)
    {
        this.reason = reason;
    }

    public String getReason()
    {
        return reason;
    }
    public void setLogicdelete(String logicdelete)
    {
        this.logicdelete = logicdelete;
    }

    public String getLogicdelete()
    {
        return logicdelete;
    }
    public void setGroupuuid(String groupuuid)
    {
        this.groupuuid = groupuuid;
    }

    public String getGroupuuid()
    {
        return groupuuid;
    }
    public void setCreatetime(String createtime)
    {
        this.createtime = createtime;
    }

    public String getCreatetime()
    {
        return createtime;
    }
    public void setModifytime(String modifytime)
    {
        this.modifytime = modifytime;
    }

    public String getModifytime()
    {
        return modifytime;
    }
    public void setCreateuserid(String createuserid)
    {
        this.createuserid = createuserid;
    }

    public String getCreateuserid()
    {
        return createuserid;
    }
    public void setModifyuserid(String modifyuserid)
    {
        this.modifyuserid = modifyuserid;
    }

    public String getModifyuserid()
    {
        return modifyuserid;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("uuid", getUuid())
            .append("systemname", getSystemname())
            .append("cabinetnum", getCabinetnum())
            .append("specificmeasure", getSpecificmeasure())
            .append("reason", getReason())
            .append("logicdelete", getLogicdelete())
            .append("groupuuid", getGroupuuid())
            .append("createtime", getCreatetime())
            .append("modifytime", getModifytime())
            .append("createuserid", getCreateuserid())
            .append("modifyuserid", getModifyuserid())
            .toString();
    }
}
