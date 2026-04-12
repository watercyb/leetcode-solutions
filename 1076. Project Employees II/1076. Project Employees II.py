#
# Problem: 1076. Project Employees II
# Difficulty: Easy
# Link: https://leetcode.com/problems/project-employees-ii/
# Language: python3
# Date: 2026-04-12


import pandas as pd

def project_employees_ii(project: pd.DataFrame, employee: pd.DataFrame) -> pd.DataFrame:
    project=project.groupby('project_id')['employee_id'].size().reset_index()
    project=project[project['employee_id']==project['employee_id'].max()]
    return project[['project_id']]
