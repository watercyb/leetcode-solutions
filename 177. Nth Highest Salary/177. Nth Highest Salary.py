#
# Problem: 177. Nth Highest Salary
# Difficulty: Medium
# Link: https://leetcode.com/problems/nth-highest-salary/
# Language: python3
# Date: 2026-03-26


import pandas as pd

def nth_highest_salary(employee: pd.DataFrame, N: int) -> pd.DataFrame:
    if N<=0:
        return pd.DataFrame({'getNthHighestSalary('+str(N)+')': [None]})
    employee=employee.sort_values(by='salary', ascending=False)[['salary']].drop_duplicates()
    if employee.shape[0]<N:
        return pd.DataFrame({'getNthHighestSalary('+str(N)+')': [None]})
    return pd.DataFrame({'getNthHighestSalary('+str(N)+')': [employee['salary'].iloc[N-1]]})
