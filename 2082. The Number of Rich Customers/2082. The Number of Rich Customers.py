#
# Problem: 2082. The Number of Rich Customers
# Difficulty: Easy
# Link: https://leetcode.com/problems/the-number-of-rich-customers/
# Language: python3
# Date: 2026-04-23


import pandas as pd

def count_rich_customers(store: pd.DataFrame) -> pd.DataFrame:
    store=store[store['amount']>500][['customer_id']].drop_duplicates()
    return pd.DataFrame({'rich_count': [store.shape[0]]})
