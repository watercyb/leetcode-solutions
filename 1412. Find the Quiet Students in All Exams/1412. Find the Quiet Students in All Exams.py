#
# Problem: 1412. Find the Quiet Students in All Exams
# Difficulty: Hard
# Link: https://leetcode.com/problems/find-the-quiet-students-in-all-exams/
# Language: python3
# Date: 2026-04-17


import pandas as pd

def find_quiet_students(student: pd.DataFrame, exam: pd.DataFrame) -> pd.DataFrame:
    exam=exam.sort_values(by='score')
    student=student[student['student_id'].isin(exam['student_id'])]
    student=student[~student['student_id'].isin(exam.groupby('exam_id', group_keys=False).apply(lambda g: g[g['score'] == g['score'].max()])['student_id'])]
    student=student[~student['student_id'].isin(exam.groupby('exam_id', group_keys=False).apply(lambda g: g[g['score'] == g['score'].min()])['student_id'])]
    return student.sort_values(by='student_id')
