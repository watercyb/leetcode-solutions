#
# Problem: 3358. Books with NULL Ratings
# Difficulty: Easy
# Link: https://leetcode.com/problems/books-with-null-ratings/?envType=problem-list-v2&envId=ne414q67
# Language: python3
# Date: 2026-04-03


import pandas as pd

def find_unrated_books(books: pd.DataFrame) -> pd.DataFrame:
    books=books[books['rating'].isna()]
    return books[['book_id', 'title', 'author', 'published_year']].sort_values(by='book_id')
