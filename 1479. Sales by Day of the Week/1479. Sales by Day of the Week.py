#
# Problem: 1479. Sales by Day of the Week
# Difficulty: Hard
# Link: https://leetcode.com/problems/sales-by-day-of-the-week/
# Language: python3
# Date: 2026-04-17


import pandas as pd

def sales_by_day(orders: pd.DataFrame, items: pd.DataFrame) -> pd.DataFrame:
    orders['weekday'] = orders['order_date'].dt.day_name()
    orders=pd.merge(orders, items, how='inner', on='item_id')
    df=pd.merge(pd.DataFrame({'weekday': ['Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday', 'Sunday']}), items[['item_category']].drop_duplicates(), how='cross')
    orders=pd.concat([orders, df]).fillna(0)
    orders=orders.groupby(['item_category', 'weekday'])['quantity'].sum().reset_index()
    orders = orders.pivot(index='item_category', columns='weekday', values='quantity').fillna(0).reset_index(names='category')
    return orders[['category', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday', 'Sunday']].sort_values(by='category')

