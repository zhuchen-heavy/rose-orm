-- 1：用户表的sql语句
create database rose;
create table user (
  id       int(8) auto_increment comment '主键',
  username     varchar(255) not null comment '用户名',
  password varchar(255) not null comment '密码',
  primary key (id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;