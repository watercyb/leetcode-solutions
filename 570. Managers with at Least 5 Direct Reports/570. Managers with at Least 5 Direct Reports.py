#
# Problem: 570. Managers with at Least 5 Direct Reports
# Difficulty: Medium
# Link: https://leetcode.com/problems/managers-with-at-least-5-direct-reports/
# Language: python3
# Date: 2026-04-04


import pandas as pd

def find_managers(employee: pd.DataFrame) -> pd.DataFrame:
    df=employee.groupby('managerId').size().reset_index(name='cnt')
    df=df[df['cnt']>=5]
    df=pd.merge(employee, df, how='inner', left_on='id', right_on='managerId')
    return df[['name']]
