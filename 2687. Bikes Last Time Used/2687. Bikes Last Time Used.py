#
# Problem: 2687. Bikes Last Time Used
# Difficulty: Easy
# Link: https://leetcode.com/problems/bikes-last-time-used/
# Language: python3
# Date: 2026-04-29


import pandas as pd

def last_used_time(bikes: pd.DataFrame) -> pd.DataFrame:
    bikes=bikes.groupby('bike_number')['end_time'].max().reset_index()
    return bikes.sort_values(by='end_time', ascending=False)
