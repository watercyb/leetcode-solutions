#
# Problem: 3087. Find Trending Hashtags
# Difficulty: Medium
# Link: https://leetcode.com/problems/find-trending-hashtags/
# Language: python3
# Date: 2026-05-03


import pandas as pd

def find_trending_hashtags(tweets: pd.DataFrame) -> pd.DataFrame:
    tweets=tweets[tweets['tweet_date'].dt.strftime('%m-%Y')=='02-2024']
    tweets['hashtag'] ='#'+ tweets['tweet'].str.split('#').str.get(1).str.split(' ').str.get(0)
    tweets=tweets.groupby('hashtag').size().reset_index(name= 'hashtag_count')
    tweets=tweets.sort_values(by=['hashtag_count', 'hashtag'], ascending=[False, False])
    return tweets.head(3)
