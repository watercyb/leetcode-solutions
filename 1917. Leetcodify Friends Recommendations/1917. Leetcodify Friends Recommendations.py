#
# Problem: 1917. Leetcodify Friends Recommendations
# Difficulty: Hard
# Link: https://leetcode.com/problems/leetcodify-friends-recommendations/
# Language: python3
# Date: 2026-04-22


import pandas as pd

def recommend_friends(listens: pd.DataFrame, friendship: pd.DataFrame) -> pd.DataFrame:
    listens=pd.merge(listens, listens, how='inner', on=['song_id', 'day'])
    listens=listens.groupby(['user_id_x', 'user_id_y', 'day'])['song_id'].nunique().reset_index()
    listens=listens[(listens['song_id']>=3) & (listens['user_id_x']!=listens['user_id_y'])]
    listens=listens[['user_id_x', 'user_id_y']].drop_duplicates()
    df=pd.concat([friendship, friendship.rename(columns={'user1_id': 'user2_id', 'user2_id': 'user1_id'})])
    listens=pd.merge(listens, df, how='left', left_on=['user_id_x', 'user_id_y'], right_on=['user1_id', 'user2_id'])
    listens=listens[listens['user1_id'].isna()]
    return listens[['user_id_x', 'user_id_y']].rename(columns={'user_id_x': 'user_id', 'user_id_y': 'recommended_id'}).drop_duplicates()

