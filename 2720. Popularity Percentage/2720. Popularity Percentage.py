#
# Problem: 2720. Popularity Percentage
# Difficulty: Hard
# Link: https://leetcode.com/problems/popularity-percentage/
# Language: python3
# Date: 2026-04-30


import pandas as pd

def popularity_percentage(friends: pd.DataFrame) -> pd.DataFrame:
    friends=pd.concat([friends, friends.rename(columns={'user1': 'user2', 'user2': 'user1'})]).drop_duplicates()
    friends=friends.groupby('user1')['user2'].size().reset_index()
    total=friends[['user1']].drop_duplicates().shape[0]
    friends['percentage_popularity']=(friends['user2']/total*100).round(2)
    return friends[['user1', 'percentage_popularity']].sort_values(by='user1')
