#
# Problem: 1084. Sales Analysis III
# Difficulty: Easy
# Link: https://leetcode.com/problems/sales-analysis-iii/
# Language: python3
# Date: 2026-04-12


import pandas as pd

def sales_analysis(product: pd.DataFrame, sales: pd.DataFrame) -> pd.DataFrame:
    sales=sales.groupby('product_id').agg(l=('sale_date', 'min'), r=('sale_date', 'max')).reset_index()
    sales=sales.loc[(sales['l']>='2019-01-01') & (sales['r']<='2019-03-31')]
    product=pd.merge(product, sales, how='inner', on='product_id')
    return product[['product_id', 'product_name']]
