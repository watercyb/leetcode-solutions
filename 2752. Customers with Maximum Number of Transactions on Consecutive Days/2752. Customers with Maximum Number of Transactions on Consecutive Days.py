#
# Problem: 2752. Customers with Maximum Number of Transactions on Consecutive Days
# Difficulty: Hard
# Link: https://leetcode.com/problems/customers-with-maximum-number-of-transactions-on-consecutive-days/
# Language: python3
# Date: 2026-04-30


import pandas as pd

def find_customers(transactions: pd.DataFrame) -> pd.DataFrame:
    transactions=transactions.groupby(['customer_id', 'transaction_date'])['amount'].sum().reset_index()
    transactions=transactions.sort_values(by=['customer_id', 'transaction_date'])
    transactions['r']=[i for i in range(transactions.shape[0])]
    transactions['r']=transactions['transaction_date']-pd.to_timedelta(transactions['r'], unit='D')
    transactions=transactions.groupby(['customer_id', 'r'])['amount'].size().reset_index()
    return transactions[transactions['amount']==transactions['amount'].max()][['customer_id']]
