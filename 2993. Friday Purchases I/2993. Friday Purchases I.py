#
# Problem: 2993. Friday Purchases I
# Difficulty: Medium
# Link: https://leetcode.com/problems/friday-purchases-i/
# Language: python3
# Date: 2026-05-02


import pandas as pd

def friday_purchases(purchases: pd.DataFrame) -> pd.DataFrame:
    purchases=purchases[(purchases['purchase_date'].dt.strftime('%Y-%m')=='2023-11') & (purchases['purchase_date'].dt.weekday==4)]
    purchases['week_of_month']=(
        (purchases['purchase_date'].dt.day + purchases['purchase_date'].dt.to_period('M').dt.start_time.dt.weekday) 
        .sub(1)
        .floordiv(7)
        .add(1)
    )
    purchases=purchases.groupby(['week_of_month', 'purchase_date'])['amount_spend'].sum().reset_index(name='total_amount')
    return purchases.sort_values(by='week_of_month')
