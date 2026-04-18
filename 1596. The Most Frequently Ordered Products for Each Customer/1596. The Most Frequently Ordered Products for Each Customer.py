#
# Problem: 1596. The Most Frequently Ordered Products for Each Customer
# Difficulty: Medium
# Link: https://leetcode.com/problems/the-most-frequently-ordered-products-for-each-customer/
# Language: python3
# Date: 2026-04-18


import pandas as pd

def most_frequently_products(customers: pd.DataFrame, orders: pd.DataFrame, products: pd.DataFrame) -> pd.DataFrame:
    orders=orders.groupby(['customer_id', 'product_id']).size().reset_index(name='count')
    orders['max']=orders.groupby('customer_id')['count'].transform('max')
    orders=orders[orders['count']==orders['max']]
    df=pd.merge(customers, orders, how='inner', on='customer_id')
    df=pd.merge(df, products, how='inner', on='product_id')
    return df[['customer_id', 'product_id', 'product_name']]
