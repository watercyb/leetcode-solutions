#
# Problem: 1398. Customers Who Bought Products A and B but Not C
# Difficulty: Medium
# Link: https://leetcode.com/problems/customers-who-bought-products-a-and-b-but-not-c/
# Language: python3
# Date: 2026-04-16


import pandas as pd

def find_customers(customers: pd.DataFrame, orders: pd.DataFrame) -> pd.DataFrame:
    orders['type']=orders['product_name'].apply(lambda x: 4 if x=='A' else 2 if x=='B' else 1 if x=='C' else 0)
    orders=orders.groupby('customer_id')['type'].apply(lambda x: reduce(operator.or_, x)).reset_index()
    orders=orders[orders['type']==6]
    customers=pd.merge(customers, orders, how='inner', on='customer_id')
    return customers[['customer_id', 'customer_name']].sort_values(by='customer_id')
