#
# Problem: 3055. Top Percentile Fraud
# Difficulty: Medium
# Link: https://leetcode.com/problems/top-percentile-fraud/
# Language: python3
# Date: 2026-05-03


import pandas as pd

def top_percentile_fraud(fraud: pd.DataFrame) -> pd.DataFrame:
    fraud=fraud.sort_values(by='fraud_score', ascending=False)
    fraud['r']=fraud.groupby('state')['fraud_score'].rank(method='min', ascending=False)
    fraud['max']=fraud.groupby('state')['r'].transform('max')
    fraud['p']=fraud.apply(lambda row: 0 if row['max']==1 else (row['r']-1)/(row['max']-1), axis=1)
    fraud=fraud[fraud['p']<=0.05]
    return fraud[['policy_id', 'state', 'fraud_score']].sort_values(by=['state', 'fraud_score', 'policy_id'], ascending=[True, False, True])
