#
# Problem: 1251. Average Selling Price
# Difficulty: Easy
# Link: https://leetcode.com/problems/average-selling-price/
# Language: python3
# Date: 2026-04-15


import pandas as pd

def average_selling_price(prices: pd.DataFrame, units_sold: pd.DataFrame) -> pd.DataFrame:
    df=pd.merge(prices, units_sold, how='inner', on='product_id')
    df=df[(df['purchase_date']>=df['start_date'])&(df['purchase_date']<=df['end_date'])]
    df['price']=df['price']*df['units']
    df=df[['product_id', 'price', 'units']].groupby('product_id').sum().reset_index()
    df['average_price']=(df['price']/df['units']).round(2)
    df=pd.merge(prices[['product_id']].drop_duplicates(), df, how='left', on='product_id').fillna(0)
    return df[['product_id', 'average_price']]
