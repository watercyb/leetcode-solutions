#
# Problem: 1194. Tournament Winners
# Difficulty: Hard
# Link: https://leetcode.com/problems/tournament-winners/
# Language: python3
# Date: 2026-04-14


import pandas as pd

def tournament_winners(players: pd.DataFrame, matches: pd.DataFrame) -> pd.DataFrame:
    players=pd.merge(players, matches.groupby('first_player')['first_score'].sum().reset_index(), how='left', left_on='player_id', right_on='first_player')
    players=pd.merge(players, matches.groupby('second_player')['second_score'].sum().reset_index(), how='left', left_on='player_id', right_on='second_player')
    players=players.fillna(0)
    players['score']=players['first_score']+players['second_score']
    players=players[['player_id', 'group_id', 'score']].sort_values(by=['score', 'player_id'], ascending=[False, True])
    players=players.groupby('group_id').first().reset_index()
    return players[['group_id', 'player_id']]
