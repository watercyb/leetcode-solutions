#
# Problem: 1729. Find Followers Count
# Difficulty: Easy
# Link: https://leetcode.com/problems/find-followers-count/
# Language: python3
# Date: 2026-04-20


import pandas as pd

def count_followers(followers: pd.DataFrame) -> pd.DataFrame:
    followers=followers.groupby('user_id').agg(followers_count=('follower_id', 'size')).reset_index()
    return followers.sort_values(by='user_id')
