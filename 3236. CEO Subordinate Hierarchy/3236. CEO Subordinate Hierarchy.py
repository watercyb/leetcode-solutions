#
# Problem: 3236. CEO Subordinate Hierarchy
# Difficulty: Hard
# Link: https://leetcode.com/problems/ceo-subordinate-hierarchy/
# Language: python3
# Date: 2026-05-05


import pandas as pd

def find_subordinates(employees: pd.DataFrame) -> pd.DataFrame:
    arr={}
    links={}
    ceo=-1
    for row in employees.itertuples():
        if pd.isna(row.manager_id):
            ceo=row.employee_id
        elif row.manager_id in links:
            links[row.manager_id].append(row.employee_id)
        else:
            links[row.manager_id]=[row.employee_id]
        arr[row.employee_id]=[row.employee_name, row.salary]
    ids=[]
    names=[]
    levels=[]
    salary=[]
    
    def dfs(i: int, lv: int):
        ids.append(i)
        pair=arr[i]
        names.append(pair[0])
        levels.append(lv)
        salary.append(pair[1]-arr[ceo][1])
        if i in links:
            for next_id in links[i]:
                dfs(next_id, lv+1)
    if ceo in links:
        for next_id in links[ceo]:
            dfs(next_id, 1)
    return pd.DataFrame({'subordinate_id': ids, 'subordinate_name': names, 'hierarchy_level': levels, 'salary_difference': salary}).sort_values(by=['hierarchy_level', 'subordinate_id'])

