#
# Problem: 1939. Users That Actively Request Confirmation Messages
# Difficulty: Easy
# Link: https://leetcode.com/problems/users-that-actively-request-confirmation-messages/
# Language: python3
# Date: 2026-04-22


import pandas as pd

def find_requesting_users(signups: pd.DataFrame, confirmations: pd.DataFrame) -> pd.DataFrame:
    confirmations=confirmations.sort_values(by=['user_id', 'time_stamp'])
    confirmations['prv_time']=confirmations['time_stamp'].shift(1)
    confirmations['prv_id']=confirmations['user_id'].shift(1)
    confirmations['diff']=(confirmations['time_stamp'] - confirmations['prv_time']).dt.total_seconds() / 3600
    confirmations=confirmations[(confirmations['prv_id']==confirmations['user_id']) & (confirmations['diff']<=24)]
    return confirmations[['user_id']].drop_duplicates()
