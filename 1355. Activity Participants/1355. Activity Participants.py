#
# Problem: 1355. Activity Participants
# Difficulty: Medium
# Link: https://leetcode.com/problems/activity-participants/
# Language: python3
# Date: 2026-04-16


import pandas as pd

def activity_participants(friends: pd.DataFrame, activities: pd.DataFrame) -> pd.DataFrame:
    friends=friends.groupby(['activity']).size().reset_index(name='count')
    activities=pd.merge(activities, friends, how='left', left_on='name', right_on='activity').fillna(0)
    activities=activities[~(activities['count']==activities['count'].max())]
    activities=activities[~(activities['count']==activities['count'].min())]
    return activities[['activity']]
