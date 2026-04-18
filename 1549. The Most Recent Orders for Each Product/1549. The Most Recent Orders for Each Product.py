#
# Problem: 1549. The Most Recent Orders for Each Product
# Difficulty: Medium
# Link: https://leetcode.com/problems/the-most-recent-orders-for-each-product/
# Language: python3
# Date: 2026-04-18


import pandas as pd

def most_recent_orders(customers: pd.DataFrame, orders: pd.DataFrame, products: pd.DataFrame) -> pd.DataFrame:
    orders['last']=orders.groupby('product_id')['order_date'].transform('max')
    orders=orders[orders['order_date']==orders['last']]
    orders=pd.merge(orders, products, how='inner', on='product_id')
    return orders[['product_name', 'product_id', 'order_id', 'order_date']].sort_values(by=['product_name', 'product_id', 'order_id'])
