#
# Problem: 1795. Rearrange Products Table
# Difficulty: Easy
# Link: https://leetcode.com/problems/rearrange-products-table/
# Language: python3
# Date: 2026-04-20


import pandas as pd

def rearrange_products_table(products: pd.DataFrame) -> pd.DataFrame:
    products=products.melt(id_vars=['product_id'], var_name='store', value_name='price')
    products=products.loc[~products['price'].isna()]
    return products
