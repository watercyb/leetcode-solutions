#
# Problem: 2142. The Number of Passengers in Each Bus I
# Difficulty: Medium
# Link: https://leetcode.com/problems/the-number-of-passengers-in-each-bus-i/
# Language: python3
# Date: 2026-04-24


import pandas as pd

def count_passengers_in_bus(buses: pd.DataFrame, passengers: pd.DataFrame) -> pd.DataFrame:
    buses = pd.merge_ordered(buses, passengers, on='arrival_time')
    buses['bus_id'] = buses['bus_id'].bfill()
    buses=buses.groupby('bus_id')['passenger_id'].count().reset_index(name='passengers_cnt')
    return buses
