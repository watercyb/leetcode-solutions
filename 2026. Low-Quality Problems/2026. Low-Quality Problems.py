#
# Problem: 2026. Low-Quality Problems
# Difficulty: Easy
# Link: https://leetcode.com/problems/low-quality-problems/
# Language: python3
# Date: 2026-04-23


import pandas as pd

def low_quality_problems(problems: pd.DataFrame) -> pd.DataFrame:
    problems['per']=problems['likes']/(problems['likes']+problems['dislikes'])
    problems=problems[problems['per']<0.6]
    return problems[['problem_id']].sort_values(by='problem_id')
