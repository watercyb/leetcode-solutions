#
# Problem: 603. Consecutive Available Seats
# Difficulty: Easy
# Link: https://leetcode.com/problems/consecutive-available-seats/
# Language: python3
# Date: 2026-04-05


import pandas as pd

def consecutive_available_seats(cinema: pd.DataFrame) -> pd.DataFrame:
    cinema=cinema.sort_values(by='seat_id')
    cinema['group']=cinema['free'].cumsum()-cinema['seat_id']
    cinema=cinema[cinema['free']==1]
    cinema['count']=cinema.groupby('group')['seat_id'].transform('size')
    return cinema[cinema['count']>=2][['seat_id']]
