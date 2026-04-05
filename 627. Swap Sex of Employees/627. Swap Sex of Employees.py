#
# Problem: 627. Swap Sex of Employees
# Difficulty: Easy
# Link: https://leetcode.com/problems/swap-sex-of-employees/
# Language: python3
# Date: 2026-04-05


import pandas as pd

def swap_salary(salary: pd.DataFrame) -> pd.DataFrame:
    salary['sex']=salary['sex'].apply(lambda x: 'f' if x=='m' else 'm')
    return salary
