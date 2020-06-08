package com.ultrapower.project.system.sensitivebank.domain;

import com.ultrapower.framework.aspectj.lang.annotation.Excel;
import com.ultrapower.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import java.util.Date;

/**
 * 涉敏人员库对象 sensitive_user_subacc
 *
 * @author wangcong
 * @date 2020-06-07
 */
public class SensitiveBank extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private String uuid;

    /** 省份编码 */
    @Excel(name = "省份编码")
    private String provincecode;

    /** 涉敏人员 */
    @Excel(name = "涉敏人员")
    private String username;

    /** 所属系统 */
    @Excel(name = "所属系统")
    private String groupname;

    /** 子系统 */
    @Excel(name = "子系统")
    private String subgroupname;

    /** 所属系统类型 */
    @Excel(name = "所属系统类型")
    private String groupnametype;

    /** 组织路径名称 */
    @Excel(name = "组织路径名称")
    private String orgpathname;

    /** 岗位角色 */
    @Excel(name = "岗位角色")
    private String jobrole;

    /** 主账号 */
    @Excel(name = "涉敏人员主账号")
    private String userid;

    /** 从账号 */
    @Excel(name = "涉敏人员从账号")
    private String accountid;

    /** 从账号类型 */
    @Excel(name = "从账号类型")
    private String authztype;

    /** 涉敏权限内容 */
    @Excel(name = "涉敏权限内容")
    private String sensitiveauthzcontent;

    /** 操作权限 */
    @Excel(name = "操作权限")
    private String operauthz;

    /** 生效时间 */
    @Excel(name = "生效时间", width = 30, dateFormat = "yyyyMMddHHmmss")
    private Date accstarttime;

    /** 失效时间 */
    @Excel(name = "失效时间", width = 30, dateFormat = "yyyyMMddHHmmss")
    private Date accendtime;

    /** 备注 */
    @Excel(name = "备注")
    private String sensitiveBankRemark;

    /** 状态 */
    private String status;

    /** 是否逻辑删除 0正常  1删除 */
    private String logicdelete;

    /** 注册日期 */
    private String registdate;

    /** 未知作用的字段 */
    private String optuser;

    /** 修改时间 */
    private String modifytime;

    /** 修改者编号 */
    private String modifyuserid;

    /** 业务系统ID */
    private String groupuuid;

    public void setUuid(String uuid)
    {
        this.uuid = uuid;
    }

    public String getUuid()
    {
        return uuid;
    }
    public void setProvincecode(String provincecode)
    {
        this.provincecode = provincecode;
    }

    public String getProvincecode()
    {
        return provincecode;
    }
    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getUsername()
    {
        return username;
    }
    public void setGroupname(String groupname)
    {
        this.groupname = groupname;
    }

    public String getGroupname()
    {
        return groupname;
    }
    public void setSubgroupname(String subgroupname)
    {
        this.subgroupname = subgroupname;
    }

    public String getSubgroupname()
    {
        return subgroupname;
    }
    public void setGroupnametype(String groupnametype)
    {
        this.groupnametype = groupnametype;
    }

    public String getGroupnametype()
    {
        return groupnametype;
    }
    public void setOrgpathname(String orgpathname)
    {
        this.orgpathname = orgpathname;
    }

    public String getOrgpathname()
    {
        return orgpathname;
    }
    public void setJobrole(String jobrole)
    {
        this.jobrole = jobrole;
    }

    public String getJobrole()
    {
        return jobrole;
    }
    public void setUserid(String userid)
    {
        this.userid = userid;
    }

    public String getUserid()
    {
        return userid;
    }
    public void setAccountid(String accountid)
    {
        this.accountid = accountid;
    }

    public String getAccountid()
    {
        return accountid;
    }
    public void setAuthztype(String authztype)
    {
        this.authztype = authztype;
    }

    public String getAuthztype()
    {
        return authztype;
    }
    public void setAccstarttime(Date accstarttime)
    {
        this.accstarttime = accstarttime;
    }

    public Date getAccstarttime()
    {
        return accstarttime;
    }
    public void setAccendtime(Date accendtime)
    {
        this.accendtime = accendtime;
    }

    public Date getAccendtime()
    {
        return accendtime;
    }

    public void setSensitiveBankRemark(String sensitiveBankRemark) {
        this.sensitiveBankRemark = sensitiveBankRemark;
    }

    public String getSensitiveBankRemark() {
        return sensitiveBankRemark;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }
    public void setLogicdelete(String logicdelete)
    {
        this.logicdelete = logicdelete;
    }

    public String getLogicdelete()
    {
        return logicdelete;
    }
    public void setRegistdate(String registdate)
    {
        this.registdate = registdate;
    }

    public String getRegistdate()
    {
        return registdate;
    }
    public void setOptuser(String optuser)
    {
        this.optuser = optuser;
    }

    public String getOptuser()
    {
        return optuser;
    }
    public void setModifytime(String modifytime)
    {
        this.modifytime = modifytime;
    }

    public String getModifytime()
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
    public void setGroupuuid(String groupuuid)
    {
        this.groupuuid = groupuuid;
    }

    public String getGroupuuid()
    {
        return groupuuid;
    }
    public void setOperauthz(String operauthz)
    {
        this.operauthz = operauthz;
    }

    public String getOperauthz()
    {
        return operauthz;
    }
    public void setSensitiveauthzcontent(String sensitiveauthzcontent)
    {
        this.sensitiveauthzcontent = sensitiveauthzcontent;
    }

    public String getSensitiveauthzcontent()
    {
        return sensitiveauthzcontent;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("uuid", getUuid())
            .append("provincecode", getProvincecode())
            .append("username", getUsername())
            .append("groupname", getGroupname())
            .append("subgroupname", getSubgroupname())
            .append("groupnametype", getGroupnametype())
            .append("orgpathname", getOrgpathname())
            .append("jobrole", getJobrole())
            .append("userid", getUserid())
            .append("accountid", getAccountid())
            .append("authztype", getAuthztype())
            .append("accstarttime", getAccstarttime())
            .append("accendtime", getAccendtime())
            .append("sensitiveBankRemark", getSensitiveBankRemark())
            .append("status", getStatus())
            .append("logicdelete", getLogicdelete())
            .append("registdate", getRegistdate())
            .append("optuser", getOptuser())
            .append("modifytime", getModifytime())
            .append("modifyuserid", getModifyuserid())
            .append("groupuuid", getGroupuuid())
            .append("operauthz", getOperauthz())
            .append("sensitiveauthzcontent", getSensitiveauthzcontent())
            .toString();
    }
}
