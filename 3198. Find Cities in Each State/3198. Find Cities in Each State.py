#
# Problem: 3198. Find Cities in Each State
# Difficulty: Easy
# Link: https://leetcode.com/problems/find-cities-in-each-state/
# Language: python3
# Date: 2026-05-04


import pandas as pd

def find_cities(cities: pd.DataFrame) -> pd.DataFrame:
    cities=cities.sort_values(by='city')
    cities = cities.groupby('state')['city'].agg(', '.join).reset_index(name='cities')
    return cities
