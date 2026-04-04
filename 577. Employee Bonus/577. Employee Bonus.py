#
# Problem: 577. Employee Bonus
# Difficulty: Easy
# Link: https://leetcode.com/problems/employee-bonus/
# Language: python3
# Date: 2026-04-04


import pandas as pd

def employee_bonus(employee: pd.DataFrame, bonus: pd.DataFrame) -> pd.DataFrame:
    employee=pd.merge(employee, bonus, how='left', on='empId')
    employee=employee[(employee['bonus']<1000) | (employee['bonus'].isna())]
    return employee[['name', 'bonus']]
