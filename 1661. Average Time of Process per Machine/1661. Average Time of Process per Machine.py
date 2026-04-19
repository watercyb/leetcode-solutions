#
# Problem: 1661. Average Time of Process per Machine
# Difficulty: Easy
# Link: https://leetcode.com/problems/average-time-of-process-per-machine/
# Language: python3
# Date: 2026-04-19


import pandas as pd

def get_average_time(activity: pd.DataFrame) -> pd.DataFrame:
    mg = pd.merge(activity[activity['activity_type']=='start'], activity[activity['activity_type']=='end'], how='inner', on=['machine_id', 'process_id'])
    mg['processing_time']=mg['timestamp_y']-mg['timestamp_x']
    return mg.groupby('machine_id').mean('processing_time').round(3).reset_index()[['machine_id','processing_time']]
