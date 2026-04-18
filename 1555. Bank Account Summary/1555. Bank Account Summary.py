#
# Problem: 1555. Bank Account Summary
# Difficulty: Medium
# Link: https://leetcode.com/problems/bank-account-summary/
# Language: python3
# Date: 2026-04-18


import pandas as pd

def bank_account_summary(users: pd.DataFrame, transactions: pd.DataFrame) -> pd.DataFrame:
    df1=transactions[['paid_by', 'amount']].groupby('paid_by')['amount'].sum().reset_index()
    df2=transactions[['paid_to', 'amount']].groupby('paid_to')['amount'].sum().reset_index()
    df1['amount']=-df1['amount']
    df=pd.concat([df1, df2.rename(columns={'paid_to': 'paid_by'})])
    df=df.groupby('paid_by')['amount'].sum().reset_index()
    users=pd.merge(users, df, how='left', left_on='user_id', right_on='paid_by').fillna(0)
    users['credit']=users['credit']+users['amount']
    users['credit_limit_breached']=users['credit'].apply(lambda x: 'Yes' if x<0 else 'No')
    return users[['user_id', 'user_name', 'credit', 'credit_limit_breached']]
