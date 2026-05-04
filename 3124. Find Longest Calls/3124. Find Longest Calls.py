#
# Problem: 3124. Find Longest Calls
# Difficulty: Medium
# Link: https://leetcode.com/problems/find-longest-calls/
# Language: python3
# Date: 2026-05-04


import pandas as pd

def find_longest_calls(contacts: pd.DataFrame, calls: pd.DataFrame) -> pd.DataFrame:
    calls=calls.sort_values(by='duration', ascending=False)
    calls=calls.groupby('type').head(3)
    calls['duration_formatted']=calls['duration'].apply(lambda x: f"{x//3600:02}:{(x%3600)//60:02}:{x%60:02}")
    calls=pd.merge(contacts, calls, how='inner', left_on='id', right_on='contact_id')
    return calls[['first_name', 'type', 'duration_formatted']].sort_values(by=['type', 'duration_formatted', 'first_name'], ascending=[False, False, False])
    
