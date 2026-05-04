#
# Problem: 3150. Invalid Tweets II
# Difficulty: Easy
# Link: https://leetcode.com/problems/invalid-tweets-ii/
# Language: python3
# Date: 2026-05-04


import pandas as pd

def find_invalid_tweets(tweets: pd.DataFrame) -> pd.DataFrame:
    arr=[]
    for _, row in tweets.iterrows():
        if len(row['content'])>140:
            arr.append(row['tweet_id'])
            continue
        count1=0
        count2=0
        for chr in row['content']:
            if chr=='@':
                count1+=1
            elif chr=='#':
                count2+=1
        if count1>3 or count2>3:
            arr.append(row['tweet_id'])
    return pd.DataFrame({'tweet_id': arr})
