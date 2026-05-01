#
# Problem: 2893. Calculate Orders Within Each Interval
# Difficulty: Medium
# Link: https://leetcode.com/problems/calculate-orders-within-each-interval/
# Language: python3
# Date: 2026-05-01


import pandas as pd

def calculate_runs(orders: pd.DataFrame) -> pd.DataFrame:
    orders['interval_no']=(orders['minute']+5)//6
    orders=orders.groupby('interval_no')['order_count'].sum().reset_index(name='total_orders')
    return orders.sort_values(by='interval_no')
