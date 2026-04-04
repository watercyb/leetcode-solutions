#
# Problem: 574. Winning Candidate
# Difficulty: Medium
# Link: https://leetcode.com/problems/winning-candidate/
# Language: python3
# Date: 2026-04-04


import pandas as pd

def winning_candidate(candidate: pd.DataFrame, vote: pd.DataFrame) -> pd.DataFrame:
    vote=vote.groupby('candidateId').size().reset_index(name='cnt')
    vote=vote.sort_values(by='cnt')
    c=vote.iloc[-1]['candidateId']
    candidate=candidate[candidate['id']==c]
    return candidate[['name']]
