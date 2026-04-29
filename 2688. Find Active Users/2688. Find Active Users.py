#
# Problem: 2688. Find Active Users
# Difficulty: Medium
# Link: https://leetcode.com/problems/find-active-users/
# Language: python3
# Date: 2026-04-29


import pandas as pd

def find_active_users(users: pd.DataFrame) -> pd.DataFrame:
    users=users.sort_values(by=['user_id', 'created_at'])
    users['prv']=users['user_id'].shift(1)
    users['prv_date']=users['created_at'].shift(1)
    users=users[(users['prv']==users['user_id']) & ((users['created_at']-users['prv_date']).dt.days<=7)]
    return users[['user_id']].drop_duplicates()
