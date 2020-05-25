package com.ultrapower.project.system.matrix.domain;


import com.ultrapower.framework.aspectj.lang.annotation.Excel;
import com.ultrapower.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 矩阵明细对象 e_matrix_detail
 *
 * @author ruoyi
 * @date 2020-05-20
 */
public class EMatrixDetail extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    @Excel(name = "主键")
    private String uuid;

    /** 模板节点uuid */
    @Excel(name = "模板节点uuid")
    private String nodeUuid;

    /** 关联主键 */
    @Excel(name = "关联主键")
    private String matrixUuid;

    /** 环节 */
    @Excel(name = "环节")
    private String tache;

    /** 控制点 */
    @Excel(name = "控制点")
    private String controlPoint;

    /** 说明 */
    @Excel(name = "说明")
    private String nodeContent;

    /** 责任单位（二级部门） */
    @Excel(name = "责任单位", readConverterExp = "二=级部门")
    private String department;

    /** 责任人 */
    @Excel(name = "责任人")
    private String liableUser;

    /** 审核人 */
    @Excel(name = "审核人")
    private String calibrateUser;

    /** 审计人 */
    @Excel(name = "审计人")
    private String auditorUser;

    public void setUuid(String uuid)
    {
        this.uuid = uuid;
    }

    public String getUuid()
    {
        return uuid;
    }
    public void setNodeUuid(String nodeUuid)
    {
        this.nodeUuid = nodeUuid;
    }

    public String getNodeUuid()
    {
        return nodeUuid;
    }
    public void setMatrixUuid(String matrixUuid)
    {
        this.matrixUuid = matrixUuid;
    }

    public String getMatrixUuid()
    {
        return matrixUuid;
    }
    public void setTache(String tache)
    {
        this.tache = tache;
    }

    public String getTache()
    {
        return tache;
    }
    public void setControlPoint(String controlPoint)
    {
        this.controlPoint = controlPoint;
    }

    public String getControlPoint()
    {
        return controlPoint;
    }
    public void setNodeContent(String nodeContent)
    {
        this.nodeContent = nodeContent;
    }

    public String getNodeContent()
    {
        return nodeContent;
    }
    public void setDepartment(String department)
    {
        this.department = department;
    }

    public String getDepartment()
    {
        return department;
    }
    public void setLiableUser(String liableUser)
    {
        this.liableUser = liableUser;
    }

    public String getLiableUser()
    {
        return liableUser;
    }
    public void setCalibrateUser(String calibrateUser)
    {
        this.calibrateUser = calibrateUser;
    }

    public String getCalibrateUser()
    {
        return calibrateUser;
    }
    public void setAuditorUser(String auditorUser)
    {
        this.auditorUser = auditorUser;
    }

    public String getAuditorUser()
    {
        return auditorUser;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("uuid", getUuid())
                .append("nodeUuid", getNodeUuid())
                .append("matrixUuid", getMatrixUuid())
                .append("tache", getTache())
                .append("controlPoint", getControlPoint())
                .append("nodeContent", getNodeContent())
                .append("department", getDepartment())
                .append("liableUser", getLiableUser())
                .append("calibrateUser", getCalibrateUser())
                .append("auditorUser", getAuditorUser())
                .toString();
    }
}