#
# Problem: 1174. Immediate Food Delivery II
# Difficulty: Medium
# Link: https://leetcode.com/problems/immediate-food-delivery-ii/
# Language: python3
# Date: 2026-04-14


import pandas as pd

def immediate_food_delivery(delivery: pd.DataFrame) -> pd.DataFrame:
    delivery=delivery.sort_values(by='order_date').drop_duplicates(subset='customer_id')
    count = (delivery['order_date'] == delivery['customer_pref_delivery_date']).sum()
    p = (count/delivery.shape[0]*100).round(2)
    return pd.DataFrame({'immediate_percentage': [p]})
