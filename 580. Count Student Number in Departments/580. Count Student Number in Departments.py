#
# Problem: 580. Count Student Number in Departments
# Difficulty: Medium
# Link: https://leetcode.com/problems/count-student-number-in-departments/
# Language: python3
# Date: 2026-04-04


import pandas as pd

def count_students(student: pd.DataFrame, department: pd.DataFrame) -> pd.DataFrame:
    student=student.groupby('dept_id').size().reset_index(name='student_number')
    department=pd.merge(department, student, how='left', on='dept_id').fillna(0)
    return department[['dept_name', 'student_number']].sort_values(by=['student_number', 'dept_name'], ascending=[False, True])
