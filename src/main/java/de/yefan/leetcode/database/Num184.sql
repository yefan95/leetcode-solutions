Create table If Not Exists Employees (Id int, Name varchar(255), Salary int, DepartmentId int);
insert into Employees (Id, Name, Salary, DepartmentId) values ('1', 'Joe', '70000', '1');
insert into Employees (Id, Name, Salary, DepartmentId) values ('2', 'Henry', '80000', '2');
insert into Employees (Id, Name, Salary, DepartmentId) values ('3', 'Sam', '60000', '2');
insert into Employees (Id, Name, Salary, DepartmentId) values ('4', 'Max', '90000', '1');
Create table If Not Exists Department (Id int, Name varchar(255));
insert into Department (Id, Name) values ('1', 'IT');
insert into Department (Id, Name) values ('2', 'Sales');



SELECT DepartmentId,max(Salary) as 'Salary'
FROM Employees e
GROUP BY DepartmentId;

SELECT
    Department.name AS 'Department',
    Employee.name AS 'Employee',
    Salary
FROM
    Employee
        JOIN
    Department ON Employee.DepartmentId = Department.Id
WHERE
    (Employee.DepartmentId , Salary) IN
    (   SELECT
            DepartmentId, MAX(Salary)
        FROM
            Employee
        GROUP BY DepartmentId
    )
;