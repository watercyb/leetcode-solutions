#
# Problem: 2072. The Winner University
# Difficulty: Easy
# Link: https://leetcode.com/problems/the-winner-university/
# Language: python3
# Date: 2026-04-23


import pandas as pd

def find_winner(new_york: pd.DataFrame, california: pd.DataFrame) -> pd.DataFrame:
    new_york=new_york[new_york['score']>=90]
    california=california[california['score']>=90]
    if new_york.shape[0]>california.shape[0]:
        return pd.DataFrame({'winner': ['New York University']})
    elif new_york.shape[0]<california.shape[0]:
        return pd.DataFrame({'winner': ['California University']})
    else:
        return pd.DataFrame({'winner': ['No Winner']})
