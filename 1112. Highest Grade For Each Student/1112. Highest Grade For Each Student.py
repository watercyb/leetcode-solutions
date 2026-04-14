#
# Problem: 1112. Highest Grade For Each Student
# Difficulty: Medium
# Link: https://leetcode.com/problems/highest-grade-for-each-student/
# Language: python3
# Date: 2026-04-14


import pandas as pd

def highest_grade(enrollments: pd.DataFrame) -> pd.DataFrame:
    enrollments=enrollments.sort_values(by=['grade', 'course_id'], ascending=[False, True])
    enrollments=enrollments.groupby('student_id').first().reset_index()
    return enrollments
