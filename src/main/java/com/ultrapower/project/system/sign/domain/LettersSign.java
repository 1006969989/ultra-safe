package com.ultrapower.project.system.sign.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ultrapower.framework.aspectj.lang.annotation.Excel;
import com.ultrapower.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;


/**
 * 责任书和保密协议签署情况对象 e_datasafe_letters_sign
 *
 * @author 王聪
 * @date 2020-06-01
 */
public class LettersSign extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private String uuid;

    /** 人员 */
    @Excel(name = "人员")
    private String personName;

    /** 归属公司 */
    @Excel(name = "归属公司")
    private String company;

    /** 归属部门 */
    @Excel(name = "归属部门")
    private String department;

    /** 保密协议 */
    private String secretLetter;

    /** 安全责任书 */
    private String respLetter;

    /** 创建用户编号 */
    private String createUserid;

    /** 修改时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modifyTime;

    /** 修改用户编号 */
    private String modifyUserid;

    /** 是否逻辑删除 0：正常 1：删除 */
    private String logicdelete;

    /** 所属用户组 */
    @Excel(name = "所属用户组/业务系统")
    private String groupuuid;

    public void setUuid(String uuid)
    {
        this.uuid = uuid;
    }

    public String getUuid()
    {
        return uuid;
    }
    public void setPersonName(String personName)
    {
        this.personName = personName;
    }

    public String getPersonName()
    {
        return personName;
    }
    public void setCompany(String company)
    {
        this.company = company;
    }

    public String getCompany()
    {
        return company;
    }
    public void setDepartment(String department)
    {
        this.department = department;
    }

    public String getDepartment()
    {
        return department;
    }
    public void setSecretLetter(String secretLetter)
    {
        this.secretLetter = secretLetter;
    }

    public String getSecretLetter()
    {
        return secretLetter;
    }
    public void setRespLetter(String respLetter)
    {
        this.respLetter = respLetter;
    }

    public String getRespLetter()
    {
        return respLetter;
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
            .append("personName", getPersonName())
            .append("company", getCompany())
            .append("department", getDepartment())
            .append("secretLetter", getSecretLetter())
            .append("respLetter", getRespLetter())
            .append("createTime", getCreateTime())
            .append("createUserid", getCreateUserid())
            .append("modifyTime", getModifyTime())
            .append("modifyUserid", getModifyUserid())
            .append("logicdelete", getLogicdelete())
            .append("groupuuid", getGroupuuid())
            .toString();
    }
}
