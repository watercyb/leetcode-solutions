#
# Problem: 1193. Monthly Transactions I
# Difficulty: Medium
# Link: https://leetcode.com/problems/monthly-transactions-i/
# Language: python3
# Date: 2026-04-14


import pandas as pd

def monthly_transactions(transactions: pd.DataFrame) -> pd.DataFrame:
    transactions['month']=transactions['trans_date'].dt.strftime('%Y-%m')
    transactions['state']=[1 if state=='approved' else 0 for state in transactions['state']]
    transactions['approved_total_amount']=transactions['state']*transactions['amount']
    transactions = transactions.groupby(['month', 'country'], dropna=False).agg({'id' : 'count', 'state' : 'sum', 'amount' : 'sum', 'approved_total_amount' : 'sum'}).reset_index()
    return transactions.rename(columns={'id': 'trans_count', 'state': 'approved_count','amount': 'trans_total_amount'})
