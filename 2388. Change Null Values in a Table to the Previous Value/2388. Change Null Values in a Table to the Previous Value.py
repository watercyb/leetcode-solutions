#
# Problem: 2388. Change Null Values in a Table to the Previous Value
# Difficulty: Medium
# Link: https://leetcode.com/problems/change-null-values-in-a-table-to-the-previous-value/
# Language: python3
# Date: 2026-04-26


import pandas as pd

def change_null_values(coffee_shop: pd.DataFrame) -> pd.DataFrame:
    coffee_shop['drink'] = coffee_shop['drink'].ffill()
    return coffee_shop
