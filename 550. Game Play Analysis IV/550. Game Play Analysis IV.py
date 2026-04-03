#
# Problem: 550. Game Play Analysis IV
# Difficulty: Medium
# Link: https://leetcode.com/problems/game-play-analysis-iv/
# Language: python3
# Date: 2026-04-03


import pandas as pd

def gameplay_analysis(activity: pd.DataFrame) -> pd.DataFrame:
    activity['min']=activity.groupby('player_id')['event_date'].transform('min')
    a=activity[(activity['event_date']-activity['min']).dt.days==1].shape[0]
    b=activity[['player_id']].drop_duplicates().shape[0]
    return pd.DataFrame({'fraction':[round(a/b,2)]})
