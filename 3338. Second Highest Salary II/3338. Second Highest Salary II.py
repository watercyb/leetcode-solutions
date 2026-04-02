#
# Problem: 3338. Second Highest Salary II
# Difficulty: Medium
# Link: https://leetcode.com/problems/second-highest-salary-ii/?envType=problem-list-v2&envId=ne414q67
# Language: python3
# Date: 2026-04-02


import pandas as pd

def find_second_highest_salary(employees: pd.DataFrame) -> pd.DataFrame:
    employees['r']=employees.groupby('dept')['salary'].rank(method='dense', ascending=False)
    employees=employees[employees['r']==2]
    return employees[['emp_id', 'dept']].sort_values(by='emp_id')
