#
# Problem: 2686. Immediate Food Delivery III
# Difficulty: Medium
# Link: https://leetcode.com/problems/immediate-food-delivery-iii/
# Language: python3
# Date: 2026-04-29


import pandas as pd

def immediate_delivery(delivery: pd.DataFrame) -> pd.DataFrame:
    delivery['im']=delivery.apply(lambda row: 1 if row['order_date']==row['customer_pref_delivery_date'] else 0, axis=1)
    delivery['total']=1
    delivery=delivery.groupby('order_date').agg({'im': 'sum', 'total': 'sum'}).reset_index()
    delivery['immediate_percentage']=(delivery['im']/delivery['total']*100).round(2)
    return delivery[['order_date', 'immediate_percentage']]
