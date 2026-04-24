#
# Problem: 2112. The Airport With the Most Traffic
# Difficulty: Medium
# Link: https://leetcode.com/problems/the-airport-with-the-most-traffic/
# Language: python3
# Date: 2026-04-24


import pandas as pd

def airport_with_most_traffic(flights: pd.DataFrame) -> pd.DataFrame:
    df1=flights.groupby('departure_airport')['flights_count'].sum().reset_index(name='sum').rename(columns={'departure_airport': 'airport_id'})
    df2=flights.groupby('arrival_airport')['flights_count'].sum().reset_index(name='sum').rename(columns={'arrival_airport': 'airport_id'})
    df=pd.concat([df1, df2])
    df=df.groupby('airport_id')['sum'].sum().reset_index()
    df=df[df['sum']==df['sum'].max()]
    return df[['airport_id']]
