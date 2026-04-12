#
# Problem: 1097. Game Play Analysis V
# Difficulty: Hard
# Link: https://leetcode.com/problems/game-play-analysis-v/
# Language: python3
# Date: 2026-04-12


import pandas as pd

def gameplay_analysis(activity: pd.DataFrame) -> pd.DataFrame:
    activity['min']=activity.groupby('player_id')['event_date'].transform('min')
    activity['installs']=activity.apply(lambda x: 1 if x['event_date']==x['min'] else 0, axis=1)
    activity['Day1_retention']=activity.apply(lambda x: 1 if (pd.to_datetime(x['event_date']) - pd.to_datetime(x['min'])).days==1 else 0, axis=1)
    activity=activity.groupby('min').agg({'installs': 'sum', 'Day1_retention': 'sum'}).reset_index(names='install_dt')
    activity['Day1_retention']=(activity['Day1_retention']/activity['installs']+0.000001).round(2)
    return activity
