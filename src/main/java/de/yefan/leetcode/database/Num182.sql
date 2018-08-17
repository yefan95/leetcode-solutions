Create table If Not Exists Person (Id int, Email varchar(255));

insert into Person (Id, Email) values ('1', 'a@b.com');
insert into Person (Id, Email) values ('2', 'c@d.com');
insert into Person (Id, Email) values ('3', 'a@b.com');


select Email from Person group by Email having count(1) > 1;

SELECT Email
FROM Person
GROUP BY Email having COUNT(*) > 1;