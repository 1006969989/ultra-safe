
-- 字段修改
ALTER TABLE "DATACHECK"."E_SYSTEMSHAREDATA_INFO"
MODIFY ("CREATETIME" DATE )
MODIFY ("MODIFYTIME" DATE )

-- 字段修改
ALTER TABLE "DATACHECK"."SENSITIVE_RES_SUBACC"
MODIFY ("CREATETIME" DATE )
MODIFY ("MODIFYTIME" DATE )

-- 字段修改
ALTER TABLE "DATACHECK"."E_SENSITIVEINFODAILYAUDIT"
MODIFY ("AUDITTIME" DATE )
MODIFY ("STORAGETIME" DATE )

-- 字段修改
ALTER TABLE "DATACHECK"."E_SENSITIVEOPERATIONINVENTORY"
MODIFY ("ENTRYTIME" DATE )


-- 菜单 SQL
INSERT INTO "DATACHECK"."SYS_MENU" VALUES ('3020', '字典', '105', '9', '/system/dict', 'menuItem', 'C', '0', 'system:dict:view', '#', 'admin', TO_DATE('2020-06-02 11:50:06', 'SYYYY-MM-DD HH24:MI:SS'), 'admin', TO_DATE('2020-06-02 11:50:44', 'SYYYY-MM-DD HH24:MI:SS'), NULL);
INSERT INTO "DATACHECK"."SYS_MENU" VALUES ('3022', '操作清单', '2087', '2', '/system/sensitiveoperationinventory', 'menuItem', 'C', '0', 'system:sensitiveoperationinventory:view', '#', 'admin', TO_DATE('2020-06-09 15:16:44', 'SYYYY-MM-DD HH24:MI:SS'), 'admin', TO_DATE('2020-06-12 18:30:07', 'SYYYY-MM-DD HH24:MI:SS'), NULL);
INSERT INTO "DATACHECK"."SYS_MENU" VALUES ('3023', '审批记录单', '2087', '3', '#', 'menuItem', 'C', '0', NULL, '#', 'admin', TO_DATE('2020-06-09 15:17:10', 'SYYYY-MM-DD HH24:MI:SS'), NULL, NULL, NULL);
INSERT INTO "DATACHECK"."SYS_MENU" VALUES ('2086', '涉敏资产库', '2083', '3', '/system/subacc', 'menuItem', 'C', '0', 'system:subacc:view', '#', 'admin', TO_DATE('2020-05-15 10:45:34', 'SYYYY-MM-DD HH24:MI:SS'), 'admin', TO_DATE('2020-06-04 19:18:57', 'SYYYY-MM-DD HH24:MI:SS'), NULL);
INSERT INTO "DATACHECK"."SYS_MENU" VALUES ('2063', '系统共享数据信息', '2062', '1', '/system/sharedatainfo', 'menuItem', 'C', '0', 'system:sharedatainfo:view', '#', 'admin', TO_DATE('2020-05-15 10:12:34', 'SYYYY-MM-DD HH24:MI:SS'), 'admin', TO_DATE('2020-06-01 14:06:44', 'SYYYY-MM-DD HH24:MI:SS'), NULL);
INSERT INTO "DATACHECK"."SYS_MENU" VALUES ('3021', '每日稽核表', '2087', '1', '/system/sensitiveinfodailyaudit', 'menuItem', 'C', '0', 'system:sensitiveinfodailyaudit:view', '#', 'admin', TO_DATE('2020-06-09 15:16:14', 'SYYYY-MM-DD HH24:MI:SS'), 'admin', TO_DATE('2020-06-10 16:31:27', 'SYYYY-MM-DD HH24:MI:SS'), NULL);
INSERT INTO "DATACHECK"."SYS_MENU" VALUES ('3003', '责任矩阵字段', '105', '6', '/system/matrix', 'menuItem', 'C', '0', 'system:matrix:view', '#', 'admin', TO_DATE('2020-05-19 15:57:22', 'SYYYY-MM-DD HH24:MI:SS'), 'admin', TO_DATE('2020-05-20 17:38:43', 'SYYYY-MM-DD HH24:MI:SS'), NULL);
INSERT INTO "DATACHECK"."SYS_MENU" VALUES ('3004', '涉敏数据范围字段', '105', '7', '/system/range', 'menuItem', 'C', '0', 'system:range:view', '#', 'admin', TO_DATE('2020-05-19 15:59:20', 'SYYYY-MM-DD HH24:MI:SS'), 'admin', TO_DATE('2020-05-20 17:38:52', 'SYYYY-MM-DD HH24:MI:SS'), NULL);
INSERT INTO "DATACHECK"."SYS_MENU" VALUES ('3005', '涉敏数据类型字段', '105', '8', '/system/type', 'menuItem', 'C', '0', 'system:type:view', '#', 'admin', TO_DATE('2020-05-19 15:59:49', 'SYYYY-MM-DD HH24:MI:SS'), 'admin', TO_DATE('2020-05-20 17:39:25', 'SYYYY-MM-DD HH24:MI:SS'), NULL);

