#
# Problem: 2004. The Number of Seniors and Juniors to Join the Company
# Difficulty: Hard
# Link: https://leetcode.com/problems/the-number-of-seniors-and-juniors-to-join-the-company/
# Language: python3
# Date: 2026-04-23


import pandas as pd

def count_seniors_and_juniors(candidates: pd.DataFrame) -> pd.DataFrame:
    df1=candidates[candidates['experience']=='Senior'].sort_values(by='salary')
    df1['sum']=df1['salary'].cumsum()
    df1=df1[df1['sum']<=70000]
    rem=70000-(0 if df1.shape[0]==0 else df1['sum'].max())
    df2=candidates[candidates['experience']=='Junior'].sort_values(by='salary')
    df2['sum']=df2['salary'].cumsum()
    df2=df2[df2['sum']<=rem]
    return pd.DataFrame({'experience': ['Senior', 'Junior'], 'accepted_candidates': [df1.shape[0], df2.shape[0]]})
