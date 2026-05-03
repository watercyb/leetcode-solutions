#
# Problem: 3051. Find Candidates for Data Scientist Position
# Difficulty: Easy
# Link: https://leetcode.com/problems/find-candidates-for-data-scientist-position/
# Language: python3
# Date: 2026-05-03


import pandas as pd

def find_candidates(candidates: pd.DataFrame) -> pd.DataFrame:
    candidates['type']=candidates['skill'].apply(lambda x: 1 if x=='Python' else 2 if x=='Tableau' else 4 if x=='PostgreSQL' else 0)
    candidates=candidates.groupby('candidate_id')['type'].agg(lambda c: reduce(lambda x, y: x | y, c)).reset_index()
    candidates=candidates[candidates['type']==7]
    return candidates[['candidate_id']].sort_values(by='candidate_id')
