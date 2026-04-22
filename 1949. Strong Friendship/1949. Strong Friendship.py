#
# Problem: 1949. Strong Friendship
# Difficulty: Medium
# Link: https://leetcode.com/problems/strong-friendship/
# Language: python3
# Date: 2026-04-22


import pandas as pd

def strong_friendship(friendship: pd.DataFrame) -> pd.DataFrame:
    friendship=pd.concat([friendship, friendship.rename(columns={'user1_id': 'user2_id', 'user2_id': 'user1_id'})])
    df=pd.merge(friendship, friendship, how='inner', on='user2_id')[['user1_id_x', 'user1_id_y']].rename(columns={'user1_id_x': 'user2_id', 'user1_id_y': 'user1_id'})
    friend_pairs = set(zip(friendship.user1_id, friendship.user2_id))
    df_pairs = list(zip(df.user1_id, df.user2_id))
    df=df[(df['user1_id']!=df['user2_id']) & (df['user1_id']<df['user2_id']) & pd.Series(df_pairs).isin(friend_pairs).values]
    df=df.groupby(['user1_id', 'user2_id']).size().reset_index(name='common_friend')
    df=df[df['common_friend']>=3]
    return df
