#
# Problem: 1484. Group Sold Products By The Date
# Difficulty: Easy
# Link: https://leetcode.com/problems/group-sold-products-by-the-date/
# Language: python3
# Date: 2026-04-17


import pandas as pd

def categorize_products(activities: pd.DataFrame) -> pd.DataFrame:
    activities = activities.drop_duplicates(['sell_date', 'product'])
    activities=activities.groupby('sell_date').agg(num_sold=('product', 'size'), products=('product', lambda x: ','.join(sorted(set(x))))).reset_index()
    return activities
