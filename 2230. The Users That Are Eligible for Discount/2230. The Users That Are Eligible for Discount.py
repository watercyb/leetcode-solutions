#
# Problem: 2230. The Users That Are Eligible for Discount
# Difficulty: Easy
# Link: https://leetcode.com/problems/the-users-that-are-eligible-for-discount/
# Language: python3
# Date: 2026-04-25


import pandas as pd
from datetime import datetime

def find_valid_users(purchases: pd.DataFrame, start_date: datetime, end_date: datetime, min_amount: int) -> pd.DataFrame:
    purchases=purchases[(purchases['time_stamp']>=start_date) & (purchases['time_stamp']<=end_date) & (purchases['amount']>=min_amount)]
    return purchases[['user_id']].drop_duplicates().sort_values(by='user_id')
