#
# Problem: 2084. Drop Type 1 Orders for Customers With Type 0 Orders
# Difficulty: Medium
# Link: https://leetcode.com/problems/drop-type-1-orders-for-customers-with-type-0-orders/
# Language: python3
# Date: 2026-04-23


import pandas as pd

def drop_specific_orders(orders: pd.DataFrame) -> pd.DataFrame:
    orders['min']=orders.groupby(['customer_id'])['order_type'].transform('min')
    orders=orders[orders['order_type']==orders['min']]
    return orders[['order_id', 'customer_id', 'order_type']]
