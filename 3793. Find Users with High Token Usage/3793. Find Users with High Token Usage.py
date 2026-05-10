#
# Problem: 3793. Find Users with High Token Usage
# Difficulty: Easy
# Link: https://leetcode.com/problems/find-users-with-high-token-usage/
# Language: python3
# Date: 2026-05-10


import pandas as pd

def find_users_with_high_tokens(prompts: pd.DataFrame) -> pd.DataFrame:
    prompts=prompts.groupby('user_id').agg(prompt_count=('prompt', 'size'), avg_tokens=('tokens', 'mean'), count=('tokens', 'nunique')).reset_index()
    prompts=prompts[(prompts['prompt_count']>=3) & (prompts['count']>1)]
    prompts['avg_tokens']=prompts['avg_tokens'].round(2)
    return prompts[['user_id', 'prompt_count', 'avg_tokens']].sort_values(by=['avg_tokens', 'user_id'], ascending=[False, True])
