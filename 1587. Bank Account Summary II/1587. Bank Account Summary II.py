#
# Problem: 1587. Bank Account Summary II
# Difficulty: Easy
# Link: https://leetcode.com/problems/bank-account-summary-ii/
# Language: python3
# Date: 2026-04-18


import pandas as pd

def account_summary(users: pd.DataFrame, transactions: pd.DataFrame) -> pd.DataFrame:
    transactions=transactions.groupby('account')['amount'].sum().reset_index(name='balance')
    transactions=transactions[transactions['balance']>10000]
    return pd.merge(users, transactions, how='inner', on='account')[['name', 'balance']]
