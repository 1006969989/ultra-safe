-- sys_user表添加生效日期字段
alter table sys_user
add start_date date

comment on column  sys_user.start_date is '生效日期';

-- sys_user表添加有效期
alter table sys_user
add end_date date

comment on column sys_user.end_date is '有效期截止';

--给用户添加uuid字段
alter table sys_user
add useruuid varchar2(32) 

comment on column sys_user.useruuid is '用户uuid，作为外键使用';

-- sys_user表添加是否永久账号字段  0 否  1 是
alter table sys_user
add isforever char(1)

comment on column sys_user.isforever is '是否永久账号  0 否   1 是';

--创建用户授权表
drop table e_user_resgroup

create table e_user_resgroup
(
  uuid varchar2(32), --主键
  useruuid varchar2(32), --用户uuid
  resgroupuuid varchar2(32) -- 资源uuid
)