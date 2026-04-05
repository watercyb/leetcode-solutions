#
# Problem: 626. Exchange Seats
# Difficulty: Medium
# Link: https://leetcode.com/problems/exchange-seats/
# Language: python3
# Date: 2026-04-05


import pandas as pd

def exchange_seats(seat: pd.DataFrame) -> pd.DataFrame:
    seat['id']=((seat['id']+1)^1)-1
    seat=seat.sort_values('id')
    seat['id'] = range(1, len(seat) + 1)
    return seat
