#
# Problem: 2159. Order Two Columns Independently
# Difficulty: Medium
# Link: https://leetcode.com/problems/order-two-columns-independently/
# Language: python3
# Date: 2026-04-24


import pandas as pd

def order_two_columns(data: pd.DataFrame) -> pd.DataFrame:
    return pd.DataFrame({'first_col': data['first_col'].sort_values().to_numpy(), 'second_col': data['second_col'].sort_values(ascending=False).to_numpy()})
