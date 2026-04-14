#
# Problem: 1141. User Activity for the Past 30 Days I
# Difficulty: Easy
# Link: https://leetcode.com/problems/user-activity-for-the-past-30-days-i/
# Language: python3
# Date: 2026-04-14


import pandas as pd

def user_activity(activity: pd.DataFrame) -> pd.DataFrame:
    activity=activity[(activity['activity_date']>='2019-06-28') & (activity['activity_date']<='2019-07-27')]
    activity=activity.groupby('activity_date')['user_id'].nunique().reset_index()
    return activity.rename(columns={'activity_date': 'day', 'user_id': 'active_users'})
