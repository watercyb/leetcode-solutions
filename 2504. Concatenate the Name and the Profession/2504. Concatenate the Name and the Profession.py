#
# Problem: 2504. Concatenate the Name and the Profession
# Difficulty: Easy
# Link: https://leetcode.com/problems/concatenate-the-name-and-the-profession/
# Language: python3
# Date: 2026-04-28


import pandas as pd

def concatenate_info(person: pd.DataFrame) -> pd.DataFrame:
    person['name']=person['name']+'('+person['profession'].str[0]+')'
    return person[['person_id', 'name']].sort_values(by='person_id', ascending=False)
