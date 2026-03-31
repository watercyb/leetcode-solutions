#
# Problem: 3322. Premier League Table Ranking III
# Difficulty: Medium
# Link: https://leetcode.com/problems/premier-league-table-ranking-iii/?envType=problem-list-v2&envId=ne414q67
# Language: python3
# Date: 2026-03-31


import pandas as pd

def process_team_standings(season_stats: pd.DataFrame) -> pd.DataFrame:
    season_stats['points']=season_stats['wins']*3+season_stats['draws']
    season_stats['goal_difference']=season_stats['goals_for']-season_stats['goals_against']
    season_stats=season_stats.sort_values(by=['points', 'goal_difference', 'team_name'], ascending=[False, False, True])
    season_stats['position']=season_stats.groupby('season_id').transform('cumcount')+1
    return season_stats[['season_id', 'team_id', 'team_name', 'points', 'goal_difference', 'position']].sort_values(by=['season_id', 'position', 'team_name'])
