package com.ultrapower.project.system.auditoutgoingdata.domain;

import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ultrapower.framework.aspectj.lang.annotation.Excel;
import com.ultrapower.framework.web.domain.BaseEntity;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;

/**
 * 外送数据接口审计对象 e_audit_outgoing_data
 *
 * @author ruoyi
 * @date 2020-06-03
 */
public class AuditOutgoingData extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private String uuid;

    /** 审计人员 */
    @Excel(name = "审计人员")
    private String auditor;

    /** 审计人员id */
    private String auditorId;

    /** 系统名称 */
    @Excel(name = "系统名称")
    private String systemName;

    /** 时间 */
    @Excel(name = "时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date time;

    /** 审计内容 */
    @Excel(name = "审计内容")
    private String auditContent;

    /** 审计类别 */
    @Excel(name = "内容分类")
    private String contentCategory;

    /** 审计要点 */
    @Excel(name = "审计要点")
    private String auditPoint;

    /** 系统概况 */
    @Excel(name = "系统概况")
    private String systemOverview;

    /** 网络结构 */
    @Excel(name = "网络结构")
    private String netStruts;

    /** 系统间传输安全 */
    @Excel(name = "系统间传输安全")
    private String systemTransportSafe;

    /** 数据存储安全 */
    @Excel(name = "数据信息存储安全")
    private String dataStorageSafe;

    /** 数据访问安全 */
    @Excel(name = "数据信息访问安全")
    private String dataAccessSafe;

    /** 审计总结 */
    @Excel(name = "审计结论")
    private String auditSummary;

    /** 创建用户id */
    private String createUserid;

    /** 修改时间 */
    private Date modifyTime;

    /** 修改用户 */
    private String modifyUserid;

    /** 是否逻辑删除 0：正常 1：删除 */
    private String logicdelete;

    /** 所属资源组 */
    private String groupuuid;

    public void setUuid(String uuid)
    {
        this.uuid = uuid;
    }

    public String getUuid()
    {
        return uuid;
    }
    public void setAuditor(String auditor)
    {
        this.auditor = auditor;
    }

    public String getAuditor()
    {
        return auditor;
    }
    public void setAuditorId(String auditorId)
    {
        this.auditorId = auditorId;
    }

    public String getAuditorId()
    {
        return auditorId;
    }
    public void setSystemName(String systemName)
    {
        this.systemName = systemName;
    }

    public String getSystemName()
    {
        return systemName;
    }
    public void setTime(Date time)
    {
        this.time = time;
    }

    public Date getTime()
    {
        return time;
    }
    public void setAuditContent(String auditContent)
    {
        this.auditContent = auditContent;
    }

    public String getAuditContent()
    {
        return auditContent;
    }
    public void setContentCategory(String contentCategory)
    {
        this.contentCategory = contentCategory;
    }

    public String getContentCategory()
    {
        return contentCategory;
    }
    public void setAuditPoint(String auditPoint)
    {
        this.auditPoint = auditPoint;
    }

    public String getAuditPoint()
    {
        return auditPoint;
    }
    public void setSystemOverview(String systemOverview)
    {
        this.systemOverview = systemOverview;
    }

    public String getSystemOverview()
    {
        return systemOverview;
    }
    public void setNetStruts(String netStruts)
    {
        this.netStruts = netStruts;
    }

    public String getNetStruts()
    {
        return netStruts;
    }
    public void setSystemTransportSafe(String systemTransportSafe)
    {
        this.systemTransportSafe = systemTransportSafe;
    }

    public String getSystemTransportSafe()
    {
        return systemTransportSafe;
    }
    public void setDataStorageSafe(String dataStorageSafe)
    {
        this.dataStorageSafe = dataStorageSafe;
    }

    public String getDataStorageSafe()
    {
        return dataStorageSafe;
    }
    public void setDataAccessSafe(String dataAccessSafe)
    {
        this.dataAccessSafe = dataAccessSafe;
    }

    public String getDataAccessSafe()
    {
        return dataAccessSafe;
    }
    public void setAuditSummary(String auditSummary)
    {
        this.auditSummary = auditSummary;
    }

    public String getAuditSummary()
    {
        return auditSummary;
    }
    public void setCreateUserid(String createUserid)
    {
        this.createUserid = createUserid;
    }

    public String getCreateUserid()
    {
        return createUserid;
    }
    public void setModifyTime(Date modifyTime)
    {
        this.modifyTime = modifyTime;
    }

    public Date getModifyTime()
    {
        return modifyTime;
    }
    public void setModifyUserid(String modifyUserid)
    {
        this.modifyUserid = modifyUserid;
    }

    public String getModifyUserid()
    {
        return modifyUserid;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("uuid", getUuid())
            .append("auditor", getAuditor())
            .append("auditorId", getAuditorId())
            .append("systemName", getSystemName())
            .append("time", getTime())
            .append("auditContent", getAuditContent())
            .append("contentCategory", getContentCategory())
            .append("auditPoint", getAuditPoint())
            .append("systemOverview", getSystemOverview())
            .append("netStruts", getNetStruts())
            .append("systemTransportSafe", getSystemTransportSafe())
            .append("dataStorageSafe", getDataStorageSafe())
            .append("dataAccessSafe", getDataAccessSafe())
            .append("auditSummary", getAuditSummary())
            .append("createTime", getCreateTime())
            .append("createUserid", getCreateUserid())
            .append("modifyTime", getModifyTime())
            .append("modifyUserid", getModifyUserid())
            .append("logicdelete", getLogicdelete())
            .append("groupuuid", getGroupuuid())
            .toString();
    }
}
