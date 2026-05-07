#
# Problem: 3465. Find Products with Valid Serial Numbers
# Difficulty: Easy
# Link: https://leetcode.com/problems/find-products-with-valid-serial-numbers/
# Language: python3
# Date: 2026-05-07


import pandas as pd

def find_valid_serial_products(products: pd.DataFrame) -> pd.DataFrame:
    return products.loc[
        products['description'].str.contains(r'\bSN\d{4}-\d{4}\b')
    ]
