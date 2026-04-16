#
# Problem: 1378. Replace Employee ID With The Unique Identifier
# Difficulty: Easy
# Link: https://leetcode.com/problems/replace-employee-id-with-the-unique-identifier/
# Language: python3
# Date: 2026-04-16


import pandas as pd

def replace_employee_id(employees: pd.DataFrame, employee_uni: pd.DataFrame) -> pd.DataFrame:
    return pd.merge(employees, employee_uni, how='left', on='id')[['unique_id', 'name']]
