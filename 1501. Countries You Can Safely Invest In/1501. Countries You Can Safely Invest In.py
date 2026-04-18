#
# Problem: 1501. Countries You Can Safely Invest In
# Difficulty: Medium
# Link: https://leetcode.com/problems/countries-you-can-safely-invest-in/
# Language: python3
# Date: 2026-04-18


import pandas as pd

def find_safe_countries(person: pd.DataFrame, country: pd.DataFrame, calls: pd.DataFrame) -> pd.DataFrame:
    person['phone_number']=person['phone_number'].str[:3]
    person=pd.merge(person, country, how='inner', left_on='phone_number', right_on='country_code')
    df1=pd.merge(person, calls, how='inner', left_on='id', right_on='caller_id')[['name_y', 'duration']]
    df2=pd.merge(person, calls, how='inner', left_on='id', right_on='callee_id')[['name_y', 'duration']]
    df=pd.concat([df1, df2])
    df3=df.groupby('name_y')['duration'].mean().reset_index()
    avg=df['duration'].mean()
    return df3[df3['duration']>avg][['name_y']].rename(columns={'name_y': 'country'})
