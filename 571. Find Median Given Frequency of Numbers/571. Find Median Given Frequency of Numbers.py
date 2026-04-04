#
# Problem: 571. Find Median Given Frequency of Numbers
# Difficulty: Hard
# Link: https://leetcode.com/problems/find-median-given-frequency-of-numbers/
# Language: python3
# Date: 2026-04-04


import pandas as pd

def median_frequency(numbers: pd.DataFrame) -> pd.DataFrame:
    numbers=numbers.sort_values(by='num')
    numbers['count']= numbers['frequency'].cumsum()
    max_sum=numbers['count'].max()
    if max_sum%2==0:
        return pd.DataFrame({'median': [(numbers[numbers['count']>=max_sum/2]['num'].min()+numbers[numbers['count']>=max_sum/2+1]['num'].min())/2]})
    else:
        return pd.DataFrame({'median': [ numbers[numbers['count']>=(max_sum+1)/2]['num'].min()]})
    return numbers
