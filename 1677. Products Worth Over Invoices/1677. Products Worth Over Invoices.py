#
# Problem: 1677. Product's Worth Over Invoices
# Difficulty: Easy
# Link: https://leetcode.com/problems/products-worth-over-invoices/
# Language: python3
# Date: 2026-04-19


import pandas as pd

def analyze_products(product: pd.DataFrame, invoice: pd.DataFrame) -> pd.DataFrame:
    invoice=invoice.groupby('product_id').agg({'rest': 'sum', 'paid': 'sum', 'canceled': 'sum', 'refunded': 'sum'}).reset_index()
    product=pd.merge(product, invoice, how='left', on='product_id').fillna(0)
    return product[['name', 'rest', 'paid', 'canceled', 'refunded']].sort_values(by='name')
