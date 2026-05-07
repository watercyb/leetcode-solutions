#
# Problem: 3401. Find Circular Gift Exchange Chains
# Difficulty: Hard
# Link: https://leetcode.com/problems/find-circular-gift-exchange-chains/
# Language: python3
# Date: 2026-05-07


import pandas as pd

def find_gift_chains(secret_santa: pd.DataFrame) -> pd.DataFrame:
    links={}
    vals={}
    counts={}
    isCycles={}

    def find(i: int) -> int:
        if links[i]!=i:
            links[i]=find(links[i])
        return links[i]

    for _, row in secret_santa.iterrows():
        a=row['giver_id']
        b=row['receiver_id']
        c=row['gift_value']
        if a not in links and b not in links:
            links[a]=b
            links[b]=b
            vals[b]=c
            counts[b]=2
        elif a not in links:
            b=find(b)
            links[a]=b
            vals[b]+=c
            counts[b]+=1
        elif b not in links:
            a=find(a)
            links[b]=a
            vals[a]+=c
            counts[a]+=1
        else:
            a=find(a)
            b=find(b)
            if a!=b:
                links[a]=b
                vals[b]+=vals[a]+c
                counts[b]+=counts[a]
            else:
                vals[b]+=c
                isCycles[b]=True
    chain_lengths=[]
    total_gift_values=[]
    for k, v in links.items():
        if k==v and isCycles.get(k, False):
            chain_lengths.append(counts[k])
            total_gift_values.append(vals[k])
    df=pd.DataFrame({'chain_length': chain_lengths, 'total_gift_value': total_gift_values}).drop_duplicates()
    df=df.sort_values(by=['chain_length', 'total_gift_value'], ascending=[False, False])
    df['chain_id']=range(1, df.shape[0]+1)
    return df[['chain_id', 'chain_length', 'total_gift_value']]
