#
# Problem: 2793. Status of Flight Tickets
# Difficulty: Hard
# Link: https://leetcode.com/problems/status-of-flight-tickets/
# Language: python3
# Date: 2026-04-30


import pandas as pd

def ticket_status(flights: pd.DataFrame, passengers: pd.DataFrame) -> pd.DataFrame:
    passengers=passengers.sort_values(by='booking_time')
    passengers['c']=passengers.groupby('flight_id').transform('cumcount')
    df=pd.merge(passengers, flights, how='inner', on='flight_id')
    df['Status']=df.apply(lambda row: 'Confirmed' if row['capacity']>=row['c']+1 else 'Waitlist', axis=1)
    return df[['passenger_id', 'Status']].sort_values(by='passenger_id')
