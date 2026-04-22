#
# Problem: 1988. Find Cutoff Score for Each School
# Difficulty: Medium
# Link: https://leetcode.com/problems/find-cutoff-score-for-each-school/
# Language: python3
# Date: 2026-04-22


import pandas as pd

def find_cutoff_score(schools: pd.DataFrame, exam: pd.DataFrame) -> pd.DataFrame:
    df=pd.merge(schools, exam, how='cross')
    df=df[df['capacity']>=df['student_count']]
    df=df.groupby('school_id')['score'].min().reset_index()
    schools=pd.merge(schools, df, how='left', on='school_id').fillna(-1)
    return schools[['school_id', 'score']]
