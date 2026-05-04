#
# Problem: 3103. Find Trending Hashtags II
# Difficulty: Hard
# Link: https://leetcode.com/problems/find-trending-hashtags-ii/
# Language: python3
# Date: 2026-05-04


import pandas as pd

def find_trending_hashtags(tweets: pd.DataFrame) -> pd.DataFrame:
    mp={}
    for t in tweets['tweet']:
        strs=t.split('#')
        for i in range(1, len(strs)):
            key='#'+strs[i].split(' ')[0]
            mp[key]=mp.get(key,0)+1
    h=[]
    c=[]
    for k,v in mp.items():
        h.append(k)
        c.append(v)
    df=pd.DataFrame({'hashtag': h, 'count': c})
    df=df.sort_values(by=['count', 'hashtag'], ascending=[False, False]).head(3)
    return df
