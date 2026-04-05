#
# Problem: 601. Human Traffic of Stadium
# Difficulty: Hard
# Link: https://leetcode.com/problems/human-traffic-of-stadium/
# Language: python3
# Date: 2026-04-05


import pandas as pd

def human_traffic(stadium: pd.DataFrame) -> pd.DataFrame:
    stadium=stadium[stadium['people']>=100].sort_values(by='visit_date', ascending=True)
    stadium['r'] = range(len(stadium))-stadium['id']
    count=stadium.groupby('r').size().reset_index(name='count')
    count=count[count['count']>=3]
    stadium=stadium[stadium['r'].isin(count['r'])]
    return stadium[['id', 'visit_date', 'people']]
