#
# Problem: 2888. Reshape Data: Concatenate
# Difficulty: Easy
# Link: https://leetcode.com/problems/reshape-data-concatenate/
# Language: python3
# Date: 2026-05-01


import pandas as pd

def concatenateTables(df1: pd.DataFrame, df2: pd.DataFrame) -> pd.DataFrame:
    return pd.concat([df1, df2], axis=0)
