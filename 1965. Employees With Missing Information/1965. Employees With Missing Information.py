#
# Problem: 1965. Employees With Missing Information
# Difficulty: Easy
# Link: https://leetcode.com/problems/employees-with-missing-information/
# Language: python3
# Date: 2026-04-22


import pandas as pd

def find_employees(employees: pd.DataFrame, salaries: pd.DataFrame) -> pd.DataFrame:
    df=employees.merge(salaries, how='outer', on='employee_id', indicator=True)
    return df[df['_merge']!='both'][['employee_id']]
