-- 部门管理
create table tb_dept(
                        id int unsigned primary key auto_increment comment '主键ID',
                        name varchar(10) not null unique comment '部门名称',
                        create_time datetime not null comment '创建时间',
                        update_time datetime not null comment '修改时间'
) comment '部门表';

insert into tb_dept (id, name, create_time, update_time)
values(1,'学工部',now(),now()),
      (2,'教研部',now(),now()),
      (3,'咨询部',now(),now()),
      (4,'就业部',now(),now()),
      (5,'人事部',now(),now());


-- 员工管理
create table tb_emp (
                        id int unsigned primary key auto_increment comment 'ID',
                        username varchar(20) not null unique comment '用户名',
                        password varchar(32) default '123456' comment '密码',
                        name varchar(10) not null comment '姓名',
                        gender tinyint unsigned not null comment '性别, 说明: 1 男, 2 女',
                        image varchar(300) comment '图像',
                        job tinyint unsigned comment '职位, 说明: 1 班主任,2 讲师, 3 学工主管, 4 教研主管, 5 咨询师',
                        entrydate date comment '入职时间',
                        dept_id int unsigned comment '部门ID',
                        salary int unsigned comment '月工资',
                        create_time datetime not null comment '创建时间',
                        update_time datetime not null comment '修改时间'
) comment '员工表';

INSERT INTO tb_emp
(id, username, password, name, gender, image, job, entrydate,dept_id,salary, create_time, update_time) VALUES
(1,'jinyong','123456','金庸',1,'1.jpg',4,'2000-01-01',2,20000,now(),now()),
(2,'zhangwuji','123456','张无忌',1,'2.jpg',2,'2015-01-01',2,18000,now(),now()),
(3,'yangxiao','123456','杨逍',1,'3.jpg',2,'2008-05-01',2,16800,now(),now()),
(4,'weiyixiao','123456','韦一笑',1,'4.jpg',2,'2007-01-01',2,12000,now(),now()),
(5,'changyuchun','123456','常遇春',1,'5.jpg',2,'2012-12-05',2,9000,now(),now()),
(6,'xiaozhao','123456','小昭',2,'6.jpg',3,'2013-09-05',1,6000,now(),now()),
(7,'jixiaofu','123456','纪晓芙',2,'7.jpg',1,'2005-08-01',1,6500,now(),now()),
(8,'zhouzhiruo','123456','周芷若',2,'8.jpg',1,'2014-11-09',1,7200,now(),now()),
(9,'dingminjun','123456','丁敏君',2,'9.jpg',1,'2011-03-11',1,5300,now(),now()),
(10,'zhaomin','123456','赵敏',2,'10.jpg',1,'2013-09-05',1,12000,now(),now()),
(11,'luzhangke','123456','鹿杖客',1,'11.jpg',5,'2007-02-01',3,8900,now(),now()),
(12,'hebiweng','123456','鹤笔翁',1,'12.jpg',5,'2008-08-18',3,7800,now(),now()),
(13,'fangdongbai','123456','方东白',1,'13.jpg',5,'2012-11-01',3,6800,now(),now()),
(14,'zhangsanfeng','123456','张三丰',1,'14.jpg',2,'2002-08-01',2,15800,now(),now()),
(15,'yulianzhou','123456','俞莲舟',1,'15.jpg',2,'2011-05-01',2,11500,now(),now()),
(16,'songyuanqiao','123456','宋远桥',1,'16.jpg',2,'2007-01-01',2,8300,now(),now()),
(17,'chenyouliang','123456','陈友谅',1,'17.jpg',NULL,'2015-03-21',NULL,4500,now(),now());


-- 薪资等级表
create table tb_salgrade(
                            grade int comment '等级',
                            losal int comment '该等级最低薪资',
                            hisal int comment '该等级最高薪资'
) comment '薪资等级表';

insert into tb_salgrade values (1,0,3000);
insert into tb_salgrade values (2,3001,5000);
insert into tb_salgrade values (3,5001,8000);
insert into tb_salgrade values (4,8001,10000);
insert into tb_salgrade values (5,10001,15000);
insert into tb_salgrade values (6,15001,20000);
insert into tb_salgrade values (7,20001,25000);
insert into tb_salgrade values (8,25001,30000);

-- 1. 查询员工的姓名 , 及所属的部门名称 (隐式内连接实现)
select t1.name '姓名', t2.name '部门' from tb_emp t1,tb_dept t2 where t1.dept_id=t2.id;
-- 2. 查询员工的姓名 , 及所属的部门名称 (显式内连接实现)
select t1.name '姓名', t2.name '部门' from tb_emp t1 join tb_dept t2 on  t1.dept_id=t2.id;
-- 3. 查询员工的 姓名、性别、职位、部门名称 （隐式内连接）
select t1.name                  '姓名',
       if(gender = 1, '男', '女') '性别',
       (case t1.job
            when 1 then '班主任'
            when 2 then '讲师'
            when 3 then '学工主管'
            when 4 then '教研主管'
            else '无职位' end)     '职位',
       t2.name                  '部门'
