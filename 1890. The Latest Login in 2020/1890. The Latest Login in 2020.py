#
# Problem: 1890. The Latest Login in 2020
# Difficulty: Easy
# Link: https://leetcode.com/problems/the-latest-login-in-2020/
# Language: python3
# Date: 2026-04-21


import pandas as pd

def latest_login(logins: pd.DataFrame) -> pd.DataFrame:
    logins=logins[logins['time_stamp'].dt.year==2020].sort_values(by='time_stamp').groupby('user_id')['time_stamp'].last().reset_index(name='last_stamp')
    return logins
