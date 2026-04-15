#
# Problem: 1270. All People Report to the Given Manager
# Difficulty: Medium
# Link: https://leetcode.com/problems/all-people-report-to-the-given-manager/
# Language: python3
# Date: 2026-04-15


import pandas as pd

def find_reporting_people(employees: pd.DataFrame) -> pd.DataFrame:
    df=pd.merge(employees, employees, how='inner', left_on='manager_id', right_on='employee_id')
    df=pd.merge(df, employees, how='inner', left_on='manager_id_y', right_on='employee_id')
    df=pd.merge(df[['employee_id_x', 'manager_id']], employees, how='inner', left_on='manager_id', right_on='employee_id')
    df=df[(df['employee_id_x']!=1) & (df['manager_id_y']==1)]
    return df[['employee_id_x']].rename(columns={'employee_id_x': 'employee_id'})