from tb_emp t1,
     tb_dept t2
where t1.dept_id = t2.id;
-- 4. 查询 薪资 高于 10000 的员工的姓名、性别、职位、部门名称（显式内连接）
select t1.name                  '姓名',
       if(gender = 1, '男', '女') '性别',
       (case t1.job
            when 1 then '班主任'
            when 2 then '讲师'
            when 3 then '学工主管'
            when 4 then '教研主管'
            else '无职位' end)     '职位',
       t2.name                  '部门'
from tb_emp t1
         join
     tb_dept t2
     on t1.dept_id = t2.id;
-- 5. 查询员工表 所有 员工的姓名, 和对应的部门名称 (左外连接)
select t1.name,t2.name
from tb_emp t1
         left join tb_dept t2 on t1.dept_id = t2.id;
-- 6. 查询员工表 所有 员工的姓名, 和对应的部门名称 (右外连接)
select t2.name,t1.name
from tb_dept t1
         right join tb_emp t2 on t2.dept_id = t1.id;
-- 7. 查询部门表 所有 部门的名称, 和对应的员工名称 (右外连接)
select t2.name,t1.name
from tb_emp t1
         right join tb_dept t2 on t1.dept_id = t2.id;
-- 8. 查询 "教研部" 的所有员工信息 （标量子查询）
select *
from tb_emp
where dept_id = (select id from tb_dept where name = '教研部');
-- 9. 查询在 "方东白" 入职之后的员工信息 （标量子查询）
select *
from tb_emp
where entrydate > (select entrydate from tb_emp where name = '方东白');
-- 10. 查询 "教研部" 和 "咨询部" 的所有员工信息 （列子查询）
select *
from tb_emp
where dept_id in (select id from tb_dept where name in ('教研部','咨询部'));
-- 11. 查询与 "韦一笑" 的入职日期 及 职位都相同的员工信息 （行子查询）
select job from tb_emp where name = '韦一笑';
select * from tb_emp where entrydate=(select entrydate from tb_emp where name = '韦一笑');
-- 12. 查询入职日期是 "2006-01-01" 之后的员工信息 , 及其部门信息 （表子查询）
select * from (select t1.name ename,t2.name dname ,t1.entrydate
               from tb_emp t1,
                    tb_dept t2
               where t1.dept_id = t2.id) t where entrydate>'2006-01-01';
-- 13. 查询 拥有员工的 部门ID、部门名称 (没有员工的部门无需展示)
select * from tb_dept where id in (select distinct dept_id from tb_emp);
-- 14. 查询所有 在 2010-01-01 之后入职的员工, 及其归属的部门名称; 如果员工没有分配部门, 也需要展示出来
select t1.name,t2.name
from tb_emp t1
         left join tb_dept t2 on t1.dept_id = t2.id
where entrydate > '2010-01-01';
-- 15. 查询 "教研部" 员工的平均工资
select t1.avg
from (select dept_id, avg(salary) avg from tb_emp group by dept_id) t1
where t1.dept_id = (select id from tb_dept where name = '教研部');
-- 16. 查询工资比 "俞莲舟" 高的员工信息。
select *
from tb_emp
where salary > (select salary from tb_emp where name = '俞莲舟');
-- 17. 查询 工资 比该企业员工的平均薪资 还要高的员工信息
select * from tb_emp where salary>(select avg(salary) from tb_emp);
-- 18. 查询所有的部门信息, 并统计部门的员工人数
select t1.name , t2.total
from tb_dept t1,
     (select dept_id, count(*) total from tb_emp group by dept_id) t2
where t1.id = t2.dept_id;
-- 19. 查询所有员工的 姓名, 工资 , 及 工资等级 (有难度的哦)
select * from tb_salgrade;
select t1.name, t1.salary, t2.losal, t2.hisal, t2.grade
from tb_emp t1,
     tb_salgrade t2
where t1.salary between t2.losal and t2.hisal;
-- 20. 查询 "教研部" 所有员工的信息 及 工资等级 (有难度的哦)
select * from tb_emp where dept_id=(select id from tb_dept where name='教研部');
select *
from (select * from tb_emp where dept_id = (select id from tb_dept where name = '教研部')) t1,
     tb_salgrade t2
where t1.salary between t2.losal and t2.hisal;
-- 21. 查询 工资 低于 本部门平均工资的员工信息 (有难度的哦)
select dept_id, avg(salary) from tb_emp group by dept_id;
select t1.name, t1.salary
from tb_emp t1,
     (select dept_id, avg(salary) avg from tb_emp group by dept_id) t2
where t1.dept_id = t2.dept_id
  and t1.salary < t2.avg;