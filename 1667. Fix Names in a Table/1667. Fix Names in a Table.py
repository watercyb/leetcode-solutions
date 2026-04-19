#
# Problem: 1667. Fix Names in a Table
# Difficulty: Easy
# Link: https://leetcode.com/problems/fix-names-in-a-table/
# Language: python3
# Date: 2026-04-19


import pandas as pd

def fix_names(users: pd.DataFrame) -> pd.DataFrame:
    users['name'] = users['name'].str[0].str.upper() + users['name'].str[1:].str.lower()
    return users.sort_values(by='user_id')
