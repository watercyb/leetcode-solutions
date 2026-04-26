#
# Problem: 2314. The First Day of the Maximum Recorded Degree in Each City
# Difficulty: Medium
# Link: https://leetcode.com/problems/the-first-day-of-the-maximum-recorded-degree-in-each-city/
# Language: python3
# Date: 2026-04-26


import pandas as pd

def find_the_first_day(weather: pd.DataFrame) -> pd.DataFrame:
    weather=weather.sort_values(by=['city_id', 'degree', 'day'], ascending=[True, False, True])
    weather=weather.groupby('city_id').head(1)
    return weather
