#
# Problem: 2990. Loan Types
# Difficulty: Easy
# Link: https://leetcode.com/problems/loan-types/
# Language: python3
# Date: 2026-05-02


import pandas as pd

def loan_types(loans: pd.DataFrame) -> pd.DataFrame:
    loans['type']=loans['loan_type'].apply(lambda x: 1 if x=='Refinance' else 2 if x=='Mortgage' else 0)
    loans=loans.groupby('user_id')['type'].agg(lambda x: np.bitwise_or.reduce(x.values)).reset_index()
    loans=loans[loans['type']==3]
    return loans[['user_id']].sort_values(by='user_id')
