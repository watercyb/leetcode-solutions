#
# Problem: 1241. Number of Comments per Post
# Difficulty: Easy
# Link: https://leetcode.com/problems/number-of-comments-per-post/
# Language: python3
# Date: 2026-04-15


import pandas as pd

def count_comments(submissions: pd.DataFrame) -> pd.DataFrame:
    df=pd.merge(submissions[submissions['parent_id'].isna()].drop_duplicates(), submissions[~submissions['parent_id'].isna()].drop_duplicates(), how='left', left_on='sub_id', right_on='parent_id')
    df['cnt']=df['sub_id_y'].notna().astype(int)
    df=df.groupby('sub_id_x')['cnt'].sum().reset_index(name='number_of_comments')
    return df.rename(columns={'sub_id_x': 'post_id'}).sort_values(by='post_id')
