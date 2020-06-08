-- 修改 e_datasafe_authapply_audit表的create_time和modify_time的数据类型
alter table e_datasafe_authapply_audit modify create_time DATE;
alter table e_datasafe_authapply_audit modify modify_time DATE;

-- 菜单 SQL
insert into sys_menu (menu_id, menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values(2078, '人员权限申请记录稽核表', '2075', '3', '/system/authapplyaudit', 'C', '0', 'system:authapplyaudit:view', '#', 'admin', sysdate, 'ry', sysdate, '人员权限申请记录稽核表菜单');

-- 按钮 SQL
insert into sys_menu  (menu_id, menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values(seq_sys_menu.nextval, '人员权限申请记录稽核表查询', 2078, '1',  '#',  'F', '0', 'system:authapplyaudit:list',         '#', 'admin', sysdate, 'ry', sysdate, '');

insert into sys_menu  (menu_id, menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values(seq_sys_menu.nextval, '人员权限申请记录稽核表新增', 2078, '2',  '#',  'F', '0', 'system:authapplyaudit:add',          '#', 'admin', sysdate, 'ry', sysdate, '');

insert into sys_menu  (menu_id, menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values(seq_sys_menu.nextval, '人员权限申请记录稽核表修改', 2078, '3',  '#',  'F', '0', 'system:authapplyaudit:edit',         '#', 'admin', sysdate, 'ry', sysdate, '');

insert into sys_menu  (menu_id, menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values(seq_sys_menu.nextval, '人员权限申请记录稽核表删除', 2078, '4',  '#',  'F', '0', 'system:authapplyaudit:remove',       '#', 'admin', sysdate, 'ry', sysdate, '');

insert into sys_menu  (menu_id, menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values(seq_sys_menu.nextval, '人员权限申请记录稽核表导出', 2078, '5',  '#',  'F', '0', 'system:authapplyaudit:export',       '#', 'admin', sysdate, 'ry', sysdate, '');

-- e_datasafe_authapply_audit主键序列
create sequence seq_e_datasafe_authapply_audit
increment by 1
start with 10
nomaxvalue
nominvalue
cache 20;