#
# Problem: 3156. Employee Task Duration and Concurrent Tasks
# Difficulty: Hard
# Link: https://leetcode.com/problems/employee-task-duration-and-concurrent-tasks/
# Language: python3
# Date: 2026-05-04


import pandas as pd

def find_total_duration(tasks: pd.DataFrame) -> pd.DataFrame:
    tasks=tasks.sort_values(by=['employee_id', 'start_time'])
    employee_ids=[]
    hours=[]
    concurrents=[]
    current_id=-1
    hour=0
    count=0
    max_count=1
    dq=deque()
    for _, row in tasks.iterrows():
        if row['employee_id']!=current_id:
            if current_id!=-1:
                employee_ids.append(current_id)
                hours.append(hour//3600000)
                concurrents.append(max_count)
            current_id=row['employee_id']
            hour=row['end_time']-row['start_time']
            count=0
            max_count=1
            dq.clear()
            dq.append(row['end_time'])
        else:
            if row['start_time']>=dq[-1]:
                hour+=row['end_time']-row['start_time']
                dq.append(row['end_time'])
            elif row['end_time']>dq[-1]:
                hour+=row['end_time']-dq[-1]
                dq.append(row['end_time'])
            else:
                count+=1
            while len(dq)>0 and dq[0]<=row['start_time']:
                dq.popleft()
            max_count=max(max_count,len(dq)+count)
    employee_ids.append(current_id)
    hours.append(hour//3600000)
    concurrents.append(max_count)
    return pd.DataFrame({'employee_id': employee_ids, 'total_task_hours': hours, 'max_concurrent_tasks': concurrents})
