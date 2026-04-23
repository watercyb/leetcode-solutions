#
# Problem: 2066. Account Balance
# Difficulty: Medium
# Link: https://leetcode.com/problems/account-balance/
# Language: python3
# Date: 2026-04-23


import pandas as pd

def account_balance(transactions: pd.DataFrame) -> pd.DataFrame:
    transactions=transactions.sort_values(by=['account_id', 'day'])
    transactions['balance']=transactions.apply(lambda row: row['amount'] if row['type']=='Deposit' else -row['amount'], axis=1)
    transactions['balance']=transactions.groupby('account_id')['balance'].cumsum()
    return transactions[['account_id', 'day', 'balance']]
