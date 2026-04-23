#
# Problem: 2020. Number of Accounts That Did Not Stream
# Difficulty: Medium
# Link: https://leetcode.com/problems/number-of-accounts-that-did-not-stream/
# Language: python3
# Date: 2026-04-23


import pandas as pd

def find_target_accounts(subscriptions: pd.DataFrame, streams: pd.DataFrame) -> pd.DataFrame:
    subscriptions=subscriptions[(subscriptions['start_date']<='2021-12-31') & (subscriptions['end_date']>='2021-01-01')]
    streams=streams[streams['stream_date'].dt.year==2021]
    subscriptions=pd.merge(subscriptions, streams, how='left', on='account_id')
    return pd.DataFrame({'accounts_count': [subscriptions[subscriptions['session_id'].isna()].shape[0]]})
