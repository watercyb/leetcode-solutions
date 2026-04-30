#
# Problem: 2701. Consecutive Transactions with Increasing Amounts
# Difficulty: Hard
# Link: https://leetcode.com/problems/consecutive-transactions-with-increasing-amounts/
# Language: python3
# Date: 2026-04-30


import pandas as pd

def consecutive_increasing_transactions(transactions: pd.DataFrame) -> pd.DataFrame:
    transactions=transactions.sort_values(by=['customer_id', 'transaction_date'])
    transactions['prv']=transactions['customer_id'].shift(1)
    transactions['prv_amount']=transactions['amount'].shift(1)
    transactions['r']=transactions.apply(lambda row: 0 if pd.isna(row['prv']) or row['prv']!=row['customer_id'] or row['prv_amount']>=row['amount'] else 1, axis=1)
    transactions['r']=transactions['r'].cumsum()
    transactions['r']=transactions['transaction_date']-pd.to_timedelta(transactions['r'], 'D')
    transactions=transactions.groupby(['customer_id', 'r']).agg(consecutive_start=('transaction_date', 'min'), consecutive_end=('transaction_date', 'max'), count=('transaction_date', 'size')).reset_index()
    transactions=transactions[transactions['count']>=3]
    return transactions[['customer_id', 'consecutive_start', 'consecutive_end']]
