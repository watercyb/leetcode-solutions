#
# Problem: 1204. Last Person to Fit in the Bus
# Difficulty: Medium
# Link: https://leetcode.com/problems/last-person-to-fit-in-the-bus/
# Language: python3
# Date: 2026-04-15


import pandas as pd

def last_passenger(queue: pd.DataFrame) -> pd.DataFrame:
    queue=queue.sort_values('turn', ascending=True)
    queue['sum']=queue['weight'].cumsum()
    queue=queue[queue['sum']<=1000]
    queue=queue[queue['sum']==queue['sum'].max()]
    return queue[['person_name']]
