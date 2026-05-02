#
# Problem: 2987. Find Expensive Cities
# Difficulty: Easy
# Link: https://leetcode.com/problems/find-expensive-cities/
# Language: python3
# Date: 2026-05-02


import pandas as pd

def find_expensive_cities(listings: pd.DataFrame) -> pd.DataFrame:
    avg=listings['price'].mean()
    listings=listings.groupby('city')['price'].mean().reset_index()
    listings=listings[listings['price']>avg]
    return listings[['city']].sort_values(by='city')
