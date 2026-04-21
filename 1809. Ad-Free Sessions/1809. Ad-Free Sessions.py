#
# Problem: 1809. Ad-Free Sessions
# Difficulty: Easy
# Link: https://leetcode.com/problems/ad-free-sessions/
# Language: python3
# Date: 2026-04-21


import pandas as pd

def ad_free_sessions(playback: pd.DataFrame, ads: pd.DataFrame) -> pd.DataFrame:
    df=pd.merge(playback, ads, how='inner', on='customer_id')
    df=df[(df['start_time']<=df['timestamp']) & (df['end_time']>=df['timestamp'])][['session_id']].drop_duplicates()
    playback=playback[~playback['session_id'].isin(df['session_id'])]
    return playback[['session_id']]
