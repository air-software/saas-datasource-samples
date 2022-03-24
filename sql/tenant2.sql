-- ----------------------------
-- 租户2的建表语句，库名应与公共库中数据源配置的schema_name保持一致
-- ----------------------------

drop table if exists user;
create table user (
  id                bigint(20)      not null auto_increment    comment 'id',
  name         varchar(100)     default ''                 comment '姓名',
  primary key (id)
) engine=innodb auto_increment=100 comment = '用户表';

insert into user values(1, 'user in tenant2');
