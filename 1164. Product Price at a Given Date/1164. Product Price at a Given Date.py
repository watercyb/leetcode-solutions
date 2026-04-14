#
# Problem: 1164. Product Price at a Given Date
# Difficulty: Medium
# Link: https://leetcode.com/problems/product-price-at-a-given-date/
# Language: python3
# Date: 2026-04-14


import pandas as pd

def price_at_given_date(products: pd.DataFrame) -> pd.DataFrame:
    df=products[products['change_date']<='2019-08-16']
    df=df.sort_values(by=['change_date', 'product_id'], ascending=[False, True])
    df=df.drop_duplicates('product_id', keep='first')[['product_id', 'new_price']]
    df=pd.merge(products[['product_id']].drop_duplicates('product_id'), df, how='left', on='product_id').fillna(10).rename(columns={'new_price': 'price'})
    return df
