#
# Problem: 1565. Unique Orders and Customers Per Month
# Difficulty: Easy
# Link: https://leetcode.com/problems/unique-orders-and-customers-per-month/
# Language: python3
# Date: 2026-04-18


import pandas as pd

def unique_orders_and_customers(orders: pd.DataFrame) -> pd.DataFrame:
    orders = orders[orders['invoice'] > 20]
    orders['month'] = orders['order_date'].dt.strftime('%Y-%m')
    return orders.groupby('month').agg(
        order_count=('order_id', 'nunique'),
        customer_count=('customer_id', 'nunique')
    ).reset_index()
