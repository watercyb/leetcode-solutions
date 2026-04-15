#
# Problem: 1205. Monthly Transactions II
# Difficulty: Medium
# Link: https://leetcode.com/problems/monthly-transactions-ii/
# Language: python3
# Date: 2026-04-15


import pandas as pd

def monthly_transactions(transactions: pd.DataFrame, chargebacks: pd.DataFrame) -> pd.DataFrame:
    chargebacks=pd.merge(chargebacks, transactions[['id', 'amount', 'country']], how='inner', left_on='trans_id', right_on='id')
    chargebacks['month']=chargebacks['trans_date'].dt.strftime('%Y-%m')
    chargebacks=chargebacks.rename(columns={'amount': 'chargeback_amount'})
    chargebacks['chargeback_count']=1
    chargebacks=chargebacks.groupby(['month', 'country'])[['chargeback_count', 'chargeback_amount']].sum().reset_index()
    transactions=transactions[transactions['state']=='approved']
    transactions['month']=transactions['trans_date'].dt.strftime('%Y-%m')
    transactions=transactions.rename(columns={'amount': 'approved_amount'})
    transactions['approved_count']=1
    transactions=transactions.groupby(['month', 'country'])[['approved_count', 'approved_amount']].sum().reset_index()
    df=pd.merge(transactions, chargebacks, how='outer', on=['month', 'country']).fillna(0)
    return df
