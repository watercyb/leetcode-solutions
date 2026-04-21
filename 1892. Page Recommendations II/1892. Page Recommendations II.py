#
# Problem: 1892. Page Recommendations II
# Difficulty: Hard
# Link: https://leetcode.com/problems/page-recommendations-ii/
# Language: python3
# Date: 2026-04-21


import pandas as pd

def recommend_page(friendship: pd.DataFrame, likes: pd.DataFrame) -> pd.DataFrame:
    friendship=pd.concat([friendship, friendship.rename(columns={'user1_id': 'user2_id', 'user2_id': 'user1_id'})])
    friendship=pd.merge(friendship, likes, how='inner', left_on='user2_id', right_on='user_id')[['user1_id', 'page_id']]
    friendship=pd.merge(friendship, likes, how='left', left_on=['user1_id', 'page_id'], right_on=['user_id', 'page_id'])
    friendship=friendship[friendship['user_id'].isna()][['user1_id', 'page_id']]
    friendship=friendship.groupby(['user1_id', 'page_id']).size().reset_index(name='friends_likes')
    return friendship.rename(columns={'user1_id': 'user_id'})
