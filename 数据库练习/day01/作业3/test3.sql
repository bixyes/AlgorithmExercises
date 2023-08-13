create table employee (
                          id int unsigned primary key auto_increment comment '员工编号',
                          name varchar(10) not null comment '姓名',
                          job varchar(10) not null comment '职位',
                          manager int unsigned comment '领导',
                          hiredate date comment '入职时间',
                          salary double(8,2) comment '月工资',
                          comm double(8,2) comment '月度奖金',
                          dept_id int unsigned comment '部门编号'
) comment '雇员';
INSERT INTO employee VALUES (1,'Smith','销售',8,'2001-04-08',5800.00,1500.00,1),(2,'Allen','销售',8,'2004-12-02',5300.00,1700.00,1),(3,'Ward','前台',12,'2013-05-09',2800.00,NULL,2),(4,'Jones','行政',12,'2007-05-23',4600.00,NULL,2),(5,'Wartin','会计',9,'2008-09-01',5100.00,NULL,3),(6,'Blake','会计',9,'2007-05-17',5500.00,NULL,3),(7,'Scott','出纳',9,'2016-05-25',3800.00,NULL,3),(8,'Jerry','销售经理',13,'2010-05-10',7200.00,2200.00,1),(9,'Turner','财务总监',13,'1999-05-20',8800.00,2500.00,3),(10,'James','行政',12,'2014-05-15',3200.00,NULL,2),(11,'Miller','招聘专员',12,'2012-05-10',3600.00,NULL,2),(12,'Ford','人事经理',13,'2008-05-18',5800.00,1200.00,2),(13,'King','总经理',NULL,'2006-05-10',12000.00,NULL,4);




create table department (
                            id int unsigned primary key auto_increment comment '部门编号',
                            name varchar(20) comment '部门名称'
) comment '部门';
INSERT INTO department VALUES (1,'销售部'),(2,'人事行政部'),(3,'财务部'),(4,'总裁办'),(5,'后勤部');



create table salary_grade(
                             grade int unsigned primary key auto_increment comment '薪资等级',
                             losal int unsigned comment '最低薪资',
                             hisal int unsigned comment '最高薪资'
) comment '薪资等级表';

INSERT INTO salary_grade VALUES (1,0,3000),(2,3001,4500),(3,4501,6000),(4,6001,8000),(5,8001,10000),(6,10001,15000);

-- 1、取得最后入职的 5 名员工
select * from employee order by hiredate desc limit 5;
-- 2、列出部门名称和这些部门的员工信息(没有员工的部门也需要展示出来).
select * from department t1  left join employee t2 on t1.id=t2.dept_id;
-- 3、不准用聚合函数（Max），取得最高薪资
select *
from employee t1 left join
     employee t2
on t1.salary < t2.salary
  where t2.salary is null;
-- 4、取得平均薪资最高的部门的部门ID
select dept_id
from (select dept_id, avg(salary) avgsal
      from employee
      group by dept_id
      order by avgsal desc
      limit 1
     ) t;
-- 5、列出薪资比 "Smith" 多的员工信息.
select *
from employee
where salary > (select salary from employee where name = 'Smith');
-- 6、列出在部门 "人事行政部" 工作的员工的信息
select *
from employee
where dept_id = (select id
                 from department
                 where name = '人事行政部');
-- 7、列出所有员工的姓名、部门名称和工资。
select t1.name, t2.name, t1.salary
from employee t1
         left join department t2
                   on t1.dept_id = t2.id;
-- 8、列出所有部门的详细信息(包括部门ID, 部门名称)和人数
select id, name , count(*)
from (select d.id, d.name
      from department d
               left join employee e on d.id = e.dept_id) t
group by id;
-- 9、列出所有员工及领导的姓名 (员工没有领导, 也需要展示出来)
select t1.name 员工 , t2.name 领导 from employee t1 left join employee t2 on
t1.manager = t2.id;
-- 10、取得每个部门最高薪水的人员名称
select t2.name, t1.name
from employee t1,
     department t2,
     (select dept_id, max(salary) maxsal from employee group by dept_id) t3
