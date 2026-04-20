#
# Problem: 1789. Primary Department for Each Employee
# Difficulty: Easy
# Link: https://leetcode.com/problems/primary-department-for-each-employee/
# Language: python3
# Date: 2026-04-20


import pandas as pd

def find_primary_department(employee: pd.DataFrame) -> pd.DataFrame:
    employee['rank'] = employee.groupby('employee_id')['primary_flag'].rank(method='min', ascending=False).astype(int)
    return employee[employee['rank']==1][['employee_id', 'department_id']]
