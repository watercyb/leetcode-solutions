#
# Problem: 1264. Page Recommendations
# Difficulty: Medium
# Link: https://leetcode.com/problems/page-recommendations/
# Language: python3
# Date: 2026-04-15


import pandas as pd

def page_recommendations(friendship: pd.DataFrame, likes: pd.DataFrame) -> pd.DataFrame:
    df=pd.concat([friendship[friendship['user1_id']==1][['user2_id']].rename(columns={'user2_id': 'user1_id'}), friendship[friendship['user2_id']==1][['user1_id']]])
    df=df[df['user1_id']!=1].drop_duplicates()
    df=pd.merge(df, likes, how='inner', left_on='user1_id', right_on='user_id')[['page_id']].drop_duplicates()
    df=df[~df['page_id'].isin(likes[likes['user_id']==1]['page_id'])]
    return df.rename(columns={'page_id': 'recommended_page'})
