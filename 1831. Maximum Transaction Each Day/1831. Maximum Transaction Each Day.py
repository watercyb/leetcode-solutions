#
# Problem: 1831. Maximum Transaction Each Day
# Difficulty: Medium
# Link: https://leetcode.com/problems/maximum-transaction-each-day/
# Language: python3
# Date: 2026-04-21


import pandas as pd

def find_maximum_transaction(transactions: pd.DataFrame) -> pd.DataFrame:
    transactions['day']=transactions['day'].dt.strftime('%Y-%m-%d')
    transactions['max']=transactions.groupby('day')['amount'].transform('max')
    transactions=transactions[transactions['amount']==transactions['max']]
    return transactions[['transaction_id']].sort_values(by='transaction_id')
