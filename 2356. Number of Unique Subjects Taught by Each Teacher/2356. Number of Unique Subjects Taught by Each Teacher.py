#
# Problem: 2356. Number of Unique Subjects Taught by Each Teacher
# Difficulty: Easy
# Link: https://leetcode.com/problems/number-of-unique-subjects-taught-by-each-teacher/
# Language: python3
# Date: 2026-04-26


import pandas as pd

def count_unique_subjects(teacher: pd.DataFrame) -> pd.DataFrame:
    return teacher.groupby('teacher_id')['subject_id'].nunique().reset_index().rename(columns={'subject_id': 'cnt'})
