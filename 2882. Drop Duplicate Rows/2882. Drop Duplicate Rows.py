#
# Problem: 2882. Drop Duplicate Rows
# Difficulty: Easy
# Link: https://leetcode.com/problems/drop-duplicate-rows/
# Language: python3
# Date: 2026-05-01


import pandas as pd

def dropDuplicateEmails(customers: pd.DataFrame) -> pd.DataFrame:
    customers.drop_duplicates(subset=['email'], inplace=True)
    return customers
