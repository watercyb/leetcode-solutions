#
# Problem: 1327. List the Products Ordered in a Period
# Difficulty: Easy
# Link: https://leetcode.com/problems/list-the-products-ordered-in-a-period/
# Language: python3
# Date: 2026-04-16


import pandas as pd

def list_products(products: pd.DataFrame, orders: pd.DataFrame) -> pd.DataFrame:
    orders=orders[orders['order_date'].dt.strftime('%Y-%m')=='2020-02']
    orders=orders.groupby('product_id').sum('unit').reset_index()
    orders=orders[orders['unit']>=100]
    return orders.merge(products, how='inner', on='product_id')[['product_name','unit']]
