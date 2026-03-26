#
# Problem: 178. Rank Scores
# Difficulty: Medium
# Link: https://leetcode.com/problems/rank-scores/
# Language: python3
# Date: 2026-03-26


import pandas as pd

def order_scores(scores: pd.DataFrame) -> pd.DataFrame:
    scores['rank']=scores['score'].rank(method='dense', ascending=False)
    return scores.sort_values(by='score', ascending=False)[['score', 'rank']]
