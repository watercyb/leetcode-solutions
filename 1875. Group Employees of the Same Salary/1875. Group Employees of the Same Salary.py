#
# Problem: 1875. Group Employees of the Same Salary
# Difficulty: Medium
# Link: https://leetcode.com/problems/group-employees-of-the-same-salary/
# Language: python3
# Date: 2026-04-21


import pandas as pd

def employees_of_same_salary(employees: pd.DataFrame) -> pd.DataFrame:
    df=employees.groupby('salary').size().reset_index()
    df=df[df[0]>1]
    df['team_id']=range(1,len(df)+1)
    df=pd.merge(employees, df, how='inner', on='salary')
    return df[['employee_id', 'name', 'salary', 'team_id']].sort_values(by=['team_id', 'employee_id'])
