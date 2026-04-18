#
# Problem: 1543. Fix Product Name Format
# Difficulty: Easy
# Link: https://leetcode.com/problems/fix-product-name-format/
# Language: python3
# Date: 2026-04-18


import pandas as pd

def fix_name_format(sales: pd.DataFrame) -> pd.DataFrame:
    sales['sale_date']=sales['sale_date'].dt.strftime('%Y-%m')
    sales['product_name']=sales['product_name'].str.strip().str.lower()
    sales=sales.groupby(['product_name', 'sale_date']).size().reset_index(name='total')
    return sales.sort_values(by=['product_name', 'sale_date'])