-- 涉敏数据范围数据
INSERT INTO "DATACHECK"."E_SENSITIVE_RANGE" VALUES ('2', 'A1.用户身份和标识信息', 'A1-2：网络身份标识', 'A. 用户身份和鉴权信息', '联系电话、邮箱地址（如139邮箱地址）、网络客户编号、即时通信账号（如飞信号）、网络社交用户账号等可以精确标识网络用户或通信用户的信息
');
INSERT INTO "DATACHECK"."E_SENSITIVE_RANGE" VALUES ('1', 'A1.用户身份和标识信息', 'A1-1：自然人身份标识', 'A. 用户身份和鉴权信息', '客户姓名、证件类型及号码、驾照编号、银行账户、客户实体编号、集团客户编号、集团客户名称、集团客户负责人\联系人信息等可以精确标识定位具体实体客户的信息
');
INSERT INTO "DATACHECK"."E_SENSITIVE_RANGE" VALUES ('21', 'A1.用户身份和标识信息', 'A1-3：用户基本资料', 'A．用户身份和鉴权信息', '客户职业、工作单位、年龄、性别、籍贯、兴趣爱好等；集团客户所在省市、所在行业、集团签约时间及协议到期时间、单位成员个人基本资料等');
INSERT INTO "DATACHECK"."E_SENSITIVE_RANGE" VALUES ('24', 'A2：用户网络身份鉴权信息', 'A2-1：用户密码及关联信息', 'A．用户身份和鉴权信息', '用户网络身份密码及关联信息，如：手机客服密码、139邮箱密码、飞信密码、移动wlan密码、和包等交易密码，以及这些密码关联的密码保护答案等');
INSERT INTO "DATACHECK"."E_SENSITIVE_RANGE" VALUES ('26', 'B1：服务内容和资料数据', 'B1-1：服务内容数据', 'B．用户数据及服务内容信息', '电信网服务内容数据：短信、彩信、话音等通信内容；移动互联网服务内容信息：包括：飞信、融合通信、139邮箱等移动互联网服务所涉及通话内容、及时通信内容、群内发布内容、数据文件、邮件内容、用户上网访问内容等；用户云存储、SDN、IDC等存储或缓存的非公开的私有文字、多媒体等资料数据信息');
INSERT INTO "DATACHECK"."E_SENSITIVE_RANGE" VALUES ('27', 'B1：服务内容和资料数据', 'B1-2：联系人信息', 'B．用户数据及服务内容信息', '用户通讯录、好友列表、群组列表等用户资料数据');
INSERT INTO "DATACHECK"."E_SENSITIVE_RANGE" VALUES ('28', 'C1：用户服务使用数据', 'C1-1：业务订购关系', 'C．用户服务相关信息', '基本业务订购关系：品牌、套餐定制等情况；增值业务订购关系：139邮箱、飞信、和通讯录、来显、彩铃、和包等增值业务的注册、修改、注销');
INSERT INTO "DATACHECK"."E_SENSITIVE_RANGE" VALUES ('30', 'C1：用户服务使用数据', 'C1-3：消费信息和账单', 'C．用户服务相关信息', '消费信息：停开机、入网时间、在网时间、积分、预存款、信用等级、信用额度、缴费情况、付费方式、和包余额、交易历史记录 账单：每月出账的固定费用、通信费用、欠费信息、数据费用、代收费用');
INSERT INTO "DATACHECK"."E_SENSITIVE_RANGE" VALUES ('33', 'C2：设备信息', 'C2-1：终端设备标识', 'C．用户服务相关信息', '唯一设备识别码IMEI、设备MAC地址、SIM卡IMSI信息等等可以精确标识定位具体设备的信息');
INSERT INTO "DATACHECK"."E_SENSITIVE_RANGE" VALUES ('34', 'C2：设备信息', 'C2-2：终端设备资料', 'C．用户服务相关信息', '终端型号、品牌、厂商、OS类型、预置\安装软件应用、使用时长等');
INSERT INTO "DATACHECK"."E_SENSITIVE_RANGE" VALUES ('22', 'A1.用户身份和标识信息', 'A1-4：实体身份证明', 'A．用户身份和鉴权信息', '身份证、护照、驾照、营业执照等证件影印件等；指纹、声纹、虹膜等');
INSERT INTO "DATACHECK"."E_SENSITIVE_RANGE" VALUES ('23', 'A1.用户身份和标识信息', 'A1-5：用户私密资料', 'A．用户身份和鉴权信息', '揭示个人种族、家属信息、居住地址、宗教信仰、基因、个人健康、私人生活等有关的用户私密信息。《征信业管理条例》等法律、行政法规规定禁止公开的用户其他信息');
INSERT INTO "DATACHECK"."E_SENSITIVE_RANGE" VALUES ('29', 'C1：用户服务使用数据', 'C1-2：服务记录和日志', 'C．用户服务相关信息', '服务详单及信令：包括语音、短信、彩信和上网日志详单、2G/3G/LTE用户面XDR及信令面XDR等，内含主叫号码、主叫归属地、被叫号码、开始通信时间、时长、流量等信息；移动互联网服务记录：包括Cookie内容、上网日志、连接APP等，内含主叫号码、网址、网购记录等');
INSERT INTO "DATACHECK"."E_SENSITIVE_RANGE" VALUES ('31', 'C1：用户服务使用数据', 'C1-4：位置数据', 'C．用户服务相关信息', '精确位置信息(如小区代码、基站号、基站经纬度坐标等) 大致位置信息(如地区代码等)');
INSERT INTO "DATACHECK"."E_SENSITIVE_RANGE" VALUES ('32', 'C1：用户服务使用数据', 'C1-5：违规记录数据', 'C．用户服务相关信息', '用户违规记录，包括垃圾短信、骚扰电话等记录、黑名单、灰名单等 业务违规记录，包括端口滥用、违规渠道、不良网站域名等记录、黑名单、灰名单等');


-- e_matrix_detail主键序列
create sequence seq_e_matrix_detail
minvalue 2000
maxvalue 9999999999
start with 2020
increment by 1
cache 20;


-- e_sensitive_range主键序列
create sequence seq_e_sensitive_range
minvalue 2000
maxvalue 9999999999
start with 2020
increment by 1
cache 20;

-- e_sensitive_type主键序列
create sequence seq_e_sensitive_type
minvalue 2000
maxvalue 9999999999
start with 2020
increment by 1
cache 20;

-- e_systemsharedata_info主键序列
create sequence seq_e_systemsharedata_info
minvalue 2000
maxvalue 9999999999
start with 2020
increment by 1
cache 20;

-- sensitive_res_subacc主键序列
create sequence seq_sensitive_res_subacc
minvalue 2000
maxvalue 9999999999
start with 2020
increment by 1
cache 20;



-- e_sensitiveinfodailyaudit主键序列
create sequence seq_e_sensitiveinfodailyaudit
minvalue 2000
maxvalue 9999999999
start with 2020
increment by 1
cache 20;


-- sensitiveoperationinventory主键序列
create sequence sensitiveoperationinventory
minvalue 2000
maxvalue 9999999999
start with 2020
increment by 1
cache 20;