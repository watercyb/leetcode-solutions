#
# Problem: 2887. Fill Missing Data
# Difficulty: Easy
# Link: https://leetcode.com/problems/fill-missing-data/
# Language: python3
# Date: 2026-05-01


import pandas as pd

def fillMissingValues(products: pd.DataFrame) -> pd.DataFrame:
    products["quantity"].fillna(0, inplace=True)
    return products
