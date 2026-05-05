#
# Problem: 3268. Find Overlapping Shifts II
# Difficulty: Hard
# Link: https://leetcode.com/problems/find-overlapping-shifts-ii/
# Language: python3
# Date: 2026-05-05


import pandas as pd

def calculate_shift_overlaps(employee_shifts: pd.DataFrame) -> pd.DataFrame:
    employee_shifts=employee_shifts.sort_values(by='start_time')
    employee_shifts['r'] = employee_shifts.groupby('employee_id').cumcount() + 1
    employee_shifts=pd.merge(employee_shifts, employee_shifts, how='inner', on='employee_id')
    employee_shifts=employee_shifts[(employee_shifts['r_x']<=employee_shifts['r_y']) & (employee_shifts['end_time_x']>employee_shifts['start_time_y'])]
    employee_shifts['total_overlap_duration']=employee_shifts.apply(lambda row: (row['end_time_x']-row['start_time_y']).total_seconds()//60 if row['r_x']!=row['r_y'] else 0, axis=1)
    employee_shifts['max_overlapping_shifts']=employee_shifts['r_y']-employee_shifts['r_x']
    employee_shifts=employee_shifts.groupby('employee_id').agg({'max_overlapping_shifts': 'max', 'total_overlap_duration': 'sum'}).reset_index()
    employee_shifts['max_overlapping_shifts']=employee_shifts['max_overlapping_shifts']+1
    return employee_shifts
