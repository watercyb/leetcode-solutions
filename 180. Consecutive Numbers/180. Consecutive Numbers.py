#
# Problem: 180. Consecutive Numbers
# Difficulty: Medium
# Link: https://leetcode.com/problems/consecutive-numbers/
# Language: python3
# Date: 2026-03-26


import pandas as pd

def consecutive_numbers(logs: pd.DataFrame) -> pd.DataFrame:
    return logs[(logs['num']==logs['num'].shift(1)) & (logs['num']==logs['num'].shift(2))][['num']].drop_duplicates().rename(columns={'num': 'ConsecutiveNums'})
