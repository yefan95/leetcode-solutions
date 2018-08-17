Create table If Not Exists Employee (Id int, Name varchar(255), Salary int, ManagerId int);
insert into Employee (Id, Name, Salary, ManagerId) values ('1', 'Joe', '70000', '3');
insert into Employee (Id, Name, Salary, ManagerId) values ('2', 'Henry', '80000', '4');
insert into Employee (Id, Name, Salary, ManagerId) values ('3', 'Sam', '60000', NULL );
insert into Employee (Id, Name, Salary, ManagerId) values ('4', 'Max', '90000', NULL );

SELECT a.Name AS 'Employee'
FROM Employee as a,Employee as b
WHERE a.ManagerId = b.Id
AND a.Salary > b.Salary;


SELECT
     a.NAME AS Employee
FROM Employee AS a JOIN Employee AS b
     ON a.ManagerId = b.Id
     AND a.Salary > b.Salary
;