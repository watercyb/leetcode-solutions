#
# Problem: 3220. Odd and Even Transactions
# Difficulty: Medium
# Link: https://leetcode.com/problems/odd-and-even-transactions/
# Language: python3
# Date: 2026-05-05


import pandas as pd

def sum_daily_odd_even(transactions: pd.DataFrame) -> pd.DataFrame:
    transactions['odd_sum']=transactions['amount'].apply(lambda x: x if (x&1)==1 else 0)
    transactions['even_sum']=transactions['amount'].apply(lambda x: x if (x&1)==0 else 0)
    transactions=transactions.groupby('transaction_date').agg({'odd_sum': 'sum', 'even_sum': 'sum'}).reset_index()
    return transactions.sort_values(by='transaction_date')
