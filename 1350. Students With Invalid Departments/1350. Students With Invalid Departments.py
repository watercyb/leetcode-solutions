#
# Problem: 1350. Students With Invalid Departments
# Difficulty: Easy
# Link: https://leetcode.com/problems/students-with-invalid-departments/
# Language: python3
# Date: 2026-04-16


import pandas as pd

def find_students(departments: pd.DataFrame, students: pd.DataFrame) -> pd.DataFrame:
    students=students[~students['department_id'].isin(departments['id'])]
    return students[['id', 'name']]
