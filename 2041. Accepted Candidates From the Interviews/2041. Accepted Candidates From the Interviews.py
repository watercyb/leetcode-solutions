#
# Problem: 2041. Accepted Candidates From the Interviews
# Difficulty: Medium
# Link: https://leetcode.com/problems/accepted-candidates-from-the-interviews/
# Language: python3
# Date: 2026-04-23


import pandas as pd

def accepted_candidates(candidates: pd.DataFrame, rounds: pd.DataFrame) -> pd.DataFrame:
    candidates=candidates[candidates['years_of_exp']>=2]
    rounds=rounds.groupby('interview_id')['score'].sum().reset_index()
    candidates=pd.merge(candidates, rounds, how='inner', on='interview_id')
    candidates=candidates[candidates['score']>15]
    return candidates[['candidate_id']]
