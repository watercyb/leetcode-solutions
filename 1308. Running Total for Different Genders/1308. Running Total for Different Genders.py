#
# Problem: 1308. Running Total for Different Genders
# Difficulty: Medium
# Link: https://leetcode.com/problems/running-total-for-different-genders/
# Language: python3
# Date: 2026-04-16


import pandas as pd

def running_total(scores: pd.DataFrame) -> pd.DataFrame:
    scores=scores.sort_values(by=['gender', 'day'])
    scores['total']=scores.groupby('gender')['score_points'].transform("cumsum")
    return scores[['gender', 'day', 'total']]
