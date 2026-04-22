#
# Problem: 1951. All the Pairs With the Maximum Number of Common Followers
# Difficulty: Medium
# Link: https://leetcode.com/problems/all-the-pairs-with-the-maximum-number-of-common-followers/
# Language: python3
# Date: 2026-04-22


import pandas as pd

def find_pairs(relations: pd.DataFrame) -> pd.DataFrame:
    relations=pd.merge(relations, relations, how='inner', on='follower_id')
    relations=relations[relations['user_id_x']<relations['user_id_y']]
    relations=relations.groupby(['user_id_x', 'user_id_y']).size().reset_index(name='count')
    relations=relations[relations['count']==relations['count'].max()]
    return relations.rename(columns={'user_id_x': 'user1_id', 'user_id_y': 'user2_id'})[['user1_id', 'user2_id']]
