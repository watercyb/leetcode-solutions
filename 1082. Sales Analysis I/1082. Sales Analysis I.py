#
# Problem: 1082. Sales Analysis I
# Difficulty: Easy
# Link: https://leetcode.com/problems/sales-analysis-i/
# Language: python3
# Date: 2026-04-12


import pandas as pd

def sales_analysis(product: pd.DataFrame, sales: pd.DataFrame) -> pd.DataFrame:
    sales=sales.groupby('seller_id')['price'].sum().reset_index()
    sales=sales[sales['price']==sales['price'].max()]
    return sales[['seller_id']]
