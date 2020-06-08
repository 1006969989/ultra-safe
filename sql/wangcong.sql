--改表
ALTER TABLE "DATACHECK"."SENSITIVE_USER_SUBACC"
MODIFY ("REGISTDATE" VARCHAR2(50 BYTE) )
MODIFY ("MODIFYTIME" VARCHAR2(50 BYTE) )
MODIFY ("ACCSTARTTIME" TIMESTAMP )
MODIFY ("ACCENDTIME" TIMESTAMP )
MODIFY ("LOGICDELETE" NULL )
MODIFY ("REGISTDATE" NULL )
MODIFY ("OPTUSER" NULL )
ADD ("OPERAUTHZ" VARCHAR2(50) )
ADD ("SENSITIVEAUTHZCONTENT" VARCHAR2(50) );

ALTER TABLE "DATACHECK"."SENSITIVE_USER_SUBACC" DROP CONSTRAINT "SYS_C0011577";
ALTER TABLE "DATACHECK"."SENSITIVE_USER_SUBACC" DROP CONSTRAINT "SYS_C0011578";
ALTER TABLE "DATACHECK"."SENSITIVE_USER_SUBACC" DROP CONSTRAINT "SYS_C0011579";
ALTER TABLE "DATACHECK"."SENSITIVE_USER_SUBACC" DROP CONSTRAINT "SYS_C0020351";
ALTER TABLE "DATACHECK"."SENSITIVE_USER_SUBACC" DROP CONSTRAINT "SYS_C0020352";
ALTER TABLE "DATACHECK"."SENSITIVE_USER_SUBACC" DROP CONSTRAINT "SYS_C0020353";
COMMENT ON COLUMN "DATACHECK"."SENSITIVE_USER_SUBACC"."UUID" IS '主键';
COMMENT ON COLUMN "DATACHECK"."SENSITIVE_USER_SUBACC"."PROVINCECODE" IS '省份编码';
COMMENT ON COLUMN "DATACHECK"."SENSITIVE_USER_SUBACC"."USERNAME" IS '涉敏人员';
COMMENT ON COLUMN "DATACHECK"."SENSITIVE_USER_SUBACC"."GROUPNAME" IS '所属系统名称';
COMMENT ON COLUMN "DATACHECK"."SENSITIVE_USER_SUBACC"."SUBGROUPNAME" IS '所属子系统名称';
COMMENT ON COLUMN "DATACHECK"."SENSITIVE_USER_SUBACC"."GROUPNAMETYPE" IS '所属系统类型';
COMMENT ON COLUMN "DATACHECK"."SENSITIVE_USER_SUBACC"."ORGPATHNAME" IS '组织路径名称';
COMMENT ON COLUMN "DATACHECK"."SENSITIVE_USER_SUBACC"."JOBROLE" IS '岗位角色';
COMMENT ON COLUMN "DATACHECK"."SENSITIVE_USER_SUBACC"."USERID" IS '主账号';
COMMENT ON COLUMN "DATACHECK"."SENSITIVE_USER_SUBACC"."ACCOUNTID" IS '从账号';
COMMENT ON COLUMN "DATACHECK"."SENSITIVE_USER_SUBACC"."AUTHZTYPE" IS '从账号类型';
COMMENT ON COLUMN "DATACHECK"."SENSITIVE_USER_SUBACC"."ACCSTARTTIME" IS '生效时间';
COMMENT ON COLUMN "DATACHECK"."SENSITIVE_USER_SUBACC"."ACCENDTIME" IS '失效时间';
COMMENT ON COLUMN "DATACHECK"."SENSITIVE_USER_SUBACC"."REMARK" IS '备注';
COMMENT ON COLUMN "DATACHECK"."SENSITIVE_USER_SUBACC"."STATUS" IS '状态';
COMMENT ON COLUMN "DATACHECK"."SENSITIVE_USER_SUBACC"."LOGICDELETE" IS '是否逻辑删除 0正常  1删除';
COMMENT ON COLUMN "DATACHECK"."SENSITIVE_USER_SUBACC"."REGISTDATE" IS '注册日期';
COMMENT ON COLUMN "DATACHECK"."SENSITIVE_USER_SUBACC"."OPTUSER" IS '未知作用的字段';
COMMENT ON COLUMN "DATACHECK"."SENSITIVE_USER_SUBACC"."MODIFYTIME" IS '修改时间';
COMMENT ON COLUMN "DATACHECK"."SENSITIVE_USER_SUBACC"."MODIFYUSERID" IS '修改者编号';
COMMENT ON COLUMN "DATACHECK"."SENSITIVE_USER_SUBACC"."GROUPUUID" IS '业务系统ID';
COMMENT ON COLUMN "DATACHECK"."SENSITIVE_USER_SUBACC"."OPERAUTHZ" IS '操作权限';
COMMENT ON COLUMN "DATACHECK"."SENSITIVE_USER_SUBACC"."SENSITIVEAUTHZCONTENT" IS '涉敏权限内容';



-- 字段修改
ALTER TABLE "DATACHECK"."PHYSICAL_SECURITY_SYSTEM"
MODIFY ("CREATETIME" DATE )
MODIFY ("MODIFYTIME" DATE )

ALTER TABLE "DATACHECK"."E_DATASAFE_LETTERS_SIGN"
MODIFY ("CREATE_TIME" DATE )
MODIFY ("MODIFY_TIME" DATE )


-- 菜单 SQL，若有报错，则可能是重名、uuid重复引起，删去已有菜单项再添加
insert into sys_menu (menu_id, menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values(3034, '物理安全情况', '2071', '1', '/system/physecsys', 'C', '0', 'system:physecsys:view', '#', 'admin', sysdate, 'wangcong', sysdate, '物理安全情况菜单');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values(3063, '责任书和保密协议签署情况', '2075', '2', '/system/sign', 'C', '0', 'system:sign:view', '#', 'admin', sysdate, 'wangcong', sysdate, '责任书和保密协议签署情况菜单');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values(3081, '涉敏人员库', '2083', '1', '/system/sensitivebank', 'C', '0', 'system:sensitivebank:view', '#', 'admin', sysdate, 'wangcong', sysdate, '涉敏人员库菜单');

-- 以下是主键序列

-- physical_security_system主键序列
create sequence seq_physical_security_system
increment by 1
start with 10
nomaxvalue
nominvalue
cache 20;
-- e_rel_system_room_cabinet主键序列
create sequence seq_e_rel_system_room_cabinet
increment by 1
start with 10
nomaxvalue
nominvalue
cache 20;
-- e_rel_system_annex主键序列
create sequence seq_e_rel_system_annex
increment by 1
start with 10
nomaxvalue
nominvalue
cache 20;
-- e_datasafe_letters_sign主键序列
create sequence seq_e_datasafe_letters_sign
increment by 1
start with 10
nomaxvalue
nominvalue
cache 20;
-- sensitive_user_subacc主键序列
create sequence seq_sensitive_user_subacc
increment by 1
start with 10
nomaxvalue
nominvalue
cache 20;
