#
# Problem: 1077. Project Employees III
# Difficulty: Medium
# Link: https://leetcode.com/problems/project-employees-iii/
# Language: python3
# Date: 2026-04-12


import pandas as pd

def project_employees(project: pd.DataFrame, employee: pd.DataFrame) -> pd.DataFrame:
    employee=pd.merge(project, employee, how='inner', on='employee_id')
    employee['max']=employee.groupby('project_id')['experience_years'].transform('max')
    employee=employee[employee['experience_years']==employee['max']]
    return employee[['project_id', 'employee_id']]
