#
# Problem: 3617. Find Students with Study Spiral Pattern
# Difficulty: Hard
# Link: https://leetcode.com/problems/find-students-with-study-spiral-pattern/
# Language: python3
# Date: 2026-05-09


import pandas as pd

def find_study_spiral_pattern(students: pd.DataFrame, study_sessions: pd.DataFrame) -> pd.DataFrame:
    df=study_sessions[['student_id', 'session_date']]
    df['prv'] = df.groupby('student_id')['session_date'].shift(1)
    df['diff']=(pd.to_datetime(df['session_date'])-pd.to_datetime(df['prv'])).dt.days
    df=df[(df['diff'] is not None) & (df['diff']>2)][['student_id']].drop_duplicates()
    study_sessions=study_sessions[~study_sessions['student_id'].isin(df['student_id'])]
    study_sessions=study_sessions[['student_id', 'subject', 'hours_studied']].groupby(['student_id', 'subject'])['hours_studied'].agg(['sum', 'count']).reset_index()
    study_sessions=study_sessions.groupby(['student_id']).agg(
        cycle_length=('subject', 'count'),
        total_study_hours=('sum', 'sum'),
        mean=('count', 'mean'),
        nunique=('count', 'nunique')
    ).reset_index()
    study_sessions=study_sessions[(study_sessions['nunique']==1) & (study_sessions['mean']>=2) & (study_sessions['cycle_length']>=3)]
    study_sessions=pd.merge(study_sessions, students, how='inner', on='student_id')[['student_id', 'student_name', 'major', 'cycle_length', 'total_study_hours']].sort_values(by=['cycle_length', 'total_study_hours'], ascending=[False, False])
    return study_sessions
