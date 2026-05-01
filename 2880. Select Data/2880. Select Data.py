#
# Problem: 2880. Select Data
# Difficulty: Easy
# Link: https://leetcode.com/problems/select-data/
# Language: python3
# Date: 2026-05-01


import pandas as pd

def selectData(students: pd.DataFrame) -> pd.DataFrame:
    return students.loc[students['student_id'] == 101, ['name', 'age']]
