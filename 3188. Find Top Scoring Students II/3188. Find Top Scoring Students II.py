#
# Problem: 3188. Find Top Scoring Students II
# Difficulty: Hard
# Link: https://leetcode.com/problems/find-top-scoring-students-ii/
# Language: python3
# Date: 2026-05-04


import pandas as pd

def find_top_scoring_students(students: pd.DataFrame, courses: pd.DataFrame, enrollments: pd.DataFrame) -> pd.DataFrame:
    students=pd.merge(students[['student_id', 'major']], courses, how='inner', on='major')
    students=pd.merge(students, enrollments[['student_id', 'course_id', 'grade', 'GPA']], how='inner', on=['student_id', 'course_id'])
    students['h']=students.apply(lambda row: 100000 if (row['mandatory']=='Yes') & (row['grade']=='A') else 1 if (row['mandatory']=='No') & ((row['grade']=='A') | (row['grade']=='B')) else -10000000, axis=1)
    students=students.groupby(['student_id', 'major']).agg({'h': 'sum', 'GPA': 'mean'}).reset_index()
    courses['h']=courses.apply(lambda row: 100000 if row['mandatory']=='Yes' else 0, axis=1)
    courses=courses.groupby('major')['h'].sum().reset_index()
    students=pd.merge(students, courses, how='inner', on='major')
    students=students[(students['h_x']>students['h_y']) & (students['h_x']%100000>=2)]
    return students[['student_id']].sort_values(by='student_id')
