#
# Problem: 2051. The Category of Each Member in the Store
# Difficulty: Medium
# Link: https://leetcode.com/problems/the-category-of-each-member-in-the-store/
# Language: python3
# Date: 2026-04-23


import pandas as pd

def find_categories(members: pd.DataFrame, visits: pd.DataFrame, purchases: pd.DataFrame) -> pd.DataFrame:
    visits=pd.merge(visits, purchases, how='left', on='visit_id')
    visits['p']=visits['charged_amount'].apply(lambda x: 0 if pd.isna(x) else 1)
    visits=visits.groupby('member_id').agg(v=('visit_id', 'size'), p=('p', 'sum')).reset_index()
    visits['r']=visits['p']/visits['v']
    members=pd.merge(members, visits, how='left', on='member_id').fillna(-1)
    members['category']=members['r'].apply(lambda x: 'Bronze' if x==-1 else 'Silver' if x<0.5 else 'Gold' if x<0.8 else 'Diamond')
    return members[['member_id', 'name', 'category']]
