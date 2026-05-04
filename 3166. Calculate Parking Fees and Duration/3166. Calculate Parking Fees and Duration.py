#
# Problem: 3166. Calculate Parking Fees and Duration
# Difficulty: Medium
# Link: https://leetcode.com/problems/calculate-parking-fees-and-duration/
# Language: python3
# Date: 2026-05-04


import pandas as pd

def calculate_fees_and_duration(parking_transactions: pd.DataFrame) -> pd.DataFrame:
    parking_transactions['time']=parking_transactions['exit_time']-parking_transactions['entry_time']
    parking_transactions=parking_transactions.groupby(['car_id', 'lot_id']).agg({'time': 'sum', 'fee_paid': 'sum'}).reset_index()
    df=parking_transactions.sort_values(by='time', ascending=False).groupby('car_id').head(1)
    parking_transactions=parking_transactions.groupby('car_id').agg({'time': 'sum', 'fee_paid': 'sum'}).reset_index()
    parking_transactions['avg_hourly_fee']=(parking_transactions['fee_paid']/parking_transactions['time'].dt.total_seconds()*3600).round(2)
    parking_transactions=pd.merge(parking_transactions, df, how='inner', on='car_id')
    return parking_transactions[['car_id', 'fee_paid_x', 'avg_hourly_fee', 'lot_id']].rename(columns={'fee_paid_x': 'total_fee_paid', 'lot_id': 'most_time_lot'})

