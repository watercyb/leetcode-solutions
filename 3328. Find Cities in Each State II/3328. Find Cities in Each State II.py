#
# Problem: 3328. Find Cities in Each State II
# Difficulty: Medium
# Link: https://leetcode.com/problems/find-cities-in-each-state-ii/?envType=problem-list-v2&envId=ne414q67
# Language: python3
# Date: 2026-04-02


import pandas as pd

def state_city_analysis(cities: pd.DataFrame) -> pd.DataFrame:
    cities=cities.sort_values(by='city')
    cities['matching_letter_count']=cities.apply(lambda row: 1 if row['state'][0]==row['city'][0] else 0, axis=1)
    cities=cities.groupby('state').agg(cities=('city', ', '.join), count=('city', 'size'), matching_letter_count=('matching_letter_count', 'sum')).reset_index()
    cities=cities[(cities['matching_letter_count']>0) & (cities['count']>=3)]
    return cities[['state', 'cities', 'matching_letter_count']].sort_values(by=['matching_letter_count', 'state'],  ascending=[False, True])
