#
# Problem: 1113. Reported Posts
# Difficulty: Easy
# Link: https://leetcode.com/problems/reported-posts/
# Language: python3
# Date: 2026-04-14


import pandas as pd

def reported_posts(actions: pd.DataFrame) -> pd.DataFrame:
    actions=actions[(actions['action_date']=='2019-07-04') & (actions['action']=='report')]
    actions=actions.groupby('extra')['post_id'].nunique().reset_index(name='report_count')
    return actions.rename(columns={'extra': 'report_reason'})
