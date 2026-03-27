#
# Problem: 3278. Find Candidates for Data Scientist Position II
# Difficulty: Medium
# Link: https://leetcode.com/problems/find-candidates-for-data-scientist-position-ii/?envType=problem-list-v2&envId=ne414q67
# Language: python3
# Date: 2026-03-27


import pandas as pd

def find_best_candidates(candidates: pd.DataFrame, projects: pd.DataFrame) -> pd.DataFrame:
    projects=pd.merge(projects, candidates[['candidate_id']].drop_duplicates(), how='cross')
    candidates=pd.merge(projects, candidates, how='left', on=['candidate_id', 'skill']).fillna(0)
    candidates['score']=candidates.apply(lambda row: -1000000 if row['proficiency']==0 else 10 if row['proficiency']>row['importance'] else -5 if row['proficiency']<row['importance'] else 0, axis=1)
    candidates=candidates.groupby(['project_id', 'candidate_id'])['score'].sum().reset_index()
    candidates=candidates.sort_values(by=['score', 'candidate_id'], ascending=[False, True])
    candidates=candidates.groupby('project_id').first().reset_index()
    candidates=candidates[candidates['score']>-100000]
    candidates['score']=candidates['score']+100
    return candidates
