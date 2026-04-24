#
# Problem: 2173. Longest Winning Streak
# Difficulty: Hard
# Link: https://leetcode.com/problems/longest-winning-streak/
# Language: python3
# Date: 2026-04-24


import pandas as pd

def longest_winning_streak(matches: pd.DataFrame) -> pd.DataFrame:
    matches=matches.sort_values(by=['player_id', 'match_day'])
    matches['grp'] = ((matches['player_id']!=matches['player_id'].shift()) | (matches['result'] != matches['result'].shift())).cumsum()
    matches=matches.groupby(['player_id', 'result', 'grp']).size().reset_index(name='longest_streak')
    all_players=matches['player_id'].unique()
    matches=matches[matches['result']=='Win'].groupby('player_id')['longest_streak'].max()
    matches=matches.reindex(all_players, fill_value=0).reset_index()
    return matches
