#
# Problem: 2738. Count Occurrences in Text
# Difficulty: Medium
# Link: https://leetcode.com/problems/count-occurrences-in-text/
# Language: python3
# Date: 2026-04-30


import pandas as pd

def count_occurrences(files: pd.DataFrame) -> pd.DataFrame:
    a=files[files['content'].str.contains(r" bull ", regex=True, na=False)].shape[0]
    b=files[files['content'].str.contains(r" bear ", regex=True, na=False)].shape[0]
    return pd.DataFrame({'word':['bull', 'bear'], 'count': [a, b]})
