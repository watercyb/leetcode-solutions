#
# Problem: 2994. Friday Purchases II
# Difficulty: Hard
# Link: https://leetcode.com/problems/friday-purchases-ii/
# Language: python3
# Date: 2026-05-02


import pandas as pd

def friday_purchases(purchases: pd.DataFrame) -> pd.DataFrame:
    arr=[]
    for i in range(0,5):
        day=pd.to_datetime('2023-11')+pd.Timedelta((11-pd.to_datetime('2023-11').weekday())%7+i*7, "D")
        if day<pd.to_datetime('2023-12'):
            arr.append(day)
    df=pd.DataFrame({'week_of_month': [i for i in range(1, len(arr)+1)], 'purchase_date': arr})
    purchases=pd.merge(df, purchases, how='left', on='purchase_date').fillna(0)
    purchases=purchases.groupby(['week_of_month', 'purchase_date'])['amount_spend'].sum().reset_index(name='total_amount')
    return purchases
