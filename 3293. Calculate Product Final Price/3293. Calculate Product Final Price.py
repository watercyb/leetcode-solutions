#
# Problem: 3293. Calculate Product Final Price
# Difficulty: Medium
# Link: https://leetcode.com/problems/calculate-product-final-price/
# Language: python3
# Date: 2026-05-05


import pandas as pd

def calculate_final_prices(products: pd.DataFrame, discounts: pd.DataFrame) -> pd.DataFrame:
    products=pd.merge(products, discounts, how='left', on='category').fillna(0)
    products['final_price']=products['price']*(100-products['discount'])/100
    return products[['product_id', 'final_price', 'category']].sort_values(by='product_id')
