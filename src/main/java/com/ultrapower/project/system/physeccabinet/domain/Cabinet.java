package com.ultrapower.project.system.physeccabinet.domain;

import com.ultrapower.framework.aspectj.lang.annotation.Excel;
import com.ultrapower.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 物理安全情况涉及机柜对象 e_rel_system_room_cabinet
 *
 * @author 王聪
 * @date 2020-05-25
 */
public class Cabinet extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    @Excel(name = "主键")
    private String uuid;

    /** 所属系统 */
    @Excel(name = "所属系统")
    private String systemuuid;

    /** 机房 */
    @Excel(name = "机房")
    private String room;

    /** 机柜 */
    @Excel(name = "机柜")
    private String cabinet;

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
    public void setRoom(String room)
    {
        this.room = room;
    }

    public String getRoom()
    {
        return room;
    }
    public void setCabinet(String cabinet)
    {
        this.cabinet = cabinet;
    }

    public String getCabinet()
    {
        return cabinet;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("uuid", getUuid())
            .append("systemuuid", getSystemuuid())
            .append("room", getRoom())
            .append("cabinet", getCabinet())
            .toString();
    }
}
