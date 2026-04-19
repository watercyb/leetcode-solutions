#
# Problem: 1699. Number of Calls Between Two Persons
# Difficulty: Medium
# Link: https://leetcode.com/problems/number-of-calls-between-two-persons/
# Language: python3
# Date: 2026-04-19


import pandas as pd

def number_of_calls(calls: pd.DataFrame) -> pd.DataFrame:
    calls['person1']=calls[['from_id', 'to_id']].min(axis=1)
    calls['person2']=calls[['from_id', 'to_id']].max(axis=1)
    calls=calls.groupby(['person1', 'person2']).agg(call_count=('duration', 'size'), total_duration=('duration', 'sum')).reset_index()
    return calls
