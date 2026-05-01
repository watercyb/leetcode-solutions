#
# Problem: 2820. Election Results
# Difficulty: Medium
# Link: https://leetcode.com/problems/election-results/
# Language: python3
# Date: 2026-05-01


import pandas as pd

def get_election_results(votes: pd.DataFrame) -> pd.DataFrame:
    votes['count']=votes.groupby('voter').transform('size')
    votes['count']=1/votes['count']
    votes=votes[~votes['candidate'].isna()]
    votes=votes.groupby('candidate').sum().reset_index()
    votes=votes[votes['count']==votes['count'].max()]
    return votes[['candidate']].sort_values(by='candidate')
