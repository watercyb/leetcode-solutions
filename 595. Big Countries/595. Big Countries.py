#
# Problem: 595. Big Countries
# Difficulty: Easy
# Link: https://leetcode.com/problems/big-countries/
# Language: python3
# Date: 2026-04-04


import pandas as pd

def big_countries(world: pd.DataFrame) -> pd.DataFrame:
    return world[(world['area']>=3000000)|(world['population']>=25000000)][['name','population','area']]
