-- ========================= 事务管理
-- ========================= 事务管理
-- ========================= 事务管理
use db3;
-- 步骤1. 开启事务
-- 步骤2. 删除部门、部门下的员工
-- 步骤3. 提交事务？回滚事务？

-- ========================= 事务并发
-- ========================= 事务并发
-- ========================= 事务并发

-- 查看事务隔离级别
select @@transaction_isolation;
-- 设置事务隔离级别：read uncommitted、read committed、repeatable read、serializable
set session transaction isolation level repeatable read;
-- 开启事务，查询数据
start transaction;

select * from tb_emp;

-- 提交事务
commit;

-- ========================= 使用cmd黑窗口登录mysql，开启事务修改数据，但不提交
-- ========================= 使用cmd黑窗口登录mysql，开启事务修改数据，但不提交
-- ========================= 使用cmd黑窗口登录mysql，开启事务修改数据，但不提交
-- mysql -uroot -p1234
-- use db3;
-- start transaction;
-- delete from tb_emp where id=1;
-- insert into tb_emp values (99, 'miaorenfeng', '123456', '苗人凤', 1, '99.jpg', 4, '2000-01-01', 2, now(), now());