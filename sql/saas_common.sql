-- ----------------------------
-- SaaS公共库建表语句，公共库名应与application.yml中配置的默认库名一致。
-- ----------------------------

drop table if exists data_source_config;
create table data_source_config (
  id                bigint(20)      not null auto_increment    comment 'id',
  host         varchar(190)     default ''                 comment '数据源地址',
  schema_name  varchar(190)     default ''                 comment '数据库名',
  username         varchar(100)     default ''                 comment '用户名',
  password         varchar(100)     default ''                 comment '密码',
  primary key (id)
) engine=innodb auto_increment=100 comment = 'SaaS数据源配置';

-- ----------------------------
-- 将下列初始化数据中的数据源配置改为你的实际配置
-- ----------------------------
insert into data_source_config values(1, 'jdbc:mysql://localhost/', 'tenant1', 'root', '123456');
insert into data_source_config values(2, 'jdbc:mysql://localhost/', 'tenant2', 'root', '123456');
