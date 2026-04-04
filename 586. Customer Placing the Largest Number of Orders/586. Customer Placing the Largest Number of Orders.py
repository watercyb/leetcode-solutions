#
# Problem: 586. Customer Placing the Largest Number of Orders
# Difficulty: Easy
# Link: https://leetcode.com/problems/customer-placing-the-largest-number-of-orders/
# Language: python3
# Date: 2026-04-04


import pandas as pd

def largest_orders(orders: pd.DataFrame) -> pd.DataFrame:
    if orders.shape[0]==0:
        return pd.DataFrame({'customer_number': []})
    orders=orders.groupby('customer_number').size().reset_index(name='count').sort_values(by='count', ascending=False)
    return pd.DataFrame({'customer_number': [orders['customer_number'].iloc[0]]})
