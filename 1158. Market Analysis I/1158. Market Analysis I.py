#
# Problem: 1158. Market Analysis I
# Difficulty: Medium
# Link: https://leetcode.com/problems/market-analysis-i/
# Language: python3
# Date: 2026-04-14


import pandas as pd

def market_analysis(users: pd.DataFrame, orders: pd.DataFrame, items: pd.DataFrame) -> pd.DataFrame:
    orders=orders[orders['order_date'].dt.year==2019]
    orders=orders.groupby('buyer_id')['order_id'].count().reset_index(name='orders_in_2019')
    users=pd.merge(users, orders, how='left', left_on='user_id', right_on='buyer_id')
    return users[['user_id', 'join_date', 'orders_in_2019']].rename(columns={'user_id': 'buyer_id'}).fillna(0)
