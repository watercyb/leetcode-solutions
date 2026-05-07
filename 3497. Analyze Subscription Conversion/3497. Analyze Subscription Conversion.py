#
# Problem: 3497. Analyze Subscription Conversion
# Difficulty: Medium
# Link: https://leetcode.com/problems/analyze-subscription-conversion/
# Language: python3
# Date: 2026-05-07


import pandas as pd

def analyze_subscription_conversion(user_activity: pd.DataFrame) -> pd.DataFrame:
    user_activity=user_activity[user_activity['user_id'].isin(user_activity[user_activity['activity_type']=='paid']['user_id'])]
    df1=user_activity[user_activity['activity_type']=='free_trial'].groupby(['user_id'])['activity_duration'].mean().reset_index()
    df2=user_activity[user_activity['activity_type']=='paid'].groupby(['user_id'])['activity_duration'].mean().reset_index()
    df=pd.merge(df1, df2, how='left', on='user_id')
    df['trial_avg_duration']=(df['activity_duration_x']+0.000001).round(2)
    df['paid_avg_duration']=(df['activity_duration_y']+0.000001).round(2)
    return df[['user_id', 'trial_avg_duration', 'paid_avg_duration']].sort_values(by='user_id', ascending=True)
