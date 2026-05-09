#
# Problem: 3673. Find Zombie Sessions
# Difficulty: Hard
# Link: https://leetcode.com/problems/find-zombie-sessions/
# Language: python3
# Date: 2026-05-09


import pandas as pd

def find_zombie_sessions(app_events: pd.DataFrame) -> pd.DataFrame:
    app_events['click']=app_events['event_type'].apply(lambda x: 1 if x=='click' else 0)
    app_events['scroll']=app_events['event_type'].apply(lambda x: 1 if x=='scroll' else 0)
    app_events['purchase']=app_events['event_type'].apply(lambda x: 1 if x=='purchase' else 0)
    app_events['event_timestamp']=pd.to_datetime(app_events['event_timestamp'])
    app_events=app_events.groupby(['user_id', 'session_id']).agg(max=('event_timestamp', 'max'), min=('event_timestamp', 'min'), click=('click', 'sum'), scroll_count=('scroll', 'sum'), total=('event_type', 'size'), purchase=('purchase', 'sum')).reset_index()
    app_events['session_duration_minutes']=(app_events['max']-app_events['min']).dt.total_seconds()/60
    app_events=app_events[(app_events['session_duration_minutes']>=30) & (app_events['scroll_count']>=5) & (app_events['click']/app_events['scroll_count']<0.2) & (app_events['purchase']==0)]
    return app_events[['session_id', 'user_id', 'session_duration_minutes', 'scroll_count']].sort_values(by=['scroll_count', 'session_id'], ascending=[False, True])
