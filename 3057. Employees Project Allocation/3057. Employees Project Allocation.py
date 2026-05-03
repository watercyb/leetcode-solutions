#
# Problem: 3057. Employees Project Allocation
# Difficulty: Hard
# Link: https://leetcode.com/problems/employees-project-allocation/
# Language: python3
# Date: 2026-05-03


import pandas as pd

def employees_with_above_avg_workload(project: pd.DataFrame, employees: pd.DataFrame) -> pd.DataFrame:
    project=pd.merge(project, employees, how='inner', on='employee_id')
    project['avg']=project.groupby('team')['workload'].transform('mean')
    project=project[project['workload']>project['avg']]
    return project[['employee_id', 'project_id', 'name', 'workload']].rename(columns={'project_id': 'PROJECT_ID', 'employee_id': 'EMPLOYEE_ID', 'workload': 'PROJECT_WORKLOAD', 'name': 'EMPLOYEE_NAME'}).sort_values(by=['EMPLOYEE_ID', 'PROJECT_ID'])
