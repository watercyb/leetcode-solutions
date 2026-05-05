#
# Problem: 3262. Find Overlapping Shifts
# Difficulty: Medium
# Link: https://leetcode.com/problems/find-overlapping-shifts/
# Language: python3
# Date: 2026-05-05


import pandas as pd

def find_overlapping_shifts(employee_shifts: pd.DataFrame) -> pd.DataFrame:
    df1=employee_shifts[['employee_id', 'start_time']]
    df1['n']=1
    df2=employee_shifts[['employee_id', 'end_time']].rename(columns={'end_time': 'start_time'})
    df2['n']=-1
    df=pd.concat([df1, df2])
    df=df.sort_values(by='start_time')
    df['sum']=df.groupby('employee_id')['n'].cumsum()
    df=df[df['n']==1]
    df=df.groupby('employee_id').agg({'sum': 'sum', 'n': 'size'}).reset_index()
    df['overlapping_shifts']=df['sum']-df['n']
    df=df[df['overlapping_shifts']!=0]
    return df[['employee_id', 'overlapping_shifts']]
