#
# Problem: 1407. Top Travellers
# Difficulty: Easy
# Link: https://leetcode.com/problems/top-travellers/
# Language: python3
# Date: 2026-04-17


import pandas as pd

def top_travellers(users: pd.DataFrame, rides: pd.DataFrame) -> pd.DataFrame:
    df=pd.merge(users, rides, how='left', left_on='id', right_on='user_id').groupby('id_x').agg(name=('name', 'first'), travelled_distance=('distance', 'sum')).reset_index()
    df=df[['name', 'travelled_distance']].sort_values(by=['travelled_distance', 'name'], ascending=[False, True])
    return df
