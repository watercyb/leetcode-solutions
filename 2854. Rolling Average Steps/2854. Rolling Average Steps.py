#
# Problem: 2854. Rolling Average Steps
# Difficulty: Medium
# Link: https://leetcode.com/problems/rolling-average-steps/
# Language: python3
# Date: 2026-05-01


import pandas as pd

def rolling_average(steps: pd.DataFrame) -> pd.DataFrame:
    steps=steps.sort_values(by=['user_id', 'steps_date'])
    steps['prv_id']=steps['user_id'].shift(2)
    steps['prv_date']=steps['steps_date'].shift(2)
    steps['rolling_average']=((steps['steps_count']+steps['steps_count'].shift(1)+steps['steps_count'].shift(2))/3).round(2)
    steps=steps[(~steps['prv_id'].isna()) & (steps['prv_id']==steps['user_id']) & (steps['steps_date']==steps['prv_date']+pd.Timedelta(days=2))]
    return steps[['user_id', 'steps_date', 'rolling_average']]
