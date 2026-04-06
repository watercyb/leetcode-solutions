#
# Problem: 690. Employee Importance
# Difficulty: Medium
# Link: https://leetcode.com/problems/employee-importance/
# Language: python3
# Date: 2026-04-06


"""
# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates
"""


class Solution:
    def getImportance(self, employees: List["Employee"], id: int) -> int:
        indexes = [0] * 2001
        for i in range(len(employees)):
            indexes[employees[i].id] = i

        def dfs(i: int) -> int:
            res = employees[indexes[i]].importance
            for subordinate in employees[indexes[i]].subordinates:
                res += dfs(subordinate)
            return res

        return dfs(id)

