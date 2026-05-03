#
# Problem: 3053. Classifying Triangles by Lengths
# Difficulty: Easy
# Link: https://leetcode.com/problems/classifying-triangles-by-lengths/
# Language: python3
# Date: 2026-05-03


import pandas as pd

def type_of_triangle(triangles: pd.DataFrame) -> pd.DataFrame:
    def check(row):
        a=max(row['A'],row['B'],row['C'])
        c=min(row['A'],row['B'],row['C'])
        b=row['A']+row['B']+row['C']-a-c
        if a>=c+b:
            return "Not A Triangle"
        elif a==b and b==c:
            return "Equilateral"
        elif a==b or b==c:
            return "Isosceles"
        else:
            return "Scalene"

    triangles['triangle_type']=triangles.apply(check, axis=1)
    return triangles[['triangle_type']]

