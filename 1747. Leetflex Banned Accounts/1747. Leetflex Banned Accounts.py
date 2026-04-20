#
# Problem: 1747. Leetflex Banned Accounts
# Difficulty: Medium
# Link: https://leetcode.com/problems/leetflex-banned-accounts/
# Language: python3
# Date: 2026-04-20


import pandas as pd

def leetflex_banned_accnts(log_info: pd.DataFrame) -> pd.DataFrame:
    log_info=pd.merge(log_info, log_info, how='inner', on='account_id')
    log_info=log_info[(log_info['ip_address_x']!=log_info['ip_address_y']) & ~((log_info['logout_y']<log_info['login_x']) | (log_info['logout_x']<log_info['login_y']))]
    return log_info[['account_id']].drop_duplicates()
