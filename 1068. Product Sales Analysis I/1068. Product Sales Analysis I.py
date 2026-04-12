#
# Problem: 1068. Product Sales Analysis I
# Difficulty: Easy
# Link: https://leetcode.com/problems/product-sales-analysis-i/
# Language: python3
# Date: 2026-04-12


import pandas as pd

def sales_analysis(sales: pd.DataFrame, product: pd.DataFrame) -> pd.DataFrame:
    sales=pd.merge(sales, product, how='inner', on='product_id')
    return sales[['product_name', 'year', 'price']]
