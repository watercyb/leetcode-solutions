#
# Problem: 2985. Calculate Compressed Mean
# Difficulty: Easy
# Link: https://leetcode.com/problems/calculate-compressed-mean/
# Language: python3
# Date: 2026-05-02


import pandas as pd

def compressed_mean(orders: pd.DataFrame) -> pd.DataFrame:
    a=(orders['item_count']*orders['order_occurrences']).sum()
    b=orders['order_occurrences'].sum()
    return pd.DataFrame({'average_items_per_order': [(a/b).round(2)]})
