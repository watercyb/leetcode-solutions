#
# Problem: 1934. Confirmation Rate
# Difficulty: Medium
# Link: https://leetcode.com/problems/confirmation-rate/
# Language: python3
# Date: 2026-04-22


import pandas as pd

def confirmation_rate(signups: pd.DataFrame, confirmations: pd.DataFrame) -> pd.DataFrame:
    confirmations['confirmed']=confirmations['action'].apply(lambda x: 1 if x=='confirmed' else 0)
    confirmations=confirmations.groupby('user_id').agg({'action': 'count','confirmed': 'sum'}).reset_index()
    confirmations['confirmation_rate']=(confirmations['confirmed']/confirmations['action']).round(2)
    return pd.merge(signups, confirmations, how='left', on='user_id').fillna(0)[['user_id', 'confirmation_rate']]
