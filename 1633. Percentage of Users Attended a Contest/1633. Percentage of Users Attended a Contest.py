#
# Problem: 1633. Percentage of Users Attended a Contest
# Difficulty: Easy
# Link: https://leetcode.com/problems/percentage-of-users-attended-a-contest/
# Language: python3
# Date: 2026-04-19


import pandas as pd

def users_percentage(users: pd.DataFrame, register: pd.DataFrame) -> pd.DataFrame:
    n=users.shape[0]
    register=register.groupby('contest_id')['user_id'].nunique().reset_index()
    register['percentage']=(register['user_id']/n*100+0.000001).round(2)
    return register[['contest_id', 'percentage']].sort_values(by=['percentage', 'contest_id'], ascending=[False, True])
