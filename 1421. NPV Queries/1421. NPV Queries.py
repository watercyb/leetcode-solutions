#
# Problem: 1421. NPV Queries
# Difficulty: Easy
# Link: https://leetcode.com/problems/npv-queries/
# Language: python3
# Date: 2026-04-17


import pandas as pd

def npv_queries(npv: pd.DataFrame, queries: pd.DataFrame) -> pd.DataFrame:
    return pd.merge(queries, npv, on=['id','year'], how='left').fillna(0)
