#
# Problem: 184. Department Highest Salary
# Difficulty: Medium
# Link: https://leetcode.com/problems/department-highest-salary/
# Language: python3
# Date: 2026-03-26


import pandas as pd

def department_highest_salary(employee: pd.DataFrame, department: pd.DataFrame) -> pd.DataFrame:
    employee['max']=employee.groupby('departmentId')['salary'].transform('max')
    employee=employee[employee['salary']==employee['max']]
    df=pd.merge(employee, department, how='inner', left_on='departmentId', right_on='id')
    return df[['name_y', 'name_x', 'salary']].rename(columns={'name_y': 'Department', 'name_x': 'Employee', 'salary': 'Salary'})
