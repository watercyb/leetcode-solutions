#
# Problem: 176. Second Highest Salary
# Difficulty: Medium
# Link: https://leetcode.com/problems/second-highest-salary/
# Language: python3
# Date: 2026-03-26


import pandas as pd

def second_highest_salary(employee: pd.DataFrame) -> pd.DataFrame:
    employee=employee[['salary']].drop_duplicates().sort_values(by='salary', ascending=False)
    if  len(employee) < 2:
        return pd.DataFrame({"SecondHighestSalary": [None]})
    else:
        return pd.DataFrame({'SecondHighestSalary': employee.iloc[1]})
