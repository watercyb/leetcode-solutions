#
# Problem: 2228. Users With Two Purchases Within Seven Days
# Difficulty: Medium
# Link: https://leetcode.com/problems/users-with-two-purchases-within-seven-days/
# Language: python3
# Date: 2026-04-25


import pandas as pd

def find_valid_users(purchases: pd.DataFrame) -> pd.DataFrame:
    purchases=purchases.sort_values(by=['user_id', 'purchase_date'])
    purchases['prv']=purchases['purchase_date'].shift(1)
    purchases['prvId']=purchases['user_id'].shift(1)
    purchases=purchases[(purchases['user_id']==purchases['prvId']) & ((purchases['purchase_date']-purchases['prv']).dt.days<=7)]
    return purchases[['user_id']].drop_duplicates()
