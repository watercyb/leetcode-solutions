#
# Problem: 2886. Change Data Type
# Difficulty: Easy
# Link: https://leetcode.com/problems/change-data-type/
# Language: python3
# Date: 2026-05-01


import pandas as pd

def changeDatatype(students: pd.DataFrame) -> pd.DataFrame:
    students['grade']=students['grade'].astype(int)
    return students
