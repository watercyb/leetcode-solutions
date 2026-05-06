#
# Problem: 3308. Find Top Performing Driver
# Difficulty: Medium
# Link: https://leetcode.com/problems/find-top-performing-driver/
# Language: python3
# Date: 2026-05-06


import pandas as pd

def get_top_performing_drivers(drivers: pd.DataFrame, vehicles: pd.DataFrame, trips: pd.DataFrame) -> pd.DataFrame:
    vehicles=pd.merge(vehicles, trips, how='inner', on='vehicle_id')
    vehicles=vehicles.groupby(['driver_id', 'fuel_type']).agg({'distance': 'sum', 'rating': 'mean'}).reset_index()
    drivers=pd.merge(drivers, vehicles, how='inner', on='driver_id')
    drivers['rating']=drivers['rating'].round(2)
    drivers=drivers[['fuel_type', 'driver_id', 'rating', 'distance']].sort_values(by=['rating', 'distance', 'fuel_type'], ascending=[False, False, True])
    drivers=drivers.groupby('fuel_type').first(1).reset_index()
    return drivers
