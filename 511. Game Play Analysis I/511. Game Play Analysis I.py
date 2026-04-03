#
# Problem: 511. Game Play Analysis I
# Difficulty: Easy
# Link: https://leetcode.com/problems/game-play-analysis-i/
# Language: python3
# Date: 2026-04-03


import pandas as pd

def game_analysis(activity: pd.DataFrame) -> pd.DataFrame:
    return activity.groupby('player_id')['event_date'].min().reset_index().rename(columns={'event_date': "first_login"})
