#
# Problem: 2205. The Number of Users That Are Eligible for Discount
# Difficulty: Easy
# Link: https://leetcode.com/problems/the-number-of-users-that-are-eligible-for-discount/
# Language: python3
# Date: 2026-04-25


import pandas as pd
from datetime import datetime

def count_valid_users(purchases: pd.DataFrame, start_date: datetime, end_date: datetime, min_amount: int) -> pd.DataFrame:
    purchases=purchases[
        (purchases['time_stamp']>=start_date)&
        (purchases['time_stamp']<=end_date)&
        (purchases['amount']>=min_amount)
    ]
    return pd.DataFrame({'user_cnt': [purchases['user_id'].nunique()]})
