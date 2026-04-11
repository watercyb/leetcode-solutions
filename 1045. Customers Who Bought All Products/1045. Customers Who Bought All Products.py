#
# Problem: 1045. Customers Who Bought All Products
# Difficulty: Medium
# Link: https://leetcode.com/problems/customers-who-bought-all-products/
# Language: python3
# Date: 2026-04-11


import pandas as pd

def find_customers(customer: pd.DataFrame, product: pd.DataFrame) -> pd.DataFrame:
    count=product.shape[0]
    customer=customer.groupby('customer_id')['product_key'].nunique().reset_index()
    customer=customer[customer['product_key']==count]
    return customer[['customer_id']]
