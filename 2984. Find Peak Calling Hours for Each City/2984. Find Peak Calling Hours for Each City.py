#
# Problem: 2984. Find Peak Calling Hours for Each City
# Difficulty: Medium
# Link: https://leetcode.com/problems/find-peak-calling-hours-for-each-city/
# Language: python3
# Date: 2026-05-02


import pandas as pd

def peak_calling_hours(calls: pd.DataFrame) -> pd.DataFrame:
    calls['peak_calling_hour']=calls['call_time'].dt.hour
    calls=calls.groupby(['city', 'peak_calling_hour']).size().reset_index(name='number_of_calls')
    calls['max']=calls.groupby('city')['number_of_calls'].transform('max')
    return calls[calls['number_of_calls']==calls['max']][['city', 'peak_calling_hour', 'number_of_calls']].sort_values(by=['peak_calling_hour', 'city'], ascending=[False, False])
