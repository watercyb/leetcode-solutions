#
# Problem: 175. Combine Two Tables
# Difficulty: Easy
# Link: https://leetcode.com/problems/combine-two-tables/
# Language: python3
# Date: 2026-03-26


import pandas as pd

def combine_two_tables(person: pd.DataFrame, address: pd.DataFrame) -> pd.DataFrame:
    return pd.merge(person, address, how='left', on='personId')[['firstName', 'lastName', 'city', 'state']]
