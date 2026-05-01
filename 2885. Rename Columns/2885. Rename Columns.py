#
# Problem: 2885. Rename Columns
# Difficulty: Easy
# Link: https://leetcode.com/problems/rename-columns/
# Language: python3
# Date: 2026-05-01


import pandas as pd

def renameColumns(students: pd.DataFrame) -> pd.DataFrame:
    students.rename(columns={'id': 'student_id', 'first': 'first_name', 'last': 'last_name', 'age': 'age_in_years'}, inplace=True)
    return students
