#
# Problem: 1126. Active Businesses
# Difficulty: Medium
# Link: https://leetcode.com/problems/active-businesses/
# Language: python3
# Date: 2026-04-14


import pandas as pd

def active_businesses(events: pd.DataFrame) -> pd.DataFrame:
    events['max']=events.groupby('event_type')['occurrences'].transform('mean')
    events['count']=events.apply(lambda x: 1 if x['occurrences']>x['max'] else 0, axis=1)
    events=events.groupby('business_id')['count'].sum().reset_index()
    return events[events['count']>1][['business_id']]
