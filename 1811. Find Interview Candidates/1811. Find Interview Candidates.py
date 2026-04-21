#
# Problem: 1811. Find Interview Candidates
# Difficulty: Medium
# Link: https://leetcode.com/problems/find-interview-candidates/
# Language: python3
# Date: 2026-04-21


import pandas as pd

def find_interview_candidates(contests: pd.DataFrame, users: pd.DataFrame) -> pd.DataFrame:
    df=pd.concat([contests[['contest_id', 'gold_medal']].rename(columns={'gold_medal': 'user_id'}), contests[['contest_id', 'silver_medal']].rename(columns={'silver_medal': 'user_id'}), contests[['contest_id', 'bronze_medal']].rename(columns={'bronze_medal': 'user_id'})]).drop_duplicates().sort_values(by=['user_id', 'contest_id'])
    df['prv']=df['contest_id'].shift(-2)
    df['prv_id']=df['user_id'].shift(-2)
    df=df[(df['contest_id']+2==df['prv']) & (df['user_id']==df['prv_id'])][['user_id']].drop_duplicates()
    contests=contests[['gold_medal']].groupby('gold_medal').size().reset_index()
    contests=contests[contests[0]>=3][['gold_medal']].rename(columns={'gold_medal': 'user_id'})
    contests=pd.concat([df, contests]).drop_duplicates()
    contests=pd.merge(contests, users, how='inner', on='user_id')
    return contests[['mail', 'name']]
