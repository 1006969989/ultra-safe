-- 修改 e_audit_outgoing_data表的create_time和modify_time的数据类型
alter table e_audit_outgoing_data modify create_time DATE;
alter table e_audit_outgoing_data modify modify_time DATE;
alter table e_audit_outgoing_data modify time DATE;
