#
# Problem: 3705. Find Golden Hour Customers
# Difficulty: Medium
# Link: https://leetcode.com/problems/find-golden-hour-customers/
# Language: python3
# Date: 2026-05-10


import pandas as pd

def find_golden_hour_customers(restaurant_orders: pd.DataFrame) -> pd.DataFrame:
    restaurant_orders['total']=1
    restaurant_orders['ph']=pd.to_datetime(restaurant_orders['order_timestamp']).dt.time
    restaurant_orders['ph']=restaurant_orders['ph'].apply(lambda x: 1 if (x >= time(11, 0) and x <= time(14, 0)) or
        (x >= time(18, 0) and x <= time(21, 0)) else 0)
    restaurant_orders['rtc']=restaurant_orders['order_rating'].apply(lambda x: 1 if not pd.isna(x) else 0)
    restaurant_orders = restaurant_orders.groupby('customer_id').agg(total_orders=('total', 'sum'), peak_hour_percentage=('ph', 'sum'), rtc_count=('rtc', 'sum'), average_rating=('order_rating', 'mean')).reset_index()
    restaurant_orders['peak_hour_percentage']=round(restaurant_orders['peak_hour_percentage']/restaurant_orders['total_orders'],2)*100
    restaurant_orders['average_rating']=round(restaurant_orders['average_rating'], 2)
    restaurant_orders=restaurant_orders[(restaurant_orders['total_orders']>=3) & (restaurant_orders['rtc_count']/restaurant_orders['total_orders']>=0.5) & (restaurant_orders['peak_hour_percentage']>=60) & (restaurant_orders['average_rating']>=4)]
    return restaurant_orders[['customer_id', 'total_orders', 'peak_hour_percentage', 'average_rating']].sort_values(by=['average_rating', 'customer_id'], ascending=[False, False])
