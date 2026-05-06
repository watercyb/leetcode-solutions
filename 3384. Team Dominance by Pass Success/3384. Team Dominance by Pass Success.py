#
# Problem: 3384. Team Dominance by Pass Success
# Difficulty: Hard
# Link: https://leetcode.com/problems/team-dominance-by-pass-success/
# Language: python3
# Date: 2026-05-06


import pandas as pd

def calculate_team_dominance(teams: pd.DataFrame, passes: pd.DataFrame) -> pd.DataFrame:
    passes=pd.merge(passes, teams, how='inner', left_on='pass_from', right_on='player_id')
    passes=pd.merge(passes, teams, how='inner', left_on='pass_to', right_on='player_id')
    passes['dominance']=passes.apply(lambda row: 1 if row['team_name_x']==row['team_name_y'] else -1, axis=1)
    passes['half_number']=passes['time_stamp'].apply(lambda x: 1 if x<='45:00' else 2)
    passes=passes.groupby(['team_name_x', 'half_number'])['dominance'].sum().reset_index()
    return passes.rename(columns={'team_name_x': 'team_name'}).sort_values(by=['team_name', 'half_number'])
