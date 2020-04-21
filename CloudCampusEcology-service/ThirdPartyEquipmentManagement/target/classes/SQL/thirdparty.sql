drop table if exists thirdparty_device;
/*==============================================================*/
/* Table: thirdparty_device                                     */
/*==============================================================*/
create table thirdparty_device
(
   id                   varchar(20)     comment '主键' not null,
   device_name          varchar(50)     comment '设备名称',
   device_type          varchar(2)      comment '设备类型',
   device_manufacturer  varchar(50)     comment '设备厂商',
   register_area        varchar (100)   comment '登记地点',
   mac                  varchar(50)     comment 'mac',
   site_id              varchar(20)     comment '站点ID',
   delete_flag          varchar(2)      comment '删除标志',
   create_time          datetime        comment '创建时间',
   delete_time          datetime        comment '删除时间',
   primary key (id)
);
alter table thirdparty_device comment '设备表';

drop table if exists thirdparty_device_changelog;
/*==============================================================*/
/* Table: thirdparty_device_changelog                           */
/*==============================================================*/
create table thirdparty_device_changelog
(
   id                   varchar(20)     comment '主键' not null,
   device_id            varchar(50)     comment '设备ID',
   change_type          varchar(2)      comment '改变类型',
   change_before        varchar(50)     comment '改变前值',
   change_after         varchar (100)   comment '改变后值',
   create_time          datetime        comment '创建时间',
   primary key (id)
);
alter table thirdparty_device_changelog comment '设备变更表';

drop table if exists thirdparty_devicelog;
/*==============================================================*/
/* Table: thirdparty_devicelog                                  */
/*==============================================================*/
create table thirdparty_devicelog
(
   id                   varchar(20)     comment '主键' not null,
   device_id            varchar(50)     comment '设备ID',
   status               varchar(2)      comment '状态',
   site_id              varchar(20)     comment '站点ID',
   delete_flag          varchar(2)      comment '删除标识',
   record_time          datetime        comment '记录时间',
   delete_time          datetime        comment '删除时间',
   primary key (id)
);
alter table thirdparty_devicelog comment '设备日志表';