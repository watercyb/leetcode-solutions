#
# Problem: 3252. Premier League Table Ranking II
# Difficulty: Medium
# Link: https://leetcode.com/problems/premier-league-table-ranking-ii/
# Language: python3
# Date: 2026-05-05


import pandas as pd

def calculate_team_tiers(team_stats: pd.DataFrame) -> pd.DataFrame:
    team_stats['points']=team_stats['wins']*3+team_stats['draws']
    team_stats['position']=team_stats['points'].rank(method='min', ascending=False)
    team_stats['tier']=team_stats['position'].apply(lambda x: 'Tier 1' if (x-1)/max(team_stats['position'])<=0.33 else 'Tier 2' if (x-1)/max(team_stats['position'])<=0.66 else 'Tier 3')
    return team_stats[['team_name', 'points', 'position', 'tier']].sort_values(by=['points', 'team_name'], ascending=[False, True])
