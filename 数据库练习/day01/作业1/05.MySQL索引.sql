use db3;

-- ========================= 存储引擎
-- ========================= 存储引擎
-- ========================= 存储引擎
-- 创建表：指定存储引擎 InnoDB、MyISAM（MyISAM引擎：.sdi存储表结构 .myd存储数据 .myi存储索引）
create table if not exists tb_test1
(
    id   int comment '编号',
    name varchar(100) not null comment '名称'
) engine = MyISAM comment = '测试表';


-- ========================= 索引（批量添加100W条数据）
-- ========================= 索引（批量添加100W条数据）
-- ========================= 索引（批量添加100W条数据）
-- 创建 tb_sku 表（用于测试索引）
create table if not exists tb_sku
(
    sn   int comment 'sku编号',
    name varchar(100) not null comment '名称'
) comment = '商品库存表';
-- 清空表数据
truncate tb_sku;
-- 删除自定义函数 my_fun（如果存在）
drop function if exists my_fun;
-- 创建自定义函数 my_fun ，添加100W条数据（数字可以自行在内容中修改）
DELIMITER $$
CREATE FUNCTION my_fun()
    RETURNS INT
    DETERMINISTIC
BEGIN
    -- num 作为截止数字，定义为百万
    DECLARE num INT DEFAULT 1000000;
    DECLARE i INT DEFAULT 0;
    WHILE i < num
        DO
            insert into tb_sku(sn, name) values (i, concat('华为META_', i));
            SET i = i + 1;
        END WHILE;
    RETURN i;
END;

-- 调用自定义函数 my_fun，添加100W条数据
select my_fun();
-- 查询表记录数
select count(*) from tb_sku;

-- ========================= 索引操作
-- ========================= 索引操作
-- ========================= 索引操作
-- 创建索引
create index idx_name on tb_sku (name);
-- 查询索引
show index from tb_sku;
-- 删除索引
drop index idx_name on tb_sku;

select * from tb_sku where name = '华为META_999999';