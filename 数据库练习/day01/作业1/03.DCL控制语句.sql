-- ====================== mysql用户管理
-- ====================== mysql用户管理
-- ====================== mysql用户管理
-- 切换到mysql数据库
use mysql;
-- 查询用户
select * from user;
-- 创建用户
create user 'itcast'@'localhost' identified by 'itcast';
-- 修改用户密码
alter user 'itcast'@'localhost' identified with mysql_native_password by '1234';
-- 删除用户
drop user 'itcast'@'localhost';


-- ====================== 权限控制
-- ====================== 权限控制
-- ====================== 权限控制
-- 查询权限：
show grants for itcast@localhost;
-- 授予权限：
grant ALL on mysql.* to itcast@localhost;
-- 撤销权限：
revoke ALL on mysql.* from itcast@localhost;


-- ALL 所有权限
-- SELECT 查询数据
-- INSERT	插入数据
-- UPDATE	修改数据
-- DELETE	删除数据
-- ALTER	修改表
-- DROP     删除数据库/表/视图
-- CREATE	创建数据库/表
-- USAGE	无权限

-- 多个权限之间，使用逗号分隔。例如：SELECT, CREATE
-- 授权时，数据库名和表名可以使用 *  进行通配，代表所有