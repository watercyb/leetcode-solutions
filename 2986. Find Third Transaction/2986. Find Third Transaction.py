#
# Problem: 2986. Find Third Transaction
# Difficulty: Medium
# Link: https://leetcode.com/problems/find-third-transaction/
# Language: python3
# Date: 2026-05-02


import pandas as pd

def find_third_transaction(transactions: pd.DataFrame) -> pd.DataFrame:
    transactions=transactions.sort_values(by=['user_id', 'transaction_date'])
    transactions['rnk']=transactions.groupby('user_id').cumcount()
    transactions=transactions[(transactions['rnk']==2) & (transactions['spend']>transactions['spend'].shift(1)) & (transactions['spend']>transactions['spend'].shift(2))]
    return transactions[['user_id', 'spend', 'transaction_date']].rename(columns={'spend': 'third_transaction_spend', 'transaction_date': 'third_transaction_date'})
