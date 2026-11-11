# Write your MySQL query statement below

-- Using Subquery

SELECT name
FROM Employee
WHERE id IN(
    SELECT managerId 
    FROM Employee
    GROUP BY managerId
    HAVING COUNT(*) >= 5
);

/*
-- Using JOIN

SELECT a.name
FROM Employee a
LEFT JOIN Employee b
    ON a.id = b.managerId
GROUP BY a.id, a.name
HAVING COUNT(b.id) >= 5;
*/