#
# Problem: 1867. Orders With Maximum Quantity Above Average
# Difficulty: Medium
# Link: https://leetcode.com/problems/orders-with-maximum-quantity-above-average/
# Language: python3
# Date: 2026-04-21


import pandas as pd

def orders_above_average(orders_details: pd.DataFrame) -> pd.DataFrame:
    max_avg=orders_details.groupby('order_id')['quantity'].mean().max()
    orders_details=orders_details.groupby('order_id')['quantity'].max().reset_index()
    orders_details=orders_details[orders_details['quantity']>max_avg]
    return orders_details[['order_id']]
