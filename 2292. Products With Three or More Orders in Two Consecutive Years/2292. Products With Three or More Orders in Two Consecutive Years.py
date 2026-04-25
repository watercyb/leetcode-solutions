#
# Problem: 2292. Products With Three or More Orders in Two Consecutive Years
# Difficulty: Medium
# Link: https://leetcode.com/problems/products-with-three-or-more-orders-in-two-consecutive-years/
# Language: python3
# Date: 2026-04-25


import pandas as pd

def find_valid_products(orders: pd.DataFrame) -> pd.DataFrame:
    orders['purchase_date']=orders['purchase_date'].dt.year
    orders=orders.groupby(['product_id', 'purchase_date']).size().reset_index(name='count')
    orders=orders[orders['count']>=3]
    orders=orders.sort_values(by=['product_id', 'purchase_date'])
    orders['prv_date']=orders['purchase_date'].shift(1)
    orders['prv_id']=orders['product_id'].shift(1)
    orders=orders[~orders['prv_date'].isna()]
    orders=orders[orders['purchase_date']-1==orders['prv_date']]
    orders=orders[orders['product_id']==orders['prv_id']]
    return orders[['product_id']].drop_duplicates()
