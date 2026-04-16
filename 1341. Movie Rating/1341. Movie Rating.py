#
# Problem: 1341. Movie Rating
# Difficulty: Medium
# Link: https://leetcode.com/problems/movie-rating/
# Language: python3
# Date: 2026-04-16


import pandas as pd

def movie_rating(movies: pd.DataFrame, users: pd.DataFrame, movie_rating: pd.DataFrame) -> pd.DataFrame:
    df=movie_rating[(movie_rating['created_at']>='2020-02-01') & (movie_rating['created_at']<'2020-03-01')].groupby('movie_id')['rating'].mean().reset_index()
    movie_name=pd.merge(movies, df, how='inner', on='movie_id').sort_values(by=['rating', 'title'], ascending=[False, True])['title'].iloc[0]
    df=movie_rating.groupby('user_id').size().reset_index(name='count')
    user_name=pd.merge(users, df, how='inner', on='user_id').sort_values(by=['count', 'name'], ascending=[False, True])['name'].iloc[0]
    return pd.DataFrame({'results': [movie_name, user_name]})
