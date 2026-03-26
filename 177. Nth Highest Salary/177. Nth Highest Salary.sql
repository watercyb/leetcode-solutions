/*
 * Problem: 177. Nth Highest Salary
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/nth-highest-salary/
 * Language: mysql
 * Date: 2026-03-26
 */

CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
    set n=N-1;
    RETURN (
        select distinct salary
        from Employee
        order by salary desc
        limit n, 1
    );
END
