#
# Problem: 3140. Consecutive Available Seats II
# Difficulty: Medium
# Link: https://leetcode.com/problems/consecutive-available-seats-ii/
# Language: python3
# Date: 2026-05-04


import pandas as pd

def consecutive_available_seats(cinema: pd.DataFrame) -> pd.DataFrame:
    cinema=cinema.sort_values(by='seat_id')
    cinema['r']=cinema['seat_id']-cinema['free'].cumsum()
    cinema=cinema[cinema['free']==1]
    cinema=cinema.groupby('r').agg(first_seat_id=('seat_id', 'min'), last_seat_id=('seat_id', 'max'), consecutive_seats_len=('seat_id', 'size'))
    cinema=cinema[cinema['consecutive_seats_len']==cinema['consecutive_seats_len'].max()]
    return cinema.sort_values(by='first_seat_id')
