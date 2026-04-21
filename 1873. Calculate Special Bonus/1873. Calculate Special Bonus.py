#
# Problem: 1873. Calculate Special Bonus
# Difficulty: Easy
# Link: https://leetcode.com/problems/calculate-special-bonus/
# Language: python3
# Date: 2026-04-21


import pandas as pd

def calculate_special_bonus(employees: pd.DataFrame) -> pd.DataFrame:
    employees['bonus']=employees.apply(
        lambda row: row['salary'] if row['employee_id'] % 2 == 1 and row['name'][0] != 'M' else 0,
        axis=1
    )
    return employees[['employee_id', 'bonus']].sort_values(by='employee_id')
