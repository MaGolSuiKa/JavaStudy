-- 查询 所有部门的人数，按降序排列
SELECT 
    dept.dept_name, COUNT(DISTINCT demp.emp_no) AS emp_num,  COUNT(DISTINCT dman.emp_no) AS manager_num
	FROM employees.departments dept
		inner join employees.dept_manager dman ON dept.dept_no = dman.dept_no
        inner join employees.dept_emp demp ON dept.dept_no = demp.dept_no
GROUP BY dept.dept_name
ORDER BY emp_num DESC;

-- 查询某个部门的员工列表
SELECT 
    emp.emp_no,
    dept.dept_name,
    tit.title,
	tit.from_date,
    tit.to_date,
    emp.first_name,
    emp.last_name,
    emp.gender,
    emp.birth_date,
    emp.hire_date
FROM
    employees.dept_emp demp
        INNER JOIN
    employees.departments dept ON demp.dept_no = dept.dept_no
        INNER JOIN
    employees.employees emp ON demp.emp_no = emp.emp_no
        INNER JOIN
    employees.titles tit ON demp.emp_no = tit.emp_no
WHERE
    (demp.dept_no LIKE '%d001%');
    
-- 查询某个部门的管理者
    SELECT 
    emp.emp_no,
    dept.dept_name,
    tit.title,
    tit.from_date,
    tit.to_date,
    emp.first_name,
    emp.last_name,
    emp.gender,
    emp.birth_date,
    emp.hire_date
FROM
    employees.dept_manager dman
        INNER JOIN
    employees.departments dept ON dman.dept_no = dept.dept_no
        INNER JOIN
    employees.employees emp ON dman.emp_no = emp.emp_no
        INNER JOIN
    employees.titles tit ON dman.emp_no = tit.emp_no
WHERE
    (dman.dept_no LIKE '%d003%');