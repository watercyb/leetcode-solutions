#
# Problem: 1336. Number of Transactions per Visit
# Difficulty: Hard
# Link: https://leetcode.com/problems/number-of-transactions-per-visit/
# Language: python3
# Date: 2026-04-16


import pandas as pd

def draw_chart(visits: pd.DataFrame, transactions: pd.DataFrame) -> pd.DataFrame:
    transactions=transactions.groupby(['user_id', 'transaction_date']).size().reset_index(name='transactions_count')
    df=pd.merge(visits, transactions, how='left', left_on=['user_id', 'visit_date'], right_on=['user_id', 'transaction_date']).fillna(0)
    df=df.groupby('transactions_count')['user_id'].size().reset_index()
    df=pd.merge(pd.DataFrame({'transactions_count': range(0, int (df['transactions_count'].max()+1))}), df, how='left', on='transactions_count').fillna(0)
    return df.rename(columns={'user_id': 'visits_count'})
