#
# Problem: 1173. Immediate Food Delivery I
# Difficulty: Easy
# Link: https://leetcode.com/problems/immediate-food-delivery-i/
# Language: python3
# Date: 2026-04-14


import pandas as pd

def food_delivery(delivery: pd.DataFrame) -> pd.DataFrame:
    delivery['count']=delivery.apply(lambda x: 1 if x['order_date']==x['customer_pref_delivery_date'] else 0, axis=1)
    return pd.DataFrame({'immediate_percentage': [(delivery['count'].sum()/len(delivery['count'])*100).round(2)]})
