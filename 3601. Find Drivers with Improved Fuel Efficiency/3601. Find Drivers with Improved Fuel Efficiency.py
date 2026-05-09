#
# Problem: 3601. Find Drivers with Improved Fuel Efficiency
# Difficulty: Medium
# Link: https://leetcode.com/problems/find-drivers-with-improved-fuel-efficiency/
# Language: python3
# Date: 2026-05-09


import pandas as pd

def find_improved_efficiency_drivers(drivers: pd.DataFrame, trips: pd.DataFrame) -> pd.DataFrame:
    trips['eff']=trips['distance_km']/trips['fuel_consumed']
    l=trips[pd.to_datetime(trips['trip_date']).dt.month<=6].groupby('driver_id')['eff'].mean().reset_index(name='first_half_avg')
    r=trips[pd.to_datetime(trips['trip_date']).dt.month>6].groupby('driver_id')['eff'].mean().reset_index(name='second_half_avg')
    df=pd.merge(l, r, how='inner', on='driver_id')
    df['efficiency_improvement']=(df['second_half_avg']-df['first_half_avg']).round(2)
    df=df[df['efficiency_improvement']>0]
    df['first_half_avg']=df['first_half_avg'].round(2)
    df['second_half_avg']=df['second_half_avg'].round(2)
    df=pd.merge(drivers, df, how='inner', on='driver_id').sort_values(by=['efficiency_improvement', 'driver_name'], ascending=[False, True])
    return df
