-- ha_health_message
-- 建表语句
create table ha_health_message (
  id            integer not null primary key,
  component_id  varchar(255),
  name          varchar(255),
  segment_id    varchar(255),
  service_state varchar(255),
  collect_time  varchar(255),
  collect_count varchar(255)
);
-- 插入语句
insert into ha_health_message (component_id, name, segment_id, service_state, collect_time, collect_count)
values (1, date(), 'lsm', 'zhangsan', 'cas', 0);
--  批量插入语句
insert into ha_health_message (component_id, name, segment_id, service_state, collect_time, collect_count)
values
  (1, date(), 'lsm', 'zhangsan', 'cas', 0),
  (1, date(), 'lsm', 'zhangsan', 'cas', 0);
-- 删除语句
delete from ha_health_message;
-- 查询语句
select
  id,
  component_id,
  name,
  segment_id,
  service_state,
  collect_time,
  collect_count
from ha_health_message;

-- ha_keepalived_message
-- 建表语句
create table ha_keepalived_message (
  id          integer not null primary key,
  state       varchar(255),
  switch_time varchar(255)
);
-- 插入语句
insert into ha_keepalived_message (state, switch_time) values ('master', date());
-- 批量插入
insert into ha_keepalived_message (state, switch_time)
values
  ('master', date()),
  ('master', date());
-- 查询语句
select
  id,
  state,
  switch_time
from ha_keepalived_message;
-- 删除语句
delete from ha_keepalived_message