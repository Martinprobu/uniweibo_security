/** 
*** @author BillWu
*** @since 2014-10-13
*** @update 2014-10-14
***	@desc 权限模块数据库 uni_privileges 建表语句
***	@version 1.0
*** 
*** ┌－  ┐     ┌－  ┐
*   │  │     │  │
* ┌－  －－－－－－    －  －┐
* │    \  │  /   │
* │              │
* │    ≥     ≤   │
* │       ω      │
* │       o      │
* │              │
* └－－      －－┘
******│      │ SQL is far away from bug with The Husky protection
******│      │ 小哈护佑,SQL无bug
******│      －－－－－－┐
******│                   －┐
******│                   ┌ ┘
******└－   －－－   －－┘
*********││││    ││││
*********└－┘    └－┘
*** 
**/

create database if not exists uni_privileges default charset utf8 collate utf8_general_ci; 
use uni_privileges;
set foreign_key_checks=0;


drop table if exists users;
create table users (
	id int auto_increment comment '自增id',
	u_id int not null default '0' comment '用户uid',#bigint
	name varchar(32) not null default '' comment '用户名称',
	password varchar(64) not null default '' comment '用户密码',## insert into hex(aes_encrypt(phone,_utf8'uniweibo.3com')) 加密; aes_decrypt(unhex(phone),_utf8'uniweibo.3com') 解密
	detail varchar(32) not null default '' comment '用户附加描述',
	create_time timestamp not null default '0000-00-00 00:00:00' comment '创建时间',
	update_time timestamp not null default current_timestamp on update current_timestamp comment '更新时间',
	is_deleted tinyint not null default '0' comment '删除标识,0.可用，1.已删除不可用',
	primary key(id),
	unique key u_key_u_id(u_id)
) comment '用户表';

drop table if exists roles;
create table roles (
	ro_id int auto_increment comment '角色id',
	name varchar(32) not null default '' comment '角色名称',
	detail varchar(32) not null default '' comment '角色附加描述',
	create_time timestamp not null default '0000-00-00 00:00:00' comment '创建时间',
	update_time timestamp not null default current_timestamp on update current_timestamp comment '更新时间',
	is_deleted tinyint not null default '0' comment '删除标识,0.可用，1.已删除不可用',
	primary key(ro_id),
	unique key u_key_name(name)
) comment '角色表';

drop table if exists resources;
create table resources (
	re_id int auto_increment comment '资源id',
	url varchar(200) not null default '' comment '资源url',
	name varchar(32) not null default '' comment '资源名称',
	type varchar(8) not null default '1' comment '请求类型：get;post;put;del',
	detail varchar(32) not null default '' comment '资源附加描述',
	create_time timestamp not null default '0000-00-00 00:00:00' comment '创建时间',
	update_time timestamp not null default current_timestamp on update current_timestamp comment '更新时间',
	is_deleted tinyint not null default '0' comment '删除标识,0.可用，1.已删除不可用',
	primary key(re_id),
	unique key u_key_url_type(url, type)
) comment '资源表';

drop table if exists user_role;
create table user_role (
	id int auto_increment comment '自增id',
	u_id int not null default '0' comment '用户uid, 对应表users(u_id)', 
	ro_id int not null default '0' comment '角色id, 对应表roles(ro_id)',
	create_time timestamp not null default '0000-00-00 00:00:00' comment '创建时间',
	update_time timestamp not null default current_timestamp on update current_timestamp comment '更新时间',
	is_deleted tinyint not null default '0' comment '删除标识,0.可用，1.已删除不可用',
	primary key(id),
	unique key u_key_u_id_ro_id(u_id, ro_id),
	constraint f_key_uro_ro_id foreign key(ro_id) references roles(ro_id) on delete cascade on update cascade,
	constraint f_key_uro_u_id foreign key(u_id) references users(u_id) on delete cascade on update cascade
) comment '用户角色表';

drop table if exists role_resource;
create table role_resource (
	id int auto_increment comment '自增id',
	ro_id int not null default '0' comment '角色id, 对应表roles(ro_id)',
	re_id int not null default '0' comment '资源id, 对应表resources(re_id)', 
	create_time timestamp not null default '0000-00-00 00:00:00' comment '创建时间',
	update_time timestamp not null default current_timestamp on update current_timestamp comment '更新时间',
	is_deleted tinyint not null default '0' comment '删除标识,0.可用，1.已删除不可用',
	primary key(id),
	unique key u_key_ro_id_re_id(ro_id, re_id),
	constraint f_key_rore_ro_id foreign key(ro_id) references roles(ro_id) on delete cascade on update cascade,
	constraint f_key_rore_re_id foreign key(re_id) references resources(re_id) on delete cascade on update cascade
) comment '角色资源表';

drop table if exists user_resource;
create table user_resource (
	id int auto_increment comment '自增id',
	u_id int not null default '0' comment '用户uid, 对应表users(u_id)', 
	re_id int not null default '0' comment '资源id, 对应表resources(re_id)', 
	create_time timestamp not null default '0000-00-00 00:00:00' comment '创建时间',
	update_time timestamp not null default current_timestamp on update current_timestamp comment '更新时间',
	is_deleted tinyint not null default '0' comment '删除标识,0.可用，1.已删除不可用',
	primary key(id),
	unique key u_key_u_id_re_id(u_id, re_id),
	constraint f_key_ure_u_id foreign key(u_id) references users(u_id) on delete cascade on update cascade,
	constraint f_key_ure_re_id foreign key(re_id) references resources(re_id) on delete cascade on update cascade
) comment '用户资源表';

drop table if exists user_block;
create table user_block (
	id int auto_increment comment '自增id',
	u_id int not null default '0' comment '用户uid, 对应表users(u_id)', 
	re_id int not null default '0' comment '资源id, 对应表resources(re_id)', 
	create_time timestamp not null default '0000-00-00 00:00:00' comment '创建时间',
	update_time timestamp not null default current_timestamp on update current_timestamp comment '更新时间',
	is_deleted tinyint not null default '0' comment '删除标识,0.可用，1.已删除不可用',
	primary key(id),
	unique key u_key_u_id_re_id(u_id, re_id),
	constraint f_key_ubl_u_id foreign key(u_id) references users(u_id) on delete cascade on update cascade,
	constraint f_key_ubl_re_id foreign key(re_id) references resources(re_id) on delete cascade on update cascade
) comment '用户资源reject表';

