#
# Problem: 1459. Rectangles Area
# Difficulty: Medium
# Link: https://leetcode.com/problems/rectangles-area/
# Language: python3
# Date: 2026-04-17


import pandas as pd

def rectangles_area(points: pd.DataFrame) -> pd.DataFrame:
    points=pd.merge(points, points, how='cross')
    points['area']=points.apply(lambda row: abs(row['x_value_x']-row['x_value_y'])*abs(row['y_value_x']-row['y_value_y']), axis=1)
    points=points[(points['area']!=0)&(points['id_x']<points['id_y'])].rename(columns={'id_x': 'p1', 'id_y': 'p2'})
    return points[['p1', 'p2', 'area']].sort_values(by=['area', 'p1', 'p2'], ascending=[False, True, True])
