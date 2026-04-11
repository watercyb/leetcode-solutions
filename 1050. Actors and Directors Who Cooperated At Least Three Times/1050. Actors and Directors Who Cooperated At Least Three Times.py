#
# Problem: 1050. Actors and Directors Who Cooperated At Least Three Times
# Difficulty: Easy
# Link: https://leetcode.com/problems/actors-and-directors-who-cooperated-at-least-three-times/
# Language: python3
# Date: 2026-04-11


import pandas as pd

def actors_and_directors(actor_director: pd.DataFrame) -> pd.DataFrame:
    actor_director=actor_director.groupby(['actor_id', 'director_id']).size().reset_index(name='count')
    return actor_director[actor_director['count']>=3][['actor_id', 'director_id']]
