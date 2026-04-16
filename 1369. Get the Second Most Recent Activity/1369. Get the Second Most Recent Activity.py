#
# Problem: 1369. Get the Second Most Recent Activity
# Difficulty: Hard
# Link: https://leetcode.com/problems/get-the-second-most-recent-activity/
# Language: python3
# Date: 2026-04-16


import pandas as pd

def second_most_recent(user_activity: pd.DataFrame) -> pd.DataFrame:
    user_activity=user_activity.sort_values(by='startDate')
    user_activity=user_activity.groupby('username').tail(2)
    user_activity=user_activity.groupby('username').first().reset_index()
    return user_activity
