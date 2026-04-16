#
# Problem: 1322. Ads Performance
# Difficulty: Easy
# Link: https://leetcode.com/problems/ads-performance/
# Language: python3
# Date: 2026-04-16


import pandas as pd

def ads_performance(ads: pd.DataFrame) -> pd.DataFrame:
    ads['clicked']=ads['action'].apply(lambda x: 1 if x=='Clicked' else 0)
    ads['viewed']=ads['action'].apply(lambda x: 1 if x=='Viewed' else 0)
    ads=ads.groupby('ad_id').agg({'clicked': 'sum', 'viewed': 'sum'}).reset_index()
    ads['ctr']=(ads['clicked']/(ads['clicked']+ads['viewed'])*100).round(2).fillna(0)
    return ads[['ad_id', 'ctr']].sort_values(by=['ctr', 'ad_id'], ascending=[False, True])
