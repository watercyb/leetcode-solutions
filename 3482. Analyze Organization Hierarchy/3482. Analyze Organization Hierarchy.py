#
# Problem: 3482. Analyze Organization Hierarchy
# Difficulty: Hard
# Link: https://leetcode.com/problems/analyze-organization-hierarchy/
# Language: python3
# Date: 2026-05-07


import pandas as pd

def analyze_organization_hierarchy(employees: pd.DataFrame) -> pd.DataFrame:
    mp={}    
    level={}
    team_size={}
    budget={}
    root=-1
    for _, row in employees.iterrows():
        if pd.isnull(row['manager_id']):
            root=row['employee_id']
        else:
            if row['manager_id'] not in mp:
                mp[row['manager_id']]=[]
            mp[row['manager_id']].append(row['employee_id'])
        budget[row['employee_id']]=row['salary']
            
    def dfs(mp: map, level: map, team_size: map, budget: map, i: int, lv: int):
        level[i]=lv
        team_size[i]=0
        if i not in mp:
            return
        for next in mp[i]:
            dfs(mp,level,team_size,budget,next,lv+1)
            team_size[i]+=team_size[next]+1
            budget[i]+=budget[next]
        
    dfs(mp, level,team_size,budget,root,1)
    employees['level']=employees['employee_id'].apply(lambda x: level[x])
    employees['team_size']=employees['employee_id'].apply(lambda x: team_size[x])
    employees['budget']=employees['employee_id'].apply(lambda x: budget[x])
    return employees[['employee_id', 'employee_name', 'level', 'team_size', 'budget']].sort_values(by=['level', 'budget', 'employee_name'], ascending=[True, False, True])
