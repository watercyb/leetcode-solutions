#
# Problem: 2298. Tasks Count in the Weekend
# Difficulty: Medium
# Link: https://leetcode.com/problems/tasks-count-in-the-weekend/
# Language: python3
# Date: 2026-04-25


import pandas as pd

def count_tasks(tasks: pd.DataFrame) -> pd.DataFrame:
    a=tasks[tasks['submit_date'].dt.weekday<=4].shape[0]
    b=tasks.shape[0]-a
    return pd.DataFrame({'weekend_cnt': [a], 'working_cnt': [b]})
