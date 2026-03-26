#
# Problem: 197. Rising Temperature
# Difficulty: Easy
# Link: https://leetcode.com/problems/rising-temperature/
# Language: python3
# Date: 2026-03-26


import pandas as pd

def rising_temperature(weather: pd.DataFrame) -> pd.DataFrame:
    weather=weather.sort_values('recordDate', ascending=True) 
    weather=weather[(weather['temperature']>weather['temperature'].shift(1))&((weather['recordDate']-weather['recordDate'].shift(1)).dt.days==1)]
    return weather[['id']]
