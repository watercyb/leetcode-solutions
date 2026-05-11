#
# Problem: 3808. Find Emotionally Consistent Users
# Difficulty: Medium
# Link: https://leetcode.com/problems/find-emotionally-consistent-users/
# Language: python3
# Date: 2026-05-11


import pandas as pd

def find_emotionally_consistent_users(reactions: pd.DataFrame) -> pd.DataFrame:
    reactions['count']=reactions.groupby('user_id')['content_id'].transform('nunique')
    reactions=reactions[reactions['count']>=5]
    reactions=reactions.groupby(['user_id', 'reaction']).size().reset_index(name='count')
    reactions['sum']=reactions.groupby('user_id')['count'].transform('sum')
    reactions['reaction_ratio']=(reactions['count']/reactions['sum']+0.000001).round(2)
    reactions=reactions[reactions['reaction_ratio']>=0.6]
    return reactions[['user_id', 'reaction', 'reaction_ratio']].rename(columns={'reaction': 'dominant_reaction'}).sort_values(by=['reaction_ratio', 'user_id'], ascending=[False, True])
