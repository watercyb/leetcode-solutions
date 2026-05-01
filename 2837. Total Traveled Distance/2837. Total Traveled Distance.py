#
# Problem: 2837. Total Traveled Distance
# Difficulty: Easy
# Link: https://leetcode.com/problems/total-traveled-distance/
# Language: python3
# Date: 2026-05-01


import pandas as pd

def get_total_distance(users: pd.DataFrame, rides: pd.DataFrame) -> pd.DataFrame:
    return users.merge(rides.groupby('user_id')['distance'].sum().reset_index(), how='left', on='user_id').fillna(0).rename(columns={'distance': 'traveled distance'}).sort_values(by='user_id', ascending=True) 
