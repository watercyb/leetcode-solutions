#
# Problem: 2175. The Change in Global Rankings
# Difficulty: Medium
# Link: https://leetcode.com/problems/the-change-in-global-rankings/
# Language: python3
# Date: 2026-04-24


import pandas as pd

def global_ratings_change(team_points: pd.DataFrame, points_change: pd.DataFrame) -> pd.DataFrame:
    team_points=team_points.sort_values(by=['points', 'name'], ascending=[False, True]).reset_index(drop=True)
    team_points['rank1']=team_points.index
    team_points=pd.merge(team_points, points_change, how='inner', on='team_id')
    team_points['points']=team_points['points']+team_points['points_change']
    team_points=team_points.sort_values(by=['points', 'name'], ascending=[False, True]).reset_index(drop=True)
    team_points['rank2']=team_points.index
    team_points['rank_diff']=team_points['rank1']-team_points['rank2']
    return team_points[['team_id', 'name', 'rank_diff']]
