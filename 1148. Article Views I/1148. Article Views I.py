#
# Problem: 1148. Article Views I
# Difficulty: Easy
# Link: https://leetcode.com/problems/article-views-i/
# Language: python3
# Date: 2026-04-14


import pandas as pd

def article_views(views: pd.DataFrame) -> pd.DataFrame:
    return views[views['author_id']==views['viewer_id']][['author_id']].drop_duplicates().rename(columns={'author_id': 'id'}).sort_values(by='id', ascending=True)
