#
# Problem: 585. Investments in 2016
# Difficulty: Medium
# Link: https://leetcode.com/problems/investments-in-2016/
# Language: python3
# Date: 2026-04-04


import pandas as pd

def find_investments(insurance: pd.DataFrame) -> pd.DataFrame:
    insurance['count'] = insurance.groupby(['lat', 'lon']).transform('size')
    insurance['count1'] = insurance.groupby('tiv_2015').transform('size')
    insurance=insurance[(insurance['count']==1) & (insurance['count1']>1)]
    insurance=insurance['tiv_2016'].sum(numeric_only=True).round(2)
    return pd.DataFrame({'tiv_2016': [insurance]})
