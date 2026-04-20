#
# Problem: 1767. Find the Subtasks That Did Not Execute
# Difficulty: Hard
# Link: https://leetcode.com/problems/find-the-subtasks-that-did-not-execute/
# Language: python3
# Date: 2026-04-20


import pandas as pd

def find_subtasks(tasks: pd.DataFrame, executed: pd.DataFrame) -> pd.DataFrame:
    mp={}
    for _, row in tasks.iterrows():
        mp[row['task_id']]=set([i for i in range(1, row['subtasks_count']+1)])
    for _, row in executed.iterrows():
        mp[row['task_id']].remove(row['subtask_id'])
    df=pd.DataFrame()
    for k, v in mp.items():
        df=pd.concat([df, pd.DataFrame({'task_id': k, 'subtask_id': list(v)})])
    return df
