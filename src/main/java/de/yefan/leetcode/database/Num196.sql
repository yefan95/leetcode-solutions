SELECT p1.*
FROM Person p1,Person p2
WHERE p1.Email = p2.Email
AND p1.Id > p2.Id;

DELETE p1
FROM Person p1,Person p2
WHERE p1.Email = p2.Email
AND p1.Id > p2.Id;

DELETE FROM Person WHERE Id NOT IN (
    SELECT * FROM (
        SELECT min(Id) from Person GROUP BY Email
    ) AS tmp
);