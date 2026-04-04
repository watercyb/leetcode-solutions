#
# Problem: 597. Friend Requests I: Overall Acceptance Rate
# Difficulty: Easy
# Link: https://leetcode.com/problems/friend-requests-i-overall-acceptance-rate/
# Language: python3
# Date: 2026-04-04


import pandas as pd

def acceptance_rate(friend_request: pd.DataFrame, request_accepted: pd.DataFrame) -> pd.DataFrame:
    if request_accepted.shape[0]==0:
        return pd.DataFrame({'accept_rate': [0]})
    return pd.DataFrame({'accept_rate': [round(request_accepted[['requester_id', 'accepter_id']].drop_duplicates().shape[0]/friend_request[['sender_id', 'send_to_id']].drop_duplicates().shape[0],2)]})
