#
# Problem: 2474. Customers With Strictly Increasing Purchases
# Difficulty: Hard
# Link: https://leetcode.com/problems/customers-with-strictly-increasing-purchases/
# Language: python3
# Date: 2026-04-27


import pandas as pd

def find_specific_customers(orders: pd.DataFrame) -> pd.DataFrame:
    df=orders[['customer_id']].drop_duplicates()
    orders['order_date']=orders['order_date'].dt.year
    orders=orders.groupby(['customer_id', 'order_date'])['price'].sum().reset_index()
    orders=orders.sort_values(by=['customer_id', 'order_date'])
    orders['prv_date']=orders['order_date'].shift(1)
    orders['prv_price']=orders['price'].shift(1)
    orders['prv_id']=orders['customer_id'].shift(1)
    orders=orders[orders['prv_id']==orders['customer_id']]
    orders=orders[((~orders['prv_date'].isna()) & (orders['prv_date']+1!=orders['order_date'])) | ((~orders['prv_price'].isna()) & (orders['prv_price']>=orders['price']))][['customer_id']].drop_duplicates()
    df=df[~df['customer_id'].isin(orders['customer_id'])]
    return df
