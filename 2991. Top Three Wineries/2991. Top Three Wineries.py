#
# Problem: 2991. Top Three Wineries
# Difficulty: Hard
# Link: https://leetcode.com/problems/top-three-wineries/
# Language: python3
# Date: 2026-05-02


import pandas as pd

def top_three_wineries(wineries: pd.DataFrame) -> pd.DataFrame:
    wineries=wineries.groupby(['country', 'winery'])['points'].sum().reset_index()
    wineries['rank']=wineries.sort_values(['points', 'winery'], ascending=[False, True]).groupby('country').cumcount()
    wineries=wineries[wineries['rank']<3]
    wineries['val']=wineries['winery']+' ('+wineries['points'].astype(str)+')'
    wineries=wineries.pivot(index='country', columns='rank', values='val').reset_index()
    wineries[0] = wineries[0].fillna('No first winery')
    if 1 not in wineries.columns:
        wineries[1]=['No second winery']*wineries.shape[0]
    else:
        wineries[1] = wineries[1].fillna('No second winery')
    if 2 not in wineries.columns:
        wineries[2]=['No third winery']*wineries.shape[0]
    else:
        wineries[2] = wineries[2].fillna('No third winery')
    return wineries.rename(columns={0: 'top_winery', 1: 'second_winery', 2: 'third_winery'}).sort_values(by='country')
