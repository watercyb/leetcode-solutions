#
# Problem: 2377. Sort the Olympic Table
# Difficulty: Easy
# Link: https://leetcode.com/problems/sort-the-olympic-table/
# Language: python3
# Date: 2026-04-26


import pandas as pd

def sort_table(olympic: pd.DataFrame) -> pd.DataFrame:
    olympic=olympic.sort_values(by=['gold_medals', 'silver_medals', 'bronze_medals', 'country'], ascending=[False, False, False, True])
    return olympic
