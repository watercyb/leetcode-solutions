#
# Problem: 3246. Premier League Table Ranking
# Difficulty: Easy
# Link: https://leetcode.com/problems/premier-league-table-ranking/
# Language: python3
# Date: 2026-05-05


import pandas as pd

def calculate_team_standings(team_stats: pd.DataFrame) -> pd.DataFrame:
    team_stats['points']=team_stats['wins']*3+team_stats['draws']
    team_stats['position']=team_stats['points'].rank(ascending=False, method="min")
    return team_stats[['team_id', 'team_name', 'points', 'position']].sort_values(by=['points', 'team_name'], ascending=[False, True])

