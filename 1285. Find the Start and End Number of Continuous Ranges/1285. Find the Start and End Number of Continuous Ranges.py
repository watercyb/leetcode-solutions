#
# Problem: 1285. Find the Start and End Number of Continuous Ranges
# Difficulty: Medium
# Link: https://leetcode.com/problems/find-the-start-and-end-number-of-continuous-ranges/
# Language: python3
# Date: 2026-04-15


import pandas as pd

def find_continuous_ranges(logs: pd.DataFrame) -> pd.DataFrame:
    logs=logs.sort_values(by='log_id', ascending=True)
    logs['rank']=logs['log_id']-[i for i in range(logs.shape[0])]
    logs = logs.groupby('rank')['log_id'].agg(
        start_id='min',
        end_id='max'
    ).reset_index(drop=True)
    return logs
