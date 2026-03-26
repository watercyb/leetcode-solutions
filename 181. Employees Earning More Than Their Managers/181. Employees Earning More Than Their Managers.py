#
# Problem: 181. Employees Earning More Than Their Managers
# Difficulty: Easy
# Link: https://leetcode.com/problems/employees-earning-more-than-their-managers/
# Language: python3
# Date: 2026-03-26


import pandas as pd

def find_employees(employee: pd.DataFrame) -> pd.DataFrame:
    df=pd.merge(employee, employee, how='inner', left_on='managerId', right_on='id')
    df=df[df['salary_x']>df['salary_y']]
    return df[['name_x']].rename(columns={'name_x': 'Employee'})
