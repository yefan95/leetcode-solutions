Create table If Not Exists courses (student varchar(255), class varchar(255));
insert into courses (student, class) values ('A', 'Math');
insert into courses (student, class) values ('B', 'English');
insert into courses (student, class) values ('C', 'Math');
insert into courses (student, class) values ('D', 'Biology');
insert into courses (student, class) values ('E', 'Math');
insert into courses (student, class) values ('F', 'Computer');
insert into courses (student, class) values ('G', 'Math');
insert into courses (student, class) values ('H', 'Math');
insert into courses (student, class) values ('I', 'Math');

-- Using GROUP BY clause and sub-query

SELECT
    class
FROM
    (SELECT
        class, COUNT(DISTINCT student) AS num
    FROM
        courses
    GROUP BY class) AS temp_table
WHERE
    num >= 5
;

--  Using GROUP BY and HAVING condition

SELECT class
FROM courses
GROUP BY class
HAVING COUNT(DISTINCT student,class)>=5;