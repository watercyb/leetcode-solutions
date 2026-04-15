#
# Problem: 1212. Team Scores in Football Tournament
# Difficulty: Medium
# Link: https://leetcode.com/problems/team-scores-in-football-tournament/
# Language: python3
# Date: 2026-04-15


import pandas as pd

def team_scores(teams: pd.DataFrame, matches: pd.DataFrame) -> pd.DataFrame:
    matches=pd.concat([matches[['host_team', 'host_goals', 'guest_goals']].rename(columns={'host_team': 'team_id', 'host_goals': 'a', 'guest_goals': 'b'}), matches[['guest_team', 'host_goals', 'guest_goals']].rename(columns={'guest_team': 'team_id', 'guest_goals': 'a', 'host_goals': 'b'})], ignore_index=True)

    def f1(row):
        if row['a'] > row['b']:
            return 3
        elif row['a'] == row['b']:
            return 1
        else:
            return 0

    matches['num_points'] = matches.apply(lambda row: f1(row), axis=1)

    teams=pd.merge(teams, matches, how='left', on='team_id')
    teams=teams.groupby(['team_id', 'team_name'])['num_points'].sum().reset_index()
    return teams.sort_values(by=['num_points', 'team_id'], ascending=[False, True])
