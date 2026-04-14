#
# Problem: 1159. Market Analysis II
# Difficulty: Hard
# Link: https://leetcode.com/problems/market-analysis-ii/
# Language: python3
# Date: 2026-04-14


import pandas as pd

def market_analysis(users: pd.DataFrame, orders: pd.DataFrame, items: pd.DataFrame) -> pd.DataFrame:
    orders = orders.sort_values(by='order_date').groupby('seller_id').nth(1)
    users=pd.merge(users, orders, how='left', left_on='user_id', right_on='seller_id')[['user_id', 'favorite_brand', 'item_id']]
    users=pd.merge(users, items, how='left', on='item_id')
    users['2nd_item_fav_brand']=users.apply(lambda x: 'yes' if x['favorite_brand']==x['item_brand'] else 'no', axis=1)
    return users[['user_id', '2nd_item_fav_brand']].rename(columns={'user_id': 'seller_id'})
