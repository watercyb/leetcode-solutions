#
# Problem: 1149. Article Views II
# Difficulty: Medium
# Link: https://leetcode.com/problems/article-views-ii/?envType=problem-list-v2&envId=ne414q67
# Language: python3
# Date: 2026-04-09


import pandas as pd

def article_views(views: pd.DataFrame) -> pd.DataFrame:
    views=views.groupby(['viewer_id', 'view_date'])['article_id'].nunique().reset_index()
    views=views[views['article_id']>=2]
    return views[['viewer_id']].drop_duplicates().rename(columns={'viewer_id': 'id'}).sort_values(by='id')
