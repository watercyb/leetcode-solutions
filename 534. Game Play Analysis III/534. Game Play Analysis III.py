#
# Problem: 534. Game Play Analysis III
# Difficulty: Medium
# Link: https://leetcode.com/problems/game-play-analysis-iii/
# Language: python3
# Date: 2026-04-03


import pandas as pd

def gameplay_analysis(activity: pd.DataFrame) -> pd.DataFrame:
    activity = activity.sort_values(['player_id', 'event_date'])
    activity['games_played_so_far'] = activity.groupby('player_id')['games_played'].cumsum()
    return activity[['player_id', 'event_date', 'games_played_so_far']]
