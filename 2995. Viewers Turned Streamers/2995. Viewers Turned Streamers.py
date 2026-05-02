#
# Problem: 2995. Viewers Turned Streamers
# Difficulty: Hard
# Link: https://leetcode.com/problems/viewers-turned-streamers/
# Language: python3
# Date: 2026-05-02


import pandas as pd

def count_turned_streamers(sessions: pd.DataFrame) -> pd.DataFrame:
    df=sessions.sort_values(by='session_start').groupby('user_id').first().reset_index()
    df=df[df['session_type']=='Viewer'][['user_id']]
    sessions=pd.merge(df, sessions, how='left', on='user_id')
    sessions=sessions[sessions['session_type']=='Streamer']
    sessions=sessions.groupby('user_id').size().reset_index(name='sessions_count')
    return sessions.sort_values(by=['sessions_count', 'user_id'], ascending=[False, False])
