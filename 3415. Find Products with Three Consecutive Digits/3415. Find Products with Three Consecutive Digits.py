#
# Problem: 3415. Find Products with Three Consecutive Digits
# Difficulty: Easy
# Link: https://leetcode.com/problems/find-products-with-three-consecutive-digits/
# Language: python3
# Date: 2026-05-07


import pandas as pd

def find_products(products: pd.DataFrame) -> pd.DataFrame:
    products=products[products['name'].str.contains(r'^[^0-9]*[0-9]{3}[^0-9]*$')]
    return products.sort_values(by='product_id')
