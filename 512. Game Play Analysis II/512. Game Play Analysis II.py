#
# Problem: 512. Game Play Analysis II
# Difficulty: Easy
# Link: https://leetcode.com/problems/game-play-analysis-ii/
# Language: python3
# Date: 2026-04-03


import pandas as pd

def game_analysis(activity: pd.DataFrame) -> pd.DataFrame:
    activity=activity.sort_values(by='event_date')
    activity=activity.groupby('player_id')['device_id'].first().reset_index()
    return activity
