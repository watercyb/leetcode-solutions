#
# Problem: 3390. Longest Team Pass Streak
# Difficulty: Hard
# Link: https://leetcode.com/problems/longest-team-pass-streak/
# Language: python3
# Date: 2026-05-06


import pandas as pd

def calculate_longest_streaks(teams: pd.DataFrame, passes: pd.DataFrame) -> pd.DataFrame:
    passes=pd.merge(passes, teams, how='inner', left_on='pass_from', right_on='player_id')
    passes=pd.merge(passes, teams, how='inner', left_on='pass_to', right_on='player_id')
    passes=passes.sort_values(by='time_stamp')
    passes['r']=passes.groupby('team_name_x').cumcount()
    passes=passes[passes['team_name_x']==passes['team_name_y']]
    passes['n']=passes.groupby('team_name_x').cumcount()
    passes['r']=passes['r']-passes['n']
    passes=passes.groupby(['team_name_x', 'r']).size().reset_index(name='longest_streak')
    passes=passes.groupby('team_name_x')['longest_streak'].max().reset_index()
    return passes.rename(columns={'team_name_x': 'team_name'})
