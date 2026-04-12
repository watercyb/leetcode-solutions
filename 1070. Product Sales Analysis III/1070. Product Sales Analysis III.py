#
# Problem: 1070. Product Sales Analysis III
# Difficulty: Medium
# Link: https://leetcode.com/problems/product-sales-analysis-iii/
# Language: python3
# Date: 2026-04-12


import pandas as pd

def sales_analysis(sales: pd.DataFrame) -> pd.DataFrame:
    sales['first_year']=sales.groupby('product_id')['year'].transform('min')
    sales=sales[sales['year']==sales['first_year']]
    return sales[['product_id', 'first_year', 'quantity', 'price']]
