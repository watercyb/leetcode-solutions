#
# Problem: 1532. The Most Recent Three Orders
# Difficulty: Medium
# Link: https://leetcode.com/problems/the-most-recent-three-orders/
# Language: python3
# Date: 2026-04-18


import pandas as pd

def recent_three_orders(customers: pd.DataFrame, orders: pd.DataFrame) -> pd.DataFrame:
    orders=orders.sort_values(by='order_date', ascending=False)
    orders=orders.groupby('customer_id').head(3)
    orders=pd.merge(orders, customers, how='inner', on='customer_id').rename(columns={'name': 'customer_name'})
    return orders[['customer_name', 'customer_id', 'order_id', 'order_date']].sort_values(by=['customer_name', 'customer_id', 'order_date'], ascending=[True, True, False])
