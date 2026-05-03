#
# Problem: 3061. Calculate Trapping Rain Water
# Difficulty: Hard
# Link: https://leetcode.com/problems/calculate-trapping-rain-water/
# Language: python3
# Date: 2026-05-03


import pandas as pd

def calculate_trapped_rain_water(heights: pd.DataFrame) -> pd.DataFrame:
    heights["left"] = heights["height"].cummax()
    heights = heights.sort_values(by='id', ascending=False)
    heights["right"] = heights["height"].cummax()
    heights['water']=heights[['left', 'right']].min(axis=1)-heights['height']
    return pd.DataFrame({'total_trapped_water': [heights['water'].sum()]})
