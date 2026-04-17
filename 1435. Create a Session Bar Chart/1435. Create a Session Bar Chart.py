#
# Problem: 1435. Create a Session Bar Chart
# Difficulty: Easy
# Link: https://leetcode.com/problems/create-a-session-bar-chart/
# Language: python3
# Date: 2026-04-17


import pandas as pd

def create_bar_chart(sessions: pd.DataFrame) -> pd.DataFrame:
    sessions=sessions.groupby('session_id')['duration'].sum().reset_index()
    sessions['bin']=sessions['duration'].apply(lambda x: '[0-5>' if x<300 else '[5-10>' if x<600 else '[10-15>' if x<900 else '15 or more')
    return pd.concat([pd.DataFrame({'bin': ['[0-5>', '[5-10>', '[10-15>', '15 or more'], 'total': [0, 0, 0, 0]}), sessions.groupby('bin').size().reset_index(name='total')]).groupby('bin').sum().reset_index()
