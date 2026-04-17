#
# Problem: 1454. Active Users
# Difficulty: Medium
# Link: https://leetcode.com/problems/active-users/
# Language: python3
# Date: 2026-04-17


import pandas as pd

def active_users(accounts: pd.DataFrame, logins: pd.DataFrame) -> pd.DataFrame:
    logins=logins.drop_duplicates()
    logins['rank'] = logins.groupby('id')['login_date'].rank(method='dense')
    logins['rank']=logins['login_date']-pd.to_timedelta(logins['rank'], unit='d')
    logins=logins.groupby(['id', 'rank']).size().reset_index()
    logins=logins[logins[0]>=5][['id']].drop_duplicates()
    logins=pd.merge(logins, accounts, how='inner', on='id').sort_values(by='id')
    return logins
