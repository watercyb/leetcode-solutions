#
# Problem: 1783. Grand Slam Titles
# Difficulty: Medium
# Link: https://leetcode.com/problems/grand-slam-titles/
# Language: python3
# Date: 2026-04-20


import pandas as pd

def grand_slam_titles(players: pd.DataFrame, championships: pd.DataFrame) -> pd.DataFrame:
    df1=pd.merge(players, championships, how='inner', left_on='player_id', right_on='Wimbledon').groupby(['player_id','player_name']).size().reset_index(name='grand_slams_count')
    df2=pd.merge(players, championships, how='inner', left_on='player_id', right_on='Fr_open').groupby(['player_id', 'player_name']).size().reset_index(name='grand_slams_count')
    df3=pd.merge(players, championships, how='inner', left_on='player_id', right_on='US_open').groupby(['player_id', 'player_name']).size().reset_index(name='grand_slams_count')
    df4=pd.merge(players, championships, how='inner', left_on='player_id', right_on='Au_open').groupby(['player_id', 'player_name']).size().reset_index(name='grand_slams_count')
    df=pd.concat([df1, df2, df3, df4]).groupby(['player_id','player_name'])['grand_slams_count'].sum().reset_index()
    return df
