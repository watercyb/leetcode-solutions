#
# Problem: 1715. Count Apples and Oranges
# Difficulty: Medium
# Link: https://leetcode.com/problems/count-apples-and-oranges/
# Language: python3
# Date: 2026-04-20


import pandas as pd

def count_apples_and_oranges(boxes: pd.DataFrame, chests: pd.DataFrame) -> pd.DataFrame:
    df=pd.merge(boxes[['chest_id']], chests, how='inner', on='chest_id')
    return pd.DataFrame({'apple_count': [boxes['apple_count'].sum()+df['apple_count'].sum()], 'orange_count': [boxes['orange_count'].sum()+df['orange_count'].sum()]})
