#
# Problem: 1919. Leetcodify Similar Friends
# Difficulty: Hard
# Link: https://leetcode.com/problems/leetcodify-similar-friends/
# Language: python3
# Date: 2026-04-22


import pandas as pd

def leetcodify_similar_friends(listens: pd.DataFrame, friendship: pd.DataFrame) -> pd.DataFrame:
    listens=pd.merge(listens, listens, how='inner', on=['song_id', 'day'])
    listens=listens[listens['user_id_x']<listens['user_id_y']]
    listens=listens.groupby(['user_id_x', 'user_id_y', 'day'])['song_id'].nunique().reset_index()
    listens=listens[listens['song_id']>=3]
    listens=pd.merge(listens, friendship, how='inner', left_on=['user_id_x', 'user_id_y'], right_on=['user1_id', 'user2_id'])
    return listens[['user1_id', 'user2_id']].drop_duplicates()
