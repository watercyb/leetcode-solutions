#
# Problem: 2877. Create a DataFrame from List
# Difficulty: Easy
# Link: https://leetcode.com/problems/create-a-dataframe-from-list/
# Language: python3
# Date: 2026-05-01


import pandas as pd

def createDataframe(student_data: List[List[int]]) -> pd.DataFrame:
    df = pd.DataFrame(student_data, columns=['student_id','age'])
    return df
