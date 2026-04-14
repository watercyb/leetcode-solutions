#
# Problem: 1142. User Activity for the Past 30 Days II
# Difficulty: Easy
# Link: https://leetcode.com/problems/user-activity-for-the-past-30-days-ii/
# Language: python3
# Date: 2026-04-14


import pandas as pd

def user_activity(activity: pd.DataFrame) -> pd.DataFrame:
    activity=activity[(activity['activity_date']>='2019-06-28') & (activity['activity_date']<='2019-07-27')]
    activity=activity.groupby('user_id')['session_id'].nunique().reset_index()
    if activity.shape[0]==0:
        return pd.DataFrame({'average_sessions_per_user': [0]})
    return pd.DataFrame({'average_sessions_per_user': [round(activity['session_id'].mean(), 2)]})
