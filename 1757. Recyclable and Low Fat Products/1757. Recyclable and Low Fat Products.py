#
# Problem: 1757. Recyclable and Low Fat Products
# Difficulty: Easy
# Link: https://leetcode.com/problems/recyclable-and-low-fat-products/
# Language: python3
# Date: 2026-04-20


import pandas as pd

def find_products(products: pd.DataFrame) -> pd.DataFrame:
    return products[(products['low_fats'] == 'Y') & (products['recyclable'] == 'Y')][['product_id']]
