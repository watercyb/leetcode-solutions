#
# Problem: 3118. Friday Purchase III
# Difficulty: Medium
# Link: https://leetcode.com/problems/friday-purchase-iii/
# Language: python3
# Date: 2026-05-04


import pandas as pd

def friday_purchases(purchases: pd.DataFrame, users: pd.DataFrame) -> pd.DataFrame:
    purchases['week_of_month']=((purchases['purchase_date']-pd.to_datetime("2023-11-03")).dt.days)
    purchases=purchases[purchases['week_of_month']%7==0]
    purchases['week_of_month']=purchases['week_of_month']//7+1
    purchases=pd.merge(purchases, users, how='inner', on='user_id')
    df=pd.merge(pd.DataFrame({'week_of_month': [1, 2, 3, 4]}), pd.DataFrame({'membership': ['Premium', 'VIP']}), how='cross')
    purchases=pd.merge(df, purchases, how='left', on=['week_of_month', 'membership']).fillna(0)
    purchases=purchases.groupby(['week_of_month', 'membership'])['amount_spend'].sum().reset_index(name='total_amount')
    return purchases
