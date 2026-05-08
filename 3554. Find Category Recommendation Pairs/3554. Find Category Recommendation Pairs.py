#
# Problem: 3554. Find Category Recommendation Pairs
# Difficulty: Hard
# Link: https://leetcode.com/problems/find-category-recommendation-pairs/
# Language: python3
# Date: 2026-05-08


import pandas as pd

def find_category_recommendation_pairs(product_purchases: pd.DataFrame, product_info: pd.DataFrame) -> pd.DataFrame:
    product_purchases=pd.merge(product_purchases, product_info, how='inner', on='product_id')[['user_id', 'category']].drop_duplicates()
    df=pd.merge(product_purchases, product_purchases, how='inner', on='user_id')
    df=df[df['category_x']<df['category_y']].groupby(['category_x', 'category_y'])['user_id'].size().reset_index(name='customer_count')
    df=df[df['customer_count']>=3].rename(columns={'category_x': 'category1', 'category_y': 'category2'})
    return df.sort_values(by=['customer_count', 'category1', 'category2'], ascending=[False, True, True])
