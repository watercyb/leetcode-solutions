#
# Problem: 2884. Modify Columns
# Difficulty: Easy
# Link: https://leetcode.com/problems/modify-columns/
# Language: python3
# Date: 2026-05-01


import pandas as pd

def modifySalaryColumn(employees: pd.DataFrame) -> pd.DataFrame:
    employees['salary']*=2
    return employees
