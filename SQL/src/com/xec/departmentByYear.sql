SELECT * from departments

ALTER TABLE employees
  ADD join_year varchar(50);
  
INSERT INTO departments
(department_id, department_name)
VALUES
(101, 'IT');
INSERT INTO departments
(department_id, department_name)
VALUES
(102, 'HR');
INSERT INTO employees
(employee_number, employee_name, department_id,salary,join_year)
VALUES
(10, 'Anderson', 101,1100,2020);
INSERT INTO employees
(employee_number, employee_name, department_id,salary,join_year)
VALUES
(11, 'imran', 101,2200,2019);
INSERT INTO employees
(employee_number, employee_name, department_id,salary,join_year)
VALUES
(12, 'salman', 101,1500,2019);
INSERT INTO employees
(employee_number, employee_name, department_id,salary,join_year)
VALUES
(13, 'Ayesha', 102,800,2020);
INSERT INTO employees
(employee_number, employee_name, department_id,salary,join_year)
VALUES
(14, 'Heena', 102,600,2019);
INSERT INTO employees
(employee_number, employee_name, department_id,salary,join_year)
VALUES
(15, 'Anam', 102,900,2019);



select * from employees;

SELECT COUNT(1) FROM employees GROUP BY join_year ORDER BY join_year;

select * from employees e where e.join_year in 
(SELECT join_year from employees ee where e.employee_number <> ee.employee_number)

SELECT * from employees ee where ee.join_year =top


//final query

  with EmployeeStartFinYear(FinYear, totalEmployee) as (
    select
      top 1 e.join_year,
      COUNT(*)
    from
      employees e
      join departments d on e.department_id = d.department_id
    GROUP by
      e.join_year
    ORDER BY
      e.join_year
  )
  select
    COUNT(e.employee_name),
    d.department_name
  from
    EmployeeStartFinYear
    join employees e on e.join_year = FinYear
    join departments d on e.department_id = d.department_id
  GROUP by
    d.department_name;

    

