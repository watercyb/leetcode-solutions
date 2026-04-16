#
# Problem: 1303. Find the Team Size
# Difficulty: Easy
# Link: https://leetcode.com/problems/find-the-team-size/
# Language: python3
# Date: 2026-04-16


import pandas as pd

def team_size(employee: pd.DataFrame) -> pd.DataFrame:
    employee['team_size']=employee.groupby('team_id').transform('size')
    return employee[['employee_id', 'team_size']]
