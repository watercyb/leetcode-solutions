#
# Problem: 2324. Product Sales Analysis IV
# Difficulty: Medium
# Link: https://leetcode.com/problems/product-sales-analysis-iv/
# Language: python3
# Date: 2026-04-26


import pandas as pd

def product_sales_analysis(sales: pd.DataFrame, product: pd.DataFrame) -> pd.DataFrame:
    sales=sales.groupby(['product_id', 'user_id'])['quantity'].sum().reset_index()
    sales=pd.merge(sales, product, how='inner', on='product_id')
    sales['total']=sales['quantity']*sales['price']
    sales['max']=sales.groupby(['user_id'])['total'].transform('max')
    sales=sales[sales['total']==sales['max']]
    return sales[['user_id', 'product_id']]
