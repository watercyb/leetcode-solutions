#
# Problem: 1777. Product's Price for Each Store
# Difficulty: Easy
# Link: https://leetcode.com/problems/products-price-for-each-store/
# Language: python3
# Date: 2026-04-20


import pandas as pd

def products_price(products: pd.DataFrame) -> pd.DataFrame:
    products = products.pivot(index="product_id", columns="store", values="price").reset_index()
    return products
