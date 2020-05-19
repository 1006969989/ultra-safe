package com.ultrapower.project.system.resgroup.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ultrapower.framework.aspectj.lang.annotation.Excel;
import com.ultrapower.framework.web.domain.BaseEntity;

/**
 * 业务系统对象 sys_resgroup
 *
 * @author mint
 * @date 2020-05-18
 */
public class Resgroup extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    @Excel(name = "主键")
    private Long resId;

    /** 父业务系统id */
    @Excel(name = "父业务系统id")
    private Long parentId;

    /** 祖级列表 */
    @Excel(name = "祖级列表")
    private String ancestors;

    /** 业务系统名称 */
    @Excel(name = "业务系统名称")
    private String groupName;

    /** 负责人 */
    @Excel(name = "负责人")
    private String leader;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String phone;

    /** 邮箱 */
    @Excel(name = "邮箱")
    private String email;

    /** 业务系统状态（0正常 1停用） */
    @Excel(name = "业务系统状态", readConverterExp = "0=正常,1=停用")
    private String status;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    /** 定级系统名称 */
    @Excel(name = "定级系统名称")
    private String rankGroupname;

    /** 定级（1,2,3,3.1） */
    @Excel(name = "定级", readConverterExp = "1=,2,3,3.1")
    private String rank;

    /** 是否涉敏（ 0 否 1  是） */
    @Excel(name = "是否涉敏", readConverterExp = "0=,否=,1=,是=")
    private String issensitivity;

    /** 集成厂商 */
    @Excel(name = "集成厂商")
    private String vendor;

    /** 分管部门 */
    @Excel(name = "分管部门")
    private String management;

    /** 主要功能 */
    @Excel(name = "主要功能")
    private String mainfunction;

    /** 系统分布 */
    @Excel(name = "系统分布")
    private String distribution;

    /** 业务系统uuid */
    @Excel(name = "业务系统uuid")
    private String resgroupuuid;

    public void setResId(Long resId)
    {
        this.resId = resId;
    }

    public Long getResId()
    {
        return resId;
    }
    public void setParentId(Long parentId)
    {
        this.parentId = parentId;
    }

    public Long getParentId()
    {
        return parentId;
    }
    public void setAncestors(String ancestors)
    {
        this.ancestors = ancestors;
    }

    public String getAncestors()
    {
        return ancestors;
    }
    public void setGroupName(String groupName)
    {
        this.groupName = groupName;
    }

    public String getGroupName()
    {
        return groupName;
    }
    public void setLeader(String leader)
    {
        this.leader = leader;
    }

    public String getLeader()
    {
        return leader;
    }
    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getPhone()
    {
        return phone;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getEmail()
    {
        return email;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }
    public void setDelFlag(String delFlag)
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag()
    {
        return delFlag;
    }
    public void setRankGroupname(String rankGroupname)
    {
        this.rankGroupname = rankGroupname;
    }

    public String getRankGroupname()
    {
        return rankGroupname;
    }
    public void setRank(String rank)
    {
        this.rank = rank;
    }

    public String getRank()
    {
        return rank;
    }
    public void setIssensitivity(String issensitivity)
    {
        this.issensitivity = issensitivity;
    }

    public String getIssensitivity()
    {
        return issensitivity;
    }
    public void setVendor(String vendor)
    {
        this.vendor = vendor;
    }

    public String getVendor()
    {
        return vendor;
    }
    public void setManagement(String management)
    {
        this.management = management;
    }

    public String getManagement()
    {
        return management;
    }
    public void setMainfunction(String mainfunction)
    {
        this.mainfunction = mainfunction;
    }

    public String getMainfunction()
    {
        return mainfunction;
    }
    public void setDistribution(String distribution)
    {
        this.distribution = distribution;
    }

    public String getDistribution()
    {
        return distribution;
    }
    public void setResgroupuuid(String resgroupuuid)
    {
        this.resgroupuuid = resgroupuuid;
    }

    public String getResgroupuuid()
    {
        return resgroupuuid;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("resId", getResId())
            .append("parentId", getParentId())
            .append("ancestors", getAncestors())
            .append("groupName", getGroupName())
            .append("leader", getLeader())
            .append("phone", getPhone())
            .append("email", getEmail())
            .append("status", getStatus())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("rankGroupname", getRankGroupname())
            .append("rank", getRank())
            .append("issensitivity", getIssensitivity())
            .append("vendor", getVendor())
            .append("management", getManagement())
            .append("mainfunction", getMainfunction())
            .append("distribution", getDistribution())
            .append("resgroupuuid", getResgroupuuid())
            .toString();
    }
}
