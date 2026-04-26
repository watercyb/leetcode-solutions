#
# Problem: 2394. Employees With Deductions
# Difficulty: Medium
# Link: https://leetcode.com/problems/employees-with-deductions/
# Language: python3
# Date: 2026-04-26


import pandas as pd

def employees_with_deductions(employees: pd.DataFrame, logs: pd.DataFrame) -> pd.DataFrame:
    logs['mins']=numpy.ceil((logs['out_time'] - logs['in_time']).dt.total_seconds() / 60)
    logs=logs.groupby('employee_id')['mins'].sum().reset_index()
    employees=pd.merge(employees, logs, how='left', on='employee_id').fillna(0)
    employees=employees[employees['needed_hours']*60>employees['mins']]
    return employees[['employee_id']]

