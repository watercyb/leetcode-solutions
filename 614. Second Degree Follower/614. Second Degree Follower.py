#
# Problem: 614. Second Degree Follower
# Difficulty: Medium
# Link: https://leetcode.com/problems/second-degree-follower/
# Language: python3
# Date: 2026-04-05


import pandas as pd

def second_degree_follower(follow: pd.DataFrame) -> pd.DataFrame:
    follow=follow[follow['followee'].isin(follow['follower'])]
    follow=follow.groupby('followee')['follower'].size().reset_index(name='num')
    return follow.rename(columns={'followee': 'follower'}).sort_values(by='follower')
