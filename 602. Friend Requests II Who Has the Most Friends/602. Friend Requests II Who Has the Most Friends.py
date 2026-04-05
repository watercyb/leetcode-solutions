#
# Problem: 602. Friend Requests II: Who Has the Most Friends
# Difficulty: Medium
# Link: https://leetcode.com/problems/friend-requests-ii-who-has-the-most-friends/
# Language: python3
# Date: 2026-04-05


import pandas as pd

def most_friends(request_accepted: pd.DataFrame) -> pd.DataFrame:
    df=pd.concat([request_accepted[['requester_id']].rename(columns={'requester_id': 'id'}), request_accepted[['accepter_id']].rename(columns={'accepter_id': 'id'})], ignore_index=True)
    df=df.groupby('id').size().reset_index(name='num')
    df['max']=df['num'].max()
    df=df[df['num']==df['max']]
    return df[['id','num']]
