#
# Problem: 262. Trips and Users
# Difficulty: Hard
# Link: https://leetcode.com/problems/trips-and-users/
# Language: python3
# Date: 2026-03-31


import pandas as pd

def trips_and_users(trips: pd.DataFrame, users: pd.DataFrame) -> pd.DataFrame:
    trips=trips[(trips['request_at']>="2013-10-01") & (trips['request_at']<="2013-10-03")]
    trips=trips[trips['client_id'].isin(users[(users['banned']=='No') & (users['role']=='client')]['users_id'])]
    trips=trips[trips['driver_id'].isin(users[(users['banned']=='No') & (users['role']=='driver')]['users_id'])]
    trips['cancelled']=trips['status'].apply(lambda x: 1 if x.startswith('cancelled') else 0)
    trips['total']=1
    trips=trips.groupby('request_at')[['cancelled', 'total']].sum().reset_index()
    trips['Cancellation Rate']=(trips['cancelled']/trips['total']).round(2)
    trips=trips.rename(columns={'request_at': 'Day'})
    return trips[['Day', 'Cancellation Rate']]
