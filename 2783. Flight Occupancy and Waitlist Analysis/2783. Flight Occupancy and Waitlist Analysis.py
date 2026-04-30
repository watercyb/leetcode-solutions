#
# Problem: 2783. Flight Occupancy and Waitlist Analysis
# Difficulty: Medium
# Link: https://leetcode.com/problems/flight-occupancy-and-waitlist-analysis/
# Language: python3
# Date: 2026-04-30


import pandas as pd

def waitlist_analysis(flights: pd.DataFrame, passengers: pd.DataFrame) -> pd.DataFrame:
    passengers=passengers.groupby(['flight_id']).size().reset_index(name='total')
    flights=pd.merge(flights, passengers, how='left', on='flight_id').fillna(0)
    flights['booked_cnt']=flights[['capacity', 'total']].min(axis=1)
    flights['waitlist_cnt'] = np.maximum(flights['total']-flights['capacity'], 0)
    return flights[['flight_id', 'booked_cnt', 'waitlist_cnt']].sort_values(by='flight_id')
