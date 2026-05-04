#
# Problem: 3182. Find Top Scoring Students
# Difficulty: Medium
# Link: https://leetcode.com/problems/find-top-scoring-students/
# Language: python3
# Date: 2026-05-04


import pandas as pd

def find_top_scoring_students(enrollments: pd.DataFrame, students: pd.DataFrame, courses: pd.DataFrame) -> pd.DataFrame:
    enrollments=pd.merge(enrollments, students, how='inner', on='student_id')
    enrollments=enrollments[enrollments['grade']=='A']
    enrollments=pd.merge(courses, enrollments, how='inner', on=['course_id', 'major'])
    enrollments=enrollments.groupby(['student_id', 'major']).size().reset_index(name='count')
    courses=courses.groupby('major').size().reset_index(name='count')
    enrollments=pd.merge(enrollments, courses, how='inner', on='major')
    enrollments=enrollments[enrollments['count_x']==enrollments['count_y']]
    return enrollments[['student_id']].sort_values(by='student_id')
