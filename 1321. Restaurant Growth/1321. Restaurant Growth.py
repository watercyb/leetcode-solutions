#
# Problem: 1321. Restaurant Growth
# Difficulty: Medium
# Link: https://leetcode.com/problems/restaurant-growth/
# Language: python3
# Date: 2026-04-16


import pandas as pd

def restaurant_growth(customer: pd.DataFrame) -> pd.DataFrame:
    customer=customer.groupby('visited_on')['amount'].sum().reset_index()
    customer['average_amount']=customer['amount'].rolling(window=7).mean().round(2)
    customer['amount']=customer['amount'].rolling(window=7).sum()
    return customer.dropna()
