#
# Problem: 1709. Biggest Window Between Visits
# Difficulty: Medium
# Link: https://leetcode.com/problems/biggest-window-between-visits/
# Language: python3
# Date: 2026-04-20


import pandas as pd

def biggest_window(user_visits: pd.DataFrame) -> pd.DataFrame:
    user_visits=pd.concat([user_visits, pd.DataFrame({'user_id': user_visits['user_id'].drop_duplicates(), 'visit_date': pd.to_datetime('2021-1-1')})]).sort_values(by='visit_date')
    user_visits['biggest_window']=user_visits.groupby('user_id')['visit_date'].diff().dt.days.fillna(0)
    user_visits=user_visits.groupby('user_id')['biggest_window'].max().reset_index()
    return user_visits.sort_values(by='user_id')
