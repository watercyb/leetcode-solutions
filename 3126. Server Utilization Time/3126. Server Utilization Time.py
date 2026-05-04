#
# Problem: 3126. Server Utilization Time
# Difficulty: Medium
# Link: https://leetcode.com/problems/server-utilization-time/
# Language: python3
# Date: 2026-05-04


import pandas as pd

def server_utilization_time(servers: pd.DataFrame) -> pd.DataFrame:
    servers=servers.sort_values(by=['server_id', 'status_time'])
    servers['time']=servers['status_time']-servers['status_time'].shift(1)
    servers=servers[servers['session_status']=='stop']
    time=servers['time'].sum()
    return pd.DataFrame({'total_uptime_days': [time.days]})
