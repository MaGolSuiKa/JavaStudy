-- 创建数据库 dbemp ,编码选择utf8mb4
-- 建立表存储 员工信息表 dongtu_emp（注意设置主键，自动增长，非空）

-- 插入数据 用insert 语句
-- insert into dongtu_emp values(null,'孙悟空','1690-01-09',3000,'花果山',169.2);
-- insert into dongtu_emp values(null,'猪八戒','1720-09-09',5000,'高老庄',200.1);
-- insert into dongtu_emp values(null,'唐僧','1590-01-01',20000,'东土大唐',169.2);
-- insert into dongtu_emp values(null,'猪九戒','2023-09-09',2500,'张家界',175.0);

-- 修改 唐僧 的部门为 大雷音寺 用update语句
-- update dongtu_emp set department = '大雷音寺' where name = '唐僧';

-- 查询 名字中含有 猪的员工
-- select * from dongtu_emp where name like '%猪%';

-- 给入职日期在 2000年后的员工 加1000工资
-- update dongtu_emp set salary = salary+1000 where joindate > '2000-01-01';
 select * from dongtu_emp