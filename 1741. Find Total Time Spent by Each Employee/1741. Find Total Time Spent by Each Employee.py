#
# Problem: 1741. Find Total Time Spent by Each Employee
# Difficulty: Easy
# Link: https://leetcode.com/problems/find-total-time-spent-by-each-employee/
# Language: python3
# Date: 2026-04-20


import pandas as pd

def total_time(employees: pd.DataFrame) -> pd.DataFrame:
    employees['total_time']=employees['out_time']-employees['in_time']
    employees=employees.groupby(['emp_id', 'event_day'])['total_time'].sum().reset_index()
    return employees[['event_day', 'emp_id', 'total_time']].rename(columns={'event_day': 'day'})
