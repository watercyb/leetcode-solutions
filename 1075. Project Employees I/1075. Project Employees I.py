#
# Problem: 1075. Project Employees I
# Difficulty: Easy
# Link: https://leetcode.com/problems/project-employees-i/
# Language: python3
# Date: 2026-04-12


import pandas as pd

def project_employees_i(project: pd.DataFrame, employee: pd.DataFrame) -> pd.DataFrame:
    project=pd.merge(project, employee, how='inner', on='employee_id')
    project=project.groupby('project_id')['experience_years'].mean().reset_index()
    project['experience_years']=project['experience_years'].round(2)
    return project.rename(columns={'experience_years': 'average_years'})
