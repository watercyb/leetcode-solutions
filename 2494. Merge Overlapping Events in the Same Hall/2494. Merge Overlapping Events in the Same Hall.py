#
# Problem: 2494. Merge Overlapping Events in the Same Hall
# Difficulty: Hard
# Link: https://leetcode.com/problems/merge-overlapping-events-in-the-same-hall/
# Language: python3
# Date: 2026-04-27


import pandas as pd

def merge_events(hall_events: pd.DataFrame) -> pd.DataFrame:
    hall_events=hall_events.sort_values(by=['hall_id', 'start_day']).reset_index()
    hall_ids=[]
    start_days=[]
    end_days=[]
    hall_id=-1
    start_day=-1
    end_day=-1
    for row in hall_events.itertuples(index=True):
        if row.hall_id!=hall_id or end_day<row.start_day:
            if hall_id!=-1:
                hall_ids.append(hall_id)
                start_days.append(start_day)
                end_days.append(end_day)
            hall_id=row.hall_id
            start_day=row.start_day
            end_day=row.end_day
        else:
            end_day=max(end_day, row.end_day)
    hall_ids.append(hall_id)
    start_days.append(start_day)
    end_days.append(end_day)
    return pd.DataFrame({'hall_id': hall_ids, 'start_day': start_days, 'end_day': end_days})
