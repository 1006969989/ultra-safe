package com.ultrapower.project.system.authapplyaudit.domain;

import com.ultrapower.framework.aspectj.lang.annotation.Excel;
import com.ultrapower.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;


/**
 * 人员权限申请记录稽核表对象 e_datasafe_authapply_audit
 *
 * @author ruoyi
 * @date 2020-05-27
 */
public class AuthApplyAudit extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    @Excel(name = "主键")
    private String uuid;

    /** 人员名单 */
    @Excel(name = "人员名单")
    private String person;

    /** 系统权限 */
    @Excel(name = "系统权限")
    private String systemAuth;

    /** 应用权限 */
    @Excel(name = "应用权限")
    private String appAuth;

    /** 是否具备正式权限申请审批记录 */
    @Excel(name = "是否具备正式权限申请审批记录")
    private String authApplyRec;

    /** 申请审批记录证明截图 */
    @Excel(name = "申请审批记录证明截图")
    private String authApplyImg;

    /** 创建人编号 */
    @Excel(name = "创建人编号")
    private String createUserid;

    /** 修改时间 */
    @Excel(name = "修改时间")
    private Date modifyTime;

    /** 修改用户编号 */
    @Excel(name = "修改用户编号")
    private String modifyUserid;

    /** 是否逻辑删除 0：正常 1：删除 */
    @Excel(name = "是否逻辑删除 0：正常 1：删除")
    private String logicdelete;

    /** 所属用户组 */
    @Excel(name = "所属用户组")
    private String groupuuid;

    public void setUuid(String uuid)
    {
        this.uuid = uuid;
    }

    public String getUuid()
    {
        return uuid;
    }
    public void setPerson(String person)
    {
        this.person = person;
    }

    public String getPerson()
    {
        return person;
    }
    public void setSystemAuth(String systemAuth)
    {
        this.systemAuth = systemAuth;
    }

    public String getSystemAuth()
    {
        return systemAuth;
    }
    public void setAppAuth(String appAuth)
    {
        this.appAuth = appAuth;
    }

    public String getAppAuth()
    {
        return appAuth;
    }
    public void setAuthApplyRec(String authApplyRec)
    {
        this.authApplyRec = authApplyRec;
    }

    public String getAuthApplyRec()
    {
        return authApplyRec;
    }
    public void setAuthApplyImg(String authApplyImg)
    {
        this.authApplyImg = authApplyImg;
    }

    public String getAuthApplyImg()
    {
        return authApplyImg;
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
            .append("person", getPerson())
            .append("systemAuth", getSystemAuth())
            .append("appAuth", getAppAuth())
            .append("authApplyRec", getAuthApplyRec())
            .append("authApplyImg", getAuthApplyImg())
            .append("remark", getRemark())
            .append("createTime", getCreateTime())
            .append("createUserid", getCreateUserid())
            .append("modifyTime", getModifyTime())
            .append("modifyUserid", getModifyUserid())
            .append("logicdelete", getLogicdelete())
            .append("groupuuid", getGroupuuid())
            .toString();
    }
}
