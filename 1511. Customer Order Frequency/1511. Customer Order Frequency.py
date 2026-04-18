#
# Problem: 1511. Customer Order Frequency
# Difficulty: Easy
# Link: https://leetcode.com/problems/customer-order-frequency/
# Language: python3
# Date: 2026-04-18


import pandas as pd

def customer_order_frequency(customers: pd.DataFrame, product: pd.DataFrame, orders: pd.DataFrame) -> pd.DataFrame:
    orders['date']=orders['order_date'].dt.strftime('%m-%Y')
    orders=orders[(orders['date']=='06-2020') | (orders['date']=='07-2020')]
    orders=pd.merge(orders, product, how='inner', on='product_id')
    orders['price']=orders['quantity']*orders['price']
    orders=orders.groupby(['date', 'customer_id'])['price'].sum().reset_index()
    orders=orders[orders['price']>=100]
    orders['h']=orders['date'].apply(lambda x: 2 if x=='06-2020' else 1)
    orders=orders.groupby('customer_id')['h'].agg(lambda s: reduce(operator.or_, s)).reset_index()
    orders=orders[orders['h']==3]
    orders=pd.merge(orders, customers, how='inner', on='customer_id')
    return orders[['customer_id', 'name']]
