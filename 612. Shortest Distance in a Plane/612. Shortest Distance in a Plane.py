#
# Problem: 612. Shortest Distance in a Plane
# Difficulty: Medium
# Link: https://leetcode.com/problems/shortest-distance-in-a-plane/
# Language: python3
# Date: 2026-04-05


import pandas as pd

def shortest_distance(point2_d: pd.DataFrame) -> pd.DataFrame:
    point2_d = point2_d.reset_index()
    df=pd.merge(point2_d, point2_d, how='cross')
    df=df[df['index_x']<df['index_y']]
    df['dist']=(df['x_x']-df['x_y'])*(df['x_x']-df['x_y'])+(df['y_x']-df['y_y'])*(df['y_x']-df['y_y'])
    return pd.DataFrame({'shortest':[round(sqrt(df['dist'].min()),2)]})
