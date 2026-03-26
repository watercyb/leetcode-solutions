#
# Problem: 185. Department Top Three Salaries
# Difficulty: Hard
# Link: https://leetcode.com/problems/department-top-three-salaries/
# Language: python3
# Date: 2026-03-26


import pandas as pd

def top_three_salaries(employee: pd.DataFrame, department: pd.DataFrame) -> pd.DataFrame:
    employee['rnk']=employee.groupby('departmentId')['salary'].rank(method='dense', ascending=False)
    employee=employee[employee['rnk']<=3]
    employee=pd.merge(employee, department, how='inner', left_on='departmentId', right_on='id')[['name_y', 'name_x', 'salary']].rename(columns={'name_y': 'Department', 'name_x': 'Employee', 'salary': 'Salary'})
    return employee
