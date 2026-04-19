#
# Problem: 1683. Invalid Tweets
# Difficulty: Easy
# Link: https://leetcode.com/problems/invalid-tweets/
# Language: python3
# Date: 2026-04-19


import pandas as pd

def invalid_tweets(tweets: pd.DataFrame) -> pd.DataFrame:
    return tweets[tweets['content'].str.len()>15][['tweet_id']]
