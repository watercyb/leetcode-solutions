#
# Problem: 1607. Sellers With No Sales
# Difficulty: Easy
# Link: https://leetcode.com/problems/sellers-with-no-sales/
# Language: python3
# Date: 2026-04-19


import pandas as pd

def sellers_with_no_sales(customer: pd.DataFrame, orders: pd.DataFrame, seller: pd.DataFrame) -> pd.DataFrame:
    orders=orders[orders['sale_date'].dt.year==2020]
    orders=orders[['seller_id']].drop_duplicates()
    seller=seller[~seller['seller_id'].isin(orders['seller_id'])]
    return seller[['seller_name']].sort_values(by='seller_name')
