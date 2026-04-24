#
# Problem: 2153. The Number of Passengers in Each Bus II
# Difficulty: Hard
# Link: https://leetcode.com/problems/the-number-of-passengers-in-each-bus-ii/
# Language: python3
# Date: 2026-04-24


import pandas as pd

def number_of_passengers(buses: pd.DataFrame, passengers: pd.DataFrame) -> pd.DataFrame:
    buses=buses.sort_values(by='arrival_time').reset_index()
    passengers=passengers.sort_values(by='arrival_time').reset_index()
    arr=[]
    prv=0
    j=0
    for i in range(buses.shape[0]):
        count=0
        while j<passengers.shape[0] and passengers.loc[j,'arrival_time']<=buses.loc[i,'arrival_time'] and count<buses.loc[i,'capacity']:
            count+=1
            j+=1
        arr.append(count)
    buses['passengers_cnt']=arr
    return buses[['bus_id', 'passengers_cnt']].sort_values(by='bus_id')
