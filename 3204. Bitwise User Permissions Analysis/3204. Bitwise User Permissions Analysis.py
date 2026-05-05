#
# Problem: 3204. Bitwise User Permissions Analysis
# Difficulty: Medium
# Link: https://leetcode.com/problems/bitwise-user-permissions-analysis/
# Language: python3
# Date: 2026-05-05


import pandas as pd

def analyze_permissions(user_permissions: pd.DataFrame) -> pd.DataFrame:
    num_and=(1<<30)-1
    num_or=0
    for p in user_permissions['permissions']:
        num_and&=p
        num_or|=p
    return pd.DataFrame({'common_perms': [num_and], 'any_perms': [num_or]})
