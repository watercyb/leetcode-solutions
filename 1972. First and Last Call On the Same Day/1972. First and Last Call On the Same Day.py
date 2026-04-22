#
# Problem: 1972. First and Last Call On the Same Day
# Difficulty: Hard
# Link: https://leetcode.com/problems/first-and-last-call-on-the-same-day/
# Language: python3
# Date: 2026-04-22


import pandas as pd

def same_day_calls(calls: pd.DataFrame) -> pd.DataFrame:
    calls=pd.concat([calls, calls.rename(columns={'caller_id': 'recipient_id', 'recipient_id': 'caller_id'})])
    calls['day']=calls['call_time'].dt.strftime('%Y-%m-%d')
    calls=calls.sort_values(by=['caller_id', 'call_time'])
    calls=calls.groupby(['caller_id', 'day']).agg(first=('recipient_id', 'first'), last=('recipient_id', 'last')).reset_index()
    calls=calls[calls['first']==calls['last']]
    return calls[['caller_id']].drop_duplicates().rename(columns={'caller_id': 'user_id'})
