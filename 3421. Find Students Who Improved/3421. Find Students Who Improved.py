#
# Problem: 3421. Find Students Who Improved
# Difficulty: Medium
# Link: https://leetcode.com/problems/find-students-who-improved/
# Language: python3
# Date: 2026-05-07


import pandas as pd

def find_students_who_improved(scores: pd.DataFrame) -> pd.DataFrame:
    scores=scores.sort_values(by=['student_id', 'subject', 'exam_date'])
    scores=scores.groupby(['student_id', 'subject']).agg(first_score=('score', 'first'), latest_score=('score', 'last')).reset_index()
    return scores[scores['first_score']<scores['latest_score']]
