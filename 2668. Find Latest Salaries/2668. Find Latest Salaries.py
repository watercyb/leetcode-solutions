#
# Problem: 2668. Find Latest Salaries
# Difficulty: Easy
# Link: https://leetcode.com/problems/find-latest-salaries/
# Language: python3
# Date: 2026-04-29


import pandas as pd

def find_latest_salaries(salary: pd.DataFrame) -> pd.DataFrame:
    salary=salary.sort_values(by=['emp_id', 'salary'], ascending=[True, False])
    salary=salary.groupby('emp_id').first().reset_index()
    return salary
