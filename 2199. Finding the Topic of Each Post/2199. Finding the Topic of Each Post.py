#
# Problem: 2199. Finding the Topic of Each Post
# Difficulty: Hard
# Link: https://leetcode.com/problems/finding-the-topic-of-each-post/
# Language: python3
# Date: 2026-04-24


import pandas as pd

def find_topic(keywords: pd.DataFrame, posts: pd.DataFrame) -> pd.DataFrame:
    mp={}
    for _, row in keywords.iterrows():
        k=row['word'].lower()
        if k not in mp:
            mp[k]=set()
        mp[k].add(row['topic_id'])

    def f(row):
        st=set()
        for s in row['content'].split():
            s=s.lower()
            if s in mp:
                for v in mp[s]:
                    st.add(v)
        li=list(st)
        li.sort()
        res=','.join(map(str, li))
        if len(res)==0:
            return 'Ambiguous!'
        return res
    posts['topic']=posts.apply(f, axis=1)
    return posts[['post_id', 'topic']]
