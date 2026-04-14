#
# Problem: 1127. User Purchase Platform
# Difficulty: Hard
# Link: https://leetcode.com/problems/user-purchase-platform/
# Language: python3
# Date: 2026-04-14


import pandas as pd

def user_purchase(spending: pd.DataFrame) -> pd.DataFrame:
    spending['type']=spending['platform'].apply(lambda x: 1 if x=='mobile' else 2)
    spending=spending.groupby(['user_id', 'spend_date']).agg({'amount': 'sum', 'type': lambda x: reduce(lambda a, b: a ^ b, x)}).reset_index()
    spending['total_users']=1
    spending=spending.groupby(['spend_date', 'type']).agg({'amount': 'sum', 'total_users': 'sum'}).reset_index()
    df=pd.merge(spending[['spend_date']].drop_duplicates(), pd.DataFrame({'type': [1,2,3]}), how='cross')
    df['amount']=0
    df['total_users']=0
    spending=pd.concat([spending, df], ignore_index=True)
    spending=spending.groupby(['spend_date', 'type']).agg({'amount': 'sum', 'total_users': 'sum'}).reset_index()
    spending['platform']=spending['type'].apply(lambda x: 'mobile' if x==1 else 'desktop' if x==2 else 'both')
    return spending.rename(columns={'amount': 'total_amount'})[['spend_date', 'platform', 'total_amount', 'total_users']]
