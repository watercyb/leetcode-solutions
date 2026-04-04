#
# Problem: 579. Find Cumulative Salary of an Employee
# Difficulty: Hard
# Link: https://leetcode.com/problems/find-cumulative-salary-of-an-employee/
# Language: python3
# Date: 2026-04-04


import pandas as pd

def cumulative_salary(employee: pd.DataFrame) -> pd.DataFrame:
    employee['a']=employee['month']-1
    employee['b']=employee['month']-2
    df=pd.merge(employee, employee, how='left', left_on=['id', 'a'], right_on=['id', 'month'])
    df=pd.merge(df, employee, how='left', left_on=['id', 'b_x'], right_on=['id', 'month'])
    df=df.fillna(0)
    df['Salary']=df['salary_x']+df['salary_y']+df['salary']
    df=df[['id', 'month_x', 'Salary']].sort_values(by=['id', 'month_x'], ascending=[True, False])
    df = df.groupby('id').apply(lambda g: g.iloc[1:]).reset_index(drop=True)
    return df.rename(columns={'month_x': 'month'})
