package com.ultrapower.project.system.sharedatainfo.domain;

import com.ultrapower.framework.aspectj.lang.annotation.Excel;
import com.ultrapower.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 系统共享数据信息对象 e_systemsharedata_info
 *
 * @author ruoyi
 * @date 2020-06-01
 */
public class ESystemsharedataInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键编号 */
    @Excel(name = "主键编号")
    private String uuid;

    /** 系统名称 */
    @Excel(name = "系统名称")
    private String systemname;

    /** 系统所在机房位置 */
    @Excel(name = "系统所在机房位置")
    private String systemlocroom;

    /** 系统所在机柜位置 */
    @Excel(name = "系统所在机柜位置")
    private String frameworklocation;

    /** 共享数据编号 */
    @Excel(name = "共享数据编号")
    private String sharecode;

    /** 系统IP地址 */
    @Excel(name = "系统IP地址")
    private String desip;

    /** 共享方式 */
    @Excel(name = "共享方式")
    private String shareway;

    /** 创建时间 */
    @Excel(name = "创建时间")
    private Date createtime;

    /** 修改时间 */
    @Excel(name = "修改时间")
    private Date modifytime;

    /** 所属资源组 */
    @Excel(name = "所属资源组")
    private String groupuuid;

    /** 是否删除  0 正常  1 已删除 */
    @Excel(name = "是否删除  0 正常  1 已删除")
    private String logicdelete;

    /** 部署系统所属部门 */
    @Excel(name = "部署系统所属部门")
    private String sourcedepartment;

    /** 敏感数据内容 */
    @Excel(name = "敏感数据内容")
    private String sensitivedata;

    /** 源系统维护人 */
    @Excel(name = "源系统维护人")
    private String sourcedefendperson;

    /** 源系统维护人电话 */
    @Excel(name = "源系统维护人电话")
    private String sourcepersonmobile;

    /** 目的系统责任人 */
    @Excel(name = "目的系统责任人")
    private String desdefendperson;

    /** 目的系统责任人电话 */
    @Excel(name = "目的系统责任人电话")
    private String desdefendpersonmobile;

    /** 目的责任室经理 */
    @Excel(name = "目的责任室经理")
    private String desresponsroommanager;

    /** 目的责任室经理电话 */
    @Excel(name = "目的责任室经理电话")
    private String desresponsroommanagermobile;

    /** 目的责任领导人 */
    @Excel(name = "目的责任领导人")
    private String desresponsroomleader;

    /** 目的责任领导人电话 */
    @Excel(name = "目的责任领导人电话")
    private String desresponsroomleadermobile;

    /** 共享数据目的系统名称 */
    @Excel(name = "共享数据目的系统名称")
    private String dessystemname;

    /** 目的系统所属部门 */
    @Excel(name = "目的系统所属部门")
    private String desdepartment;

    /** 共享数据目的系统IP地址 */
    @Excel(name = "共享数据目的系统IP地址")
    private String systemip;

    /** 共享数据主要内容 */
    @Excel(name = "共享数据主要内容")
    private String sharedata;

    /** 共享协议端口 */
    @Excel(name = "共享协议端口")
    private String shareport;

    /** 是否包含敏感数据  0  否  1  是 */
    @Excel(name = "是否包含敏感数据  0  否  1  是")
    private String iscontainsensitivedata;

    /** 数据级别 */
    @Excel(name = "数据级别")
    private String datalevel;

    /** 共享数据使用用途 */
    @Excel(name = "共享数据使用用途")
    private String sharedatause;

    /** 向集团报备 */
    @Excel(name = "向集团报备")
    private String upload;

    /** 共享数据传输方式 */
    @Excel(name = "共享数据传输方式")
    private String sharedatatransferway;

    /** 共享数据类型 */
    @Excel(name = "共享数据类型")
    private String sharedatatype;

    /** 共享数据采集点 */
    @Excel(name = "共享数据采集点")
    private String sharedatacollectpoint;

    /** 共享数据依据 */
    @Excel(name = "共享数据依据")
    private String sharedataaccordance;

    /** 共享数据范围 */
    @Excel(name = "共享数据范围")
    private String sharedatascope;

    /** 共享数据粒度 */
    @Excel(name = "共享数据粒度")
    private String sharedatagranularity;

    /** 共享数据量级 */
    @Excel(name = "共享数据量级")
    private String sharedataorder;

    /** 共享数据时限范围 */
    @Excel(name = "共享数据时限范围")
    private String hourlimit;

    /** 是否具备告警发现手段 */
    @Excel(name = "是否具备告警发现手段")
    private String ishasalarm;

    /** 是否原始数据 */
    @Excel(name = "是否原始数据")
    private String issourcedata;

    /** 创建用户编号 */
    @Excel(name = "创建用户编号")
    private String createuserid;

    /** 修改用户编号 */
    @Excel(name = "修改用户编号")
    private String modifyuserid;

    /** 省份，此处应该是编码 */
    @Excel(name = "省份，此处应该是编码")
    private String province;

    /** 备注 */
    @Excel(name = "备注")
    private String description;

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
    public void setSystemlocroom(String systemlocroom)
    {
        this.systemlocroom = systemlocroom;
    }

    public String getSystemlocroom()
    {
        return systemlocroom;
    }
    public void setFrameworklocation(String frameworklocation)
    {
        this.frameworklocation = frameworklocation;
    }


    public String getFrameworklocation()
    {
        return frameworklocation;
    }
    public void setSharecode(String sharecode)
    {
        this.sharecode = sharecode;
    }

    public String getSharecode()
    {
        return sharecode;
    }
    public void setDesip(String desip)
    {
        this.desip = desip;
    }

    public String getDesip()
    {
        return desip;
    }
    public void setShareway(String shareway)
    {
        this.shareway = shareway;
    }

    public String getShareway()
    {
        return shareway;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getModifytime() {
        return modifytime;
    }

    public void setModifytime(Date modifytime) {
        this.modifytime = modifytime;
    }

    public void setGroupuuid(String groupuuid)
    {
        this.groupuuid = groupuuid;
    }

    public String getGroupuuid()
    {
        return groupuuid;
    }
    public void setLogicdelete(String logicdelete)
    {
        this.logicdelete = logicdelete;
    }

    public String getLogicdelete()
    {
        return logicdelete;
    }
    public void setSourcedepartment(String sourcedepartment)
    {
        this.sourcedepartment = sourcedepartment;
    }

    public String getSourcedepartment()
    {
        return sourcedepartment;
    }
    public void setSensitivedata(String sensitivedata)
    {
        this.sensitivedata = sensitivedata;
    }

    public String getSensitivedata()
    {
        return sensitivedata;
    }
    public void setSourcedefendperson(String sourcedefendperson)
    {
        this.sourcedefendperson = sourcedefendperson;
    }

    public String getSourcedefendperson()
    {
        return sourcedefendperson;
    }
    public void setSourcepersonmobile(String sourcepersonmobile)
    {
        this.sourcepersonmobile = sourcepersonmobile;
    }

    public String getSourcepersonmobile()
    {
        return sourcepersonmobile;
    }
    public void setDesdefendperson(String desdefendperson)
    {
        this.desdefendperson = desdefendperson;
    }

    public String getDesdefendperson()
    {
        return desdefendperson;
    }
    public void setDesdefendpersonmobile(String desdefendpersonmobile)
    {
        this.desdefendpersonmobile = desdefendpersonmobile;
    }

    public String getDesdefendpersonmobile()
    {
        return desdefendpersonmobile;
    }
    public void setDesresponsroommanager(String desresponsroommanager)
    {
        this.desresponsroommanager = desresponsroommanager;
    }

    public String getDesresponsroommanager()
    {
        return desresponsroommanager;
    }
    public void setDesresponsroommanagermobile(String desresponsroommanagermobile)
    {
        this.desresponsroommanagermobile = desresponsroommanagermobile;
    }

    public String getDesresponsroommanagermobile()
    {
        return desresponsroommanagermobile;
    }
    public void setDesresponsroomleader(String desresponsroomleader)
    {
        this.desresponsroomleader = desresponsroomleader;
    }

    public String getDesresponsroomleader()
    {
        return desresponsroomleader;
    }
    public void setDesresponsroomleadermobile(String desresponsroomleadermobile)
    {
        this.desresponsroomleadermobile = desresponsroomleadermobile;
    }

    public String getDesresponsroomleadermobile()
    {
        return desresponsroomleadermobile;
    }
    public void setDessystemname(String dessystemname)
    {
        this.dessystemname = dessystemname;
    }

    public String getDessystemname()
    {
        return dessystemname;
    }
    public void setDesdepartment(String desdepartment)
    {
        this.desdepartment = desdepartment;
    }

    public String getDesdepartment()
    {
        return desdepartment;
    }
    public void setSystemip(String systemip)
    {
        this.systemip = systemip;
    }

    public String getSystemip()
    {
        return systemip;
    }
    public void setSharedata(String sharedata)
    {
        this.sharedata = sharedata;
    }

    public String getSharedata()
    {
        return sharedata;
    }
    public void setShareport(String shareport)
    {
        this.shareport = shareport;
    }

    public String getShareport()
    {
        return shareport;
    }
    public void setIscontainsensitivedata(String iscontainsensitivedata)
    {
        this.iscontainsensitivedata = iscontainsensitivedata;
    }

    public String getIscontainsensitivedata()
    {
        return iscontainsensitivedata;
    }
    public void setDatalevel(String datalevel)
    {
        this.datalevel = datalevel;
    }

    public String getDatalevel()
    {
        return datalevel;
    }
    public void setSharedatause(String sharedatause)
    {
        this.sharedatause = sharedatause;
    }

    public String getSharedatause()
    {
        return sharedatause;
    }
    public void setUpload(String upload)
    {
        this.upload = upload;
    }

    public String getUpload()
    {
        return upload;
    }
    public void setSharedatatransferway(String sharedatatransferway)
    {
        this.sharedatatransferway = sharedatatransferway;
    }

    public String getSharedatatransferway()
    {
        return sharedatatransferway;
    }
    public void setSharedatatype(String sharedatatype)
    {
        this.sharedatatype = sharedatatype;
    }

    public String getSharedatatype()
    {
        return sharedatatype;
    }
    public void setSharedatacollectpoint(String sharedatacollectpoint)
    {
        this.sharedatacollectpoint = sharedatacollectpoint;
    }

    public String getSharedatacollectpoint()
    {
        return sharedatacollectpoint;
    }
    public void setSharedataaccordance(String sharedataaccordance)
    {
        this.sharedataaccordance = sharedataaccordance;
    }

    public String getSharedataaccordance()
    {
        return sharedataaccordance;
    }
    public void setSharedatascope(String sharedatascope)
    {
        this.sharedatascope = sharedatascope;
    }

    public String getSharedatascope()
    {
        return sharedatascope;
    }
    public void setSharedatagranularity(String sharedatagranularity)
    {
        this.sharedatagranularity = sharedatagranularity;
    }

    public String getSharedatagranularity()
    {
        return sharedatagranularity;
    }
    public void setSharedataorder(String sharedataorder)
    {
        this.sharedataorder = sharedataorder;
    }

    public String getSharedataorder()
    {
        return sharedataorder;
    }
    public void setHourlimit(String hourlimit)
    {
        this.hourlimit = hourlimit;
    }

    public String getHourlimit()
    {
        return hourlimit;
    }
    public void setIshasalarm(String ishasalarm)
    {
        this.ishasalarm = ishasalarm;
    }

    public String getIshasalarm()
    {
        return ishasalarm;
    }
    public void setIssourcedata(String issourcedata)
    {
        this.issourcedata = issourcedata;
    }

    public String getIssourcedata()
    {
        return issourcedata;
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
    public void setProvince(String province)
    {
        this.province = province;
    }

    public String getProvince()
    {
        return province;
    }
    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getDescription()
    {
        return description;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("uuid", getUuid())
                .append("systemname", getSystemname())
                .append("systemlocroom", getSystemlocroom())
                .append("frameworklocation", getFrameworklocation())
                .append("sharecode", getSharecode())
                .append("desip", getDesip())
                .append("shareway", getShareway())
                .append("createtime", getCreatetime())
                .append("modifytime", getModifytime())
                .append("groupuuid", getGroupuuid())
                .append("logicdelete", getLogicdelete())
                .append("sourcedepartment", getSourcedepartment())
                .append("sensitivedata", getSensitivedata())
                .append("sourcedefendperson", getSourcedefendperson())
                .append("sourcepersonmobile", getSourcepersonmobile())
                .append("desdefendperson", getDesdefendperson())
                .append("desdefendpersonmobile", getDesdefendpersonmobile())
                .append("desresponsroommanager", getDesresponsroommanager())
                .append("desresponsroommanagermobile", getDesresponsroommanagermobile())
                .append("desresponsroomleader", getDesresponsroomleader())
                .append("desresponsroomleadermobile", getDesresponsroomleadermobile())
                .append("dessystemname", getDessystemname())
                .append("desdepartment", getDesdepartment())
                .append("systemip", getSystemip())
                .append("sharedata", getSharedata())
                .append("shareport", getShareport())
                .append("iscontainsensitivedata", getIscontainsensitivedata())
                .append("datalevel", getDatalevel())
                .append("sharedatause", getSharedatause())
                .append("upload", getUpload())
                .append("sharedatatransferway", getSharedatatransferway())
                .append("sharedatatype", getSharedatatype())
                .append("sharedatacollectpoint", getSharedatacollectpoint())
                .append("sharedataaccordance", getSharedataaccordance())
                .append("sharedatascope", getSharedatascope())
                .append("sharedatagranularity", getSharedatagranularity())
                .append("sharedataorder", getSharedataorder())
                .append("hourlimit", getHourlimit())
                .append("ishasalarm", getIshasalarm())
                .append("issourcedata", getIssourcedata())
                .append("createuserid", getCreateuserid())
                .append("modifyuserid", getModifyuserid())
                .append("province", getProvince())
                .append("description", getDescription())
                .toString();
    }
}