#
# Problem: 3056. Snaps Analysis
# Difficulty: Medium
# Link: https://leetcode.com/problems/snaps-analysis/
# Language: python3
# Date: 2026-05-03


import pandas as pd

def snap_analysis(activities: pd.DataFrame, age: pd.DataFrame) -> pd.DataFrame:
    activities=pd.merge(activities, age, how='inner', on='user_id')
    activities=activities.groupby(['age_bucket', 'activity_type'])['time_spent'].sum().reset_index()
    activities['total']=activities.groupby(['age_bucket'])['time_spent'].transform('sum')
    activities['p']=(activities['time_spent']/activities['total']*100).round(2)
    activities=pd.merge(activities[activities['activity_type']=='send'], activities[activities['activity_type']=='open'], how='outer', on='age_bucket').fillna(0)
    return activities[['age_bucket', 'p_x', 'p_y']].rename(columns={'p_x': 'send_perc', 'p_y': 'open_perc'})
