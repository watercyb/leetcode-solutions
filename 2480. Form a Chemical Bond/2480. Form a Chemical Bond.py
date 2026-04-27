#
# Problem: 2480. Form a Chemical Bond
# Difficulty: Easy
# Link: https://leetcode.com/problems/form-a-chemical-bond/
# Language: python3
# Date: 2026-04-27


import pandas as pd

def form_bond(elements: pd.DataFrame) -> pd.DataFrame:
    df1=elements[elements['type']=='Metal'][['symbol']].rename(columns={'symbol': 'metal'})
    df2=elements[elements['type']=='Nonmetal'][['symbol']].rename(columns={'symbol': 'nonmetal'})
    return pd.merge(df1, df2, how='cross')
