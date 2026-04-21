#
# Problem: 1841. League Statistics
# Difficulty: Medium
# Link: https://leetcode.com/problems/league-statistics/
# Language: python3
# Date: 2026-04-21


import pandas as pd

def league_statistics(teams: pd.DataFrame, matches: pd.DataFrame) -> pd.DataFrame:
    matches['score_1']=matches.apply(lambda row: 3 if row['home_team_goals']>row['away_team_goals'] else 1 if row['home_team_goals']==row['away_team_goals'] else 0, axis=1)
    matches['score_2']=matches['score_1'].apply(lambda x: 3 if x==0 else 1 if x==1 else 0)
    df1=matches[['home_team_id', 'home_team_goals' ,'away_team_goals', 'score_1']].rename(columns={'home_team_id': 'team_id', 'home_team_goals': 'goal_for', 'away_team_goals': 'goal_against', 'score_1': 'points'})
    df2=matches[['away_team_id', 'home_team_goals' ,'away_team_goals', 'score_2']].rename(columns={'away_team_id': 'team_id', 'away_team_goals': 'goal_for', 'home_team_goals': 'goal_against', 'score_2': 'points'})
    df=pd.concat([df1, df2], ignore_index=True)
    df=df.groupby('team_id').agg(points=('points', 'sum'), matches_played=('points', 'size'), goal_for=('goal_for', 'sum'), goal_against=('goal_against', 'sum')).reset_index()
    df['goal_diff']=df['goal_for']-df['goal_against']
    df=pd.merge(teams, df, how='inner', on='team_id')
    return df[['team_name', 'matches_played', 'points', 'goal_for', 'goal_against', 'goal_diff']].sort_values(by=['points', 'goal_diff', 'team_name'], ascending=[False, False, True])
