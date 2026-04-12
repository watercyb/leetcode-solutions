#
# Problem: 1069. Product Sales Analysis II
# Difficulty: Easy
# Link: https://leetcode.com/problems/product-sales-analysis-ii/
# Language: python3
# Date: 2026-04-12


import pandas as pd

def sales_analysis(sales: pd.DataFrame, product: pd.DataFrame) -> pd.DataFrame:
    sales=sales.groupby('product_id')['quantity'].sum().reset_index(name='total_quantity')
    return sales
