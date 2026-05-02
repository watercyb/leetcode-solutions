#
# Problem: 2989. Class Performance
# Difficulty: Medium
# Link: https://leetcode.com/problems/class-performance/
# Language: python3
# Date: 2026-05-02


import pandas as pd

def class_performance(scores: pd.DataFrame) -> pd.DataFrame:
    scores['sum']=scores['assignment1']+scores['assignment2']+scores['assignment3']
    return pd.DataFrame({'difference_in_score': [scores['sum'].max()-scores['sum'].min()]})