where t1.dept_id = t3.dept_id
  and t1.salary = t3.maxsal
  and t1.dept_id = t2.id;
-- 11、哪些人的薪水在部门的平均薪水之上
select *
from employee t1,
     (select dept_id, avg(salary) avgsal from employee group by dept_id) t2
where t1.dept_id = t2.dept_id
  and t1.salary > t2.avgsal;
-- 12、取得 所有人的 平均的薪水等级
select *
from employee t1,
     salary_grade t2
where t1.salary between t2.losal and t2.hisal;
-- 13、列出与 "Jones" 从事相同工作 且 领导也相同的 所有员工及部门名称.
select t1.name, t2.name
from employee t1,
     department t2
where t1.dept_id = t2.id
  and t1.job = (select job from employee where name = 'Jones')
  and t1.manager = (select t1.manager from employee where name = 'Jones');
-- 14、取得平均薪水最高的部门的部门名称
select t1.name,t2.avgsal
from department t1,
     (select dept_id, avg(salary) avgsal
      from employee
      group by dept_id
      order by avgsal desc
      limit 1) t2
where t1.id = t2.dept_id;
-- 15、求平均薪水的等级最低的部门的部门名称
select name
from department
where id = (select dept_id
            from (select dept_id, avg(salary) avgsal
                  from employee
                  group by dept_id
                  order by avgsal
                  limit 1) t);
-- 16、取得比普通员工(员工编号没有在 manager 字段上出现的)的 最高薪水还要高的领导人姓名
select name
from employee
where salary > (select max(salary) from employee where id not in (select distinct manager from employee where manager is not null))
  and id in (select distinct manager from employee where manager is not null);
-- 17、取得薪水最高的前五名员工 (如果薪资一样, 则算排名相同)
select name, salary
from employee e1
where (select count(distinct salary) from employee e2 where e2.salary > e1.salary) < 5
order by salary desc;
-- 18、取得薪水最高的第六到第十名员工 (如果薪资一样, 则算排名相同)
select name, salary
from employee e1
where (select count(distinct salary) from employee e2 where e2.salary > e1.salary) between 5 and 9
order by salary desc;
-- 19、取得每个薪资等级有多少员工
select grade, count(*)  num_of_employees
from employee e join salary_grade sg on e.salary between sg.losal and sg.hisal
group by grade;
-- 20、列出受雇日期早于其直接上级的所有员工的编号,姓名,部门名称
select e.id, e.name, d.name  dept_name
from employee e
         join department d on e.dept_id = d.id
         join employee m on e.manager = m.id
where e.hiredate < m.hiredate;
-- 21、列出至少有 4 个员工的部门 , 展示出部门名称, 部门人数
select d.name as dept_name, count(*)  num_of_employees
from department d join employee e on d.id = e.dept_id
group by d.id having count(*) >= 4;
-- 22、列出薪资高于公司平均薪资的 员工姓名,  员工工资, 部门名称, 及员工的工资等级.
select d.name                                   dept_name,
       count(*)                                 num_of_employees,
       avg(e.salary)                            avg_salary,
       avg(datediff(current_date(), hiredate))  avg_hiredate_days
from department d
         join employee e on d.id = e.dept_id
group by d.id;
-- 23、列出在每个部门的 员工数量 , 平均工资 和 平均入职时间(天数).
select d.name                                  dept_name,
       count(*)                                num_of_employees,
       avg(e.salary)                           avg_salary,
       avg(datediff(current_date(), hiredate)) avg_hiredate_days
from department d
         join employee e on d.id = e.dept_id
group by d.id;
-- 24、列出各种工作的最低工资 及 从事此工作的雇员姓名
select t1.job, t1.salary, t1.name
from employee t1,
     (select job, min(salary) minsal from employee group by job) t2
where t1.job = t2.job
  and t1.salary = t2.minsal;
-- 25、列出所有员工的年工资(12个月的薪资 + 12个月的奖金) ,按年薪从高到低排序
-- (提示: null值与任何值运算, 均为null)
select name , (12*salary)+if(comm is null,0,1)*12 '年工资' from employee;