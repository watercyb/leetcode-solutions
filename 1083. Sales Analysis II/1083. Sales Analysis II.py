#
# Problem: 1083. Sales Analysis II
# Difficulty: Easy
# Link: https://leetcode.com/problems/sales-analysis-ii/
# Language: python3
# Date: 2026-04-12


import pandas as pd

def sales_analysis(product: pd.DataFrame, sales: pd.DataFrame) -> pd.DataFrame:
    sales=pd.merge(sales, product, how='inner', on='product_id')
    sales=sales[~sales['buyer_id'].isin(sales[sales['product_name']=='iPhone']['buyer_id'])]
    sales=sales[sales['buyer_id'].isin(sales[sales['product_name']=='S8']['buyer_id'])]
    return sales[['buyer_id']].drop_duplicates()
