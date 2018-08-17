Create table If Not Exists seat(id int, student varchar(255));
insert into seat (id, student) values ('1', 'Abbot');
insert into seat (id, student) values ('2', 'Doris');
insert into seat (id, student) values ('3', 'Emerson');
insert into seat (id, student) values ('4', 'Green');
insert into seat (id, student) values ('5', 'Jeames');

SELECT *
FROM seat;

+------+---------+
| id   | student |
+------+---------+
| 1    | Abbot   |
| 2    | Doris   |
| 3    | Emerson |
| 4    | Green   |
| 5    | Jeames  |
+------+---------+

--  Using flow control statement CASE


SELECT
    COUNT(*) AS counts
FROM
    seat;

+--------+
| counts |
+--------+
| 5      |
+--------+


SELECT
    (CASE
        WHEN MOD(id, 2) != 0 AND counts != id THEN id + 1
        WHEN MOD(id, 2) != 0 AND counts = id THEN id
        ELSE id - 1
    END) AS id,
    student
FROM
    seat,
    (SELECT
        COUNT(*) AS counts
    FROM
        seat) AS seat_counts
ORDER BY id ASC;

+------+---------+
| id   | student |
+------+---------+
| 1    | Doris   |
| 2    | Abbot   |
| 3    | Green   |
| 4    | Emerson |
| 5    | Jeames  |
+------+---------+

-- Using bit manipulation and COALESCE()

SELECT id, (id+1)^1-1, student FROM seat;

+------+------------+---------+
| id   | (id+1)^1-1 | student |
+------+------------+---------+
| 1    | 2          | Abbot   |
| 2    | 1          | Doris   |
| 3    | 4          | Emerson |
| 4    | 3          | Green   |
| 5    | 6          | Jeames  |
+------+------------+---------+

SELECT
    *
FROM
    seat s1
        LEFT JOIN
    seat s2 ON (s1.id+1)^1-1 = s2.id
ORDER BY s1.id;

+------+---------+-------+------------+
| id   | student | id(2) | student(2) |
+------+---------+-------+------------+
| 1    | Abbot   | 2     | Doris      |
| 2    | Doris   | 1     | Abbot      |
| 3    | Emerson | 4     | Green      |
| 4    | Green   | 3     | Emerson    |
| 5    | Jeames  | NULL  | NULL       |
+------+---------+-------+------------+

SELECT
    s1.id, COALESCE(s2.student, s1.student) AS student
FROM
    seat s1
        LEFT JOIN
    seat s2 ON ((s1.id + 1) ^ 1) - 1 = s2.id
ORDER BY s1.id;

+------+---------+
| id   | student |
+------+---------+
| 1    | Doris   |
| 2    | Abbot   |
| 3    | Green   |
| 4    | Emerson |
| 5    | Jeames  |
+------+---------+
