#
# Problem: 1132. Reported Posts II
# Difficulty: Medium
# Link: https://leetcode.com/problems/reported-posts-ii/
# Language: python3
# Date: 2026-04-14


import pandas as pd

def reported_posts(actions: pd.DataFrame, removals: pd.DataFrame) -> pd.DataFrame:
    actions=actions[actions['extra']=='spam'][['post_id', 'action_date']].drop_duplicates()
    actions=pd.merge(actions, removals, how='left', on='post_id').fillna(0)
    actions['rm']=actions['post_id'].apply(lambda x: 1 if x in removals['post_id'].values else 0)
    actions=actions.groupby('action_date').agg(total=('rm', 'size'), removed=('rm', 'sum')).reset_index()
    actions['average_daily_percent']=(actions['removed']/actions['total']*100)
    return pd.DataFrame({'average_daily_percent': [actions['average_daily_percent'].mean().round(2)]})
