#
# Problem: 2879. Display the First Three Rows
# Difficulty: Easy
# Link: https://leetcode.com/problems/display-the-first-three-rows/
# Language: python3
# Date: 2026-05-01


import pandas as pd

def selectFirstRows(employees: pd.DataFrame) -> pd.DataFrame:
    return employees.head(3);
