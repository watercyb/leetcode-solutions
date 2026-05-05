#
# Problem: 3214. Year on Year Growth Rate
# Difficulty: Hard
# Link: https://leetcode.com/problems/year-on-year-growth-rate/
# Language: python3
# Date: 2026-05-05


import pandas as pd

def calculate_yoy_growth(user_transactions: pd.DataFrame) -> pd.DataFrame:
    user_transactions['transaction_date']=user_transactions['transaction_date'].dt.year
    user_transactions=user_transactions.groupby(['product_id', 'transaction_date'])['spend'].sum().reset_index()
    user_transactions=user_transactions.sort_values(by=['product_id', 'transaction_date'], ascending=[True, True])
    conditions = [
        (user_transactions['transaction_date']== user_transactions['transaction_date'].shift(1)+1) & (user_transactions['product_id'] == user_transactions['product_id'].shift(1))
    ]
    choices = [
        user_transactions['spend'].shift(1)
    ]
    user_transactions['prev_year_spend'] = np.select(conditions, choices, default=None)
    def div(row):
        a=row['spend']
        b=row['prev_year_spend']
        if pd.isna(b):
            return None
        else:
            return round((a-b)/b*100,2)
    user_transactions['yoy_rate']=user_transactions[['spend', 'prev_year_spend']].apply(div, axis=1)
    user_transactions=user_transactions.rename(columns={'transaction_date': 'year', 'spend': 'curr_year_spend'})
    return user_transactions[['year', 'product_id', 'curr_year_spend', 'prev_year_spend', 'yoy_rate']]
