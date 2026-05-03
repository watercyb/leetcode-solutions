#
# Problem: 3060. User Activities within Time Bounds
# Difficulty: Hard
# Link: https://leetcode.com/problems/user-activities-within-time-bounds/
# Language: python3
# Date: 2026-05-03


import pandas as pd

def user_activities(sessions: pd.DataFrame) -> pd.DataFrame:
    sessions=pd.merge(sessions, sessions, how='inner', on='user_id')
    sessions=sessions[(~((sessions['session_end_x']+pd.Timedelta(hours=12)<sessions['session_start_y']) | (sessions['session_start_x']-pd.Timedelta(hours=12)>sessions['session_end_y']))) & (sessions['session_type_x']==sessions['session_type_y']) & (sessions['session_id_x']!=sessions['session_id_y'])]
    return sessions[['user_id']].drop_duplicates().sort_values(by='user_id')
