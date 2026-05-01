#
# Problem: 2853. Highest Salaries Difference
# Difficulty: Easy
# Link: https://leetcode.com/problems/highest-salaries-difference/
# Language: python3
# Date: 2026-05-01


import pandas as pd

def salaries_difference(salaries: pd.DataFrame) -> pd.DataFrame:
    return pd.DataFrame({'salary_difference':[abs(salaries[salaries['department']=='Engineering']['salary'].max()-salaries[salaries['department']=='Marketing']['salary'].max())]})
