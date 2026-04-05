#
# Problem: 610. Triangle Judgement
# Difficulty: Easy
# Link: https://leetcode.com/problems/triangle-judgement/
# Language: python3
# Date: 2026-04-05


import pandas as pd

def triangle_judgement(triangle: pd.DataFrame) -> pd.DataFrame:
    def check_triangle(row):
        if row.sum()>2*row.max():
            return 'Yes'
        else:
            return 'No'
    triangle['triangle']=triangle.apply(check_triangle, axis=1)
    return triangle
