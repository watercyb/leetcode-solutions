#
# Problem: 3052. Maximize Items
# Difficulty: Hard
# Link: https://leetcode.com/problems/maximize-items/
# Language: python3
# Date: 2026-05-03


import pandas as pd

def maximize_items(inventory: pd.DataFrame) -> pd.DataFrame:
    df1=inventory[inventory['item_type']=='prime_eligible']
    size1=df1.shape[0]
    sum1=df1['square_footage'].sum()
    df2=inventory[inventory['item_type']=='not_prime']
    size2=df2.shape[0]
    sum2=df2['square_footage'].sum()
    count1=500000//sum1
    count2=(500000-count1*sum1)//sum2
    return pd.DataFrame({'item_type': ['prime_eligible', 'not_prime'], 'item_count': [count1*size1, count2*size2]})
