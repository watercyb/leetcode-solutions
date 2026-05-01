#
# Problem: 2889. Reshape Data: Pivot
# Difficulty: Easy
# Link: https://leetcode.com/problems/reshape-data-pivot/
# Language: python3
# Date: 2026-05-01


import pandas as pd

def pivotTable(weather: pd.DataFrame) -> pd.DataFrame:
    return weather.pivot(index='month', columns='city', values='temperature')
