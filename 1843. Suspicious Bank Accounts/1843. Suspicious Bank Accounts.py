#
# Problem: 1843. Suspicious Bank Accounts
# Difficulty: Medium
# Link: https://leetcode.com/problems/suspicious-bank-accounts/
# Language: python3
# Date: 2026-04-21


import pandas as pd

def suspicious_bank_accounts(accounts: pd.DataFrame, transactions: pd.DataFrame) -> pd.DataFrame:
    transactions=transactions[transactions['type']=='Creditor']
    transactions['date']=transactions['day'].dt.strftime('%Y-%m')
    transactions=transactions.groupby(['account_id', 'date'])['amount'].sum().reset_index()
    transactions=pd.merge(accounts, transactions, how='inner', on='account_id')
    transactions=transactions[transactions['amount']>transactions['max_income']]
    transactions=transactions.sort_values(by=['account_id', 'date'])
    transactions['prv_date']=transactions['date'].shift(1)
    transactions['prv_id']=transactions['account_id'].shift(1)
    transactions=transactions[(transactions['account_id']==transactions['prv_id']) & (transactions['date']==pd.to_datetime(transactions['prv_date'])+pd.DateOffset(months=1))]
    return transactions[['account_id']].drop_duplicates()

    
