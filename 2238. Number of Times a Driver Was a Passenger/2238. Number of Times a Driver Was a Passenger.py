#
# Problem: 2238. Number of Times a Driver Was a Passenger
# Difficulty: Medium
# Link: https://leetcode.com/problems/number-of-times-a-driver-was-a-passenger/
# Language: python3
# Date: 2026-04-25


import pandas as pd

def driver_passenger(rides: pd.DataFrame) -> pd.DataFrame:
    df=rides.groupby("passenger_id").size().reset_index(name='cnt')
    df=pd.merge(rides[['driver_id']].drop_duplicates(), df, how='left', left_on='driver_id', right_on='passenger_id').fillna(0)
    return df[['driver_id', 'cnt']]
