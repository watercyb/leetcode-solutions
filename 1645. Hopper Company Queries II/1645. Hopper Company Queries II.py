#
# Problem: 1645. Hopper Company Queries II
# Difficulty: Hard
# Link: https://leetcode.com/problems/hopper-company-queries-ii/
# Language: python3
# Date: 2026-04-19


import pandas as pd

def hopper_company_queries(drivers: pd.DataFrame, rides: pd.DataFrame, accepted_rides: pd.DataFrame) -> pd.DataFrame:
    drivers=drivers[drivers['join_date'].dt.year<=2020]
    drivers['month']=drivers['join_date'].apply(lambda x: 1 if x.year<2020 else x.month)
    drivers=drivers.groupby('month').size().reset_index(name='active_drivers')
    drivers=pd.merge(pd.DataFrame({'month': [i for i in range(1,13)]}), drivers, how='left', on='month').fillna(0)
    drivers['active_drivers']=drivers['active_drivers'].cumsum()
    rides=rides[rides['requested_at'].dt.year==2020]
    rides['month']=rides['requested_at'].dt.month
    rides=pd.merge(rides, accepted_rides, how='inner', on='ride_id')
    rides=rides[['month', 'driver_id']].drop_duplicates()
    rides=rides.groupby('month').size().reset_index(name='accepted_rides')
    drivers=pd.merge(drivers, rides, how='left', on='month').fillna(0)
    drivers['working_percentage']=((drivers['accepted_rides']/drivers['active_drivers']*100).round(2)).fillna(0)
    return drivers[['month', 'working_percentage']]
