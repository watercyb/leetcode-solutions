#
# Problem: 3642. Find Books with Polarized Opinions
# Difficulty: Medium
# Link: https://leetcode.com/problems/find-books-with-polarized-opinions/
# Language: python3
# Date: 2026-05-09


import pandas as pd

def find_polarized_books(books: pd.DataFrame, reading_sessions: pd.DataFrame) -> pd.DataFrame:
    reading_sessions['rating']=reading_sessions['session_rating'].apply(lambda x: 1 if x<=2 or x>=4 else 0)
    reading_sessions['h']=reading_sessions['session_rating'].apply(lambda x: 1 if x<=2 else 2 if x>=4 else 0)
    reading_sessions=reading_sessions.groupby('book_id').agg(rating=('rating', 'sum'), total=('rating', 'size'), max=('session_rating', 'max'), min=('session_rating', 'min'), h=('h', lambda x: np.bitwise_or.reduce(x))).reset_index()
    reading_sessions=reading_sessions[(reading_sessions['total']>=5) & (reading_sessions['h']>=3)]
    reading_sessions['rating_spread']=reading_sessions['max']-reading_sessions['min']
    reading_sessions['polarization_score']=(reading_sessions['rating']/reading_sessions['total']+0.00001).round(2)
    reading_sessions=reading_sessions[reading_sessions['polarization_score']>=0.6]
    reading_sessions=pd.merge(books, reading_sessions, how='inner', on='book_id')
    return reading_sessions[['book_id', 'title', 'author', 'genre', 'pages', 'rating_spread', 'polarization_score']].sort_values(by=['polarization_score', 'title'], ascending=[False, False])
