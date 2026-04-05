#
# Problem: 613. Shortest Distance in a Line
# Difficulty: Easy
# Link: https://leetcode.com/problems/shortest-distance-in-a-line/
# Language: python3
# Date: 2026-04-05


import pandas as pd

def shortest_distance(point: pd.DataFrame) -> pd.DataFrame:
    point=point.sort_values(by='x')
    point['x']=point['x'].diff()
    return pd.DataFrame({'shortest': point.min()})
