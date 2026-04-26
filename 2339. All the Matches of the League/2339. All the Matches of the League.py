#
# Problem: 2339. All the Matches of the League
# Difficulty: Easy
# Link: https://leetcode.com/problems/all-the-matches-of-the-league/
# Language: python3
# Date: 2026-04-26


import pandas as pd

def find_all_matches(teams: pd.DataFrame) -> pd.DataFrame:
    teams=pd.merge(teams, teams, how='cross')
    teams=teams[teams['team_name_x']!=teams['team_name_y']]
    return teams.rename(columns={'team_name_x': 'home_team', 'team_name_y': 'away_team'})
