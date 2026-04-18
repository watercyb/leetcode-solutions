#
# Problem: 1581. Customer Who Visited but Did Not Make Any Transactions
# Difficulty: Easy
# Link: https://leetcode.com/problems/customer-who-visited-but-did-not-make-any-transactions/
# Language: python3
# Date: 2026-04-18


import pandas as pd

def find_customers(visits: pd.DataFrame, transactions: pd.DataFrame) -> pd.DataFrame:
    df=pd.merge(visits, transactions.fillna(0), how='left', on='visit_id')
    df=df[pd.isnull(df['amount'])].groupby('customer_id')['visit_id'].count().reset_index(name='count_no_trans')
    return df
