#
# Problem: 1651. Hopper Company Queries III
# Difficulty: Hard
# Link: https://leetcode.com/problems/hopper-company-queries-iii/
# Language: python3
# Date: 2026-04-19


import pandas as pd

def hopper_company_queries(drivers: pd.DataFrame, rides: pd.DataFrame, accepted_rides: pd.DataFrame) -> pd.DataFrame:
    rides=rides[rides['requested_at'].dt.year==2020]
    rides['month']=rides['requested_at'].dt.month
    rides=pd.merge(rides, accepted_rides, how='inner', on='ride_id')
    rides=pd.concat([pd.DataFrame({'month': [i for i in range(1,13)]}),rides]).fillna(0)
    rides=rides.groupby('month').agg({'ride_distance': 'sum', 'ride_duration': 'sum'}).reset_index()
    rides=pd.merge(pd.DataFrame({'month': [i for i in range(1,11)]}), rides, how='cross')
    rides=rides[(rides['month_y']-rides['month_x']>=0) & (rides['month_y']-rides['month_x']<3)]
    rides=rides.groupby('month_x').agg({'ride_distance': 'mean', 'ride_duration': 'mean'}).reset_index()
    rides['ride_distance']=rides['ride_distance'].round(2)
    rides['ride_duration']=rides['ride_duration'].round(2)
    return rides.rename(columns={'month_x': 'month', 'ride_distance': 'average_ride_distance', 'ride_duration': 'average_ride_duration'})
