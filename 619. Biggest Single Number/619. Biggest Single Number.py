#
# Problem: 619. Biggest Single Number
# Difficulty: Easy
# Link: https://leetcode.com/problems/biggest-single-number/
# Language: python3
# Date: 2026-04-05


import pandas as pd

def biggest_single_number(my_numbers: pd.DataFrame) -> pd.DataFrame:
    return my_numbers.drop_duplicates(keep=False).max().to_frame('num')
