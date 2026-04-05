#
# Problem: 620. Not Boring Movies
# Difficulty: Easy
# Link: https://leetcode.com/problems/not-boring-movies/
# Language: python3
# Date: 2026-04-05


import pandas as pd

def not_boring_movies(cinema: pd.DataFrame) -> pd.DataFrame:
    cinema=cinema[(cinema['id']%2==1) & (cinema['description']!='boring')]
    return cinema.sort_values(by='rating', ascending=False)
