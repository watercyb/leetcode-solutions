#
# Problem: 1613. Find the Missing IDs
# Difficulty: Medium
# Link: https://leetcode.com/problems/find-the-missing-ids/
# Language: python3
# Date: 2026-04-19


import pandas as pd

def find_missing_ids(customers: pd.DataFrame) -> pd.DataFrame:
    max_num=customers['customer_id'].max()
    df=pd.DataFrame({'ids':[i for i in range(1, max_num+1)]})
    df=df[~df['ids'].isin(customers['customer_id'])]
    return df
