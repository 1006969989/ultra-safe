-- 菜单 SQL，若有报错，则可能是重名、uuid重复引起，删去已有菜单项再添加
insert into sys_menu (menu_id, menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values(3034, '物理安全情况', '2071', '1', '/system/physecsys', 'C', '0', 'system:physecsys:view', '#', 'admin', sysdate, 'wangcong', sysdate, '物理安全情况菜单');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values(3063, '责任书和保密协议签署情况', '2075', '2', '/system/sign', 'C', '0', 'system:sign:view', '#', 'admin', sysdate, 'wangcong', sysdate, '责任书和保密协议签署情况菜单');

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
