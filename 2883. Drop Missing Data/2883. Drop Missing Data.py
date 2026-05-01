#
# Problem: 2883. Drop Missing Data
# Difficulty: Easy
# Link: https://leetcode.com/problems/drop-missing-data/
# Language: python3
# Date: 2026-05-01


import pandas as pd

def dropMissingData(students: pd.DataFrame) -> pd.DataFrame:
    students.dropna(subset=['name'], inplace=True)
    return students
