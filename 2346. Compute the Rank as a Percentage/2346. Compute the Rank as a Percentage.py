#
# Problem: 2346. Compute the Rank as a Percentage
# Difficulty: Medium
# Link: https://leetcode.com/problems/compute-the-rank-as-a-percentage/
# Language: python3
# Date: 2026-04-26


import pandas as pd

def compute_rating(students: pd.DataFrame) -> pd.DataFrame:
    students['rank']=students.groupby('department_id')['mark'].transform('rank', method='min', ascending=False)
    students['total']=students.groupby('department_id')['mark'].transform('size')
    students['percentage']=((students['rank']-1)/(students['total'].replace(1, 2)-1)*100).round(2)
    students['percentage'] = students['percentage'].fillna(0)
    return students[['student_id', 'department_id', 'percentage']]
