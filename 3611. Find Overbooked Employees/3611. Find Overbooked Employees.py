#
# Problem: 3611. Find Overbooked Employees
# Difficulty: Medium
# Link: https://leetcode.com/problems/find-overbooked-employees/
# Language: python3
# Date: 2026-05-09


import pandas as pd

def find_overbooked_employees(employees: pd.DataFrame, meetings: pd.DataFrame) -> pd.DataFrame:
    meetings=meetings.groupby(['employee_id', meetings['meeting_date'].dt.isocalendar().week, meetings['meeting_date'].dt.isocalendar().year])['duration_hours'].sum().reset_index()
    meetings=meetings[meetings['duration_hours']>20]
    meetings=meetings.groupby('employee_id').size().reset_index(name='meeting_heavy_weeks')
    meetings=meetings[meetings['meeting_heavy_weeks']>=2]
    df=pd.merge(employees, meetings, how='inner', on='employee_id').sort_values(by=['meeting_heavy_weeks', 'employee_name'], ascending=[False, True])
    return df
