#
# Problem: 2329. Product Sales Analysis V
# Difficulty: Easy
# Link: https://leetcode.com/problems/product-sales-analysis-v/
# Language: python3
# Date: 2026-04-26


import pandas as pd

def product_sales_analysis(sales: pd.DataFrame, product: pd.DataFrame) -> pd.DataFrame:
    sales=pd.merge(sales, product, how='inner', on='product_id')
    sales['spending']=sales['quantity']*sales['price']
    sales=sales.groupby('user_id')['spending'].sum().reset_index()
    return sales.sort_values(by=['spending', 'user_id'], ascending=[False, True])
