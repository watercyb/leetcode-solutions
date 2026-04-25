#
# Problem: 2252. Dynamic Pivoting of a Table
# Difficulty: Hard
# Link: https://leetcode.com/problems/dynamic-pivoting-of-a-table/
# Language: python3
# Date: 2026-04-25


import pandas as pd

def dynamic_pivoting_table(products: pd.DataFrame) -> pd.DataFrame:
    products=products.pivot(index='product_id', columns='store', values='price').reset_index()
    return products
