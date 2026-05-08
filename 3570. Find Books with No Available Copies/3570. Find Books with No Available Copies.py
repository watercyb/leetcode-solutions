#
# Problem: 3570. Find Books with No Available Copies
# Difficulty: Easy
# Link: https://leetcode.com/problems/find-books-with-no-available-copies/
# Language: python3
# Date: 2026-05-08


import pandas as pd

def find_books_with_no_available_copies(library_books: pd.DataFrame, borrowing_records: pd.DataFrame) -> pd.DataFrame:
    df=borrowing_records.loc[borrowing_records['return_date'].isnull()].groupby('book_id').size().reset_index(name='count')
    df = pd.merge(library_books, df, how='inner', on='book_id')
    df = df[df['total_copies'] == df['count']].drop('count', axis=1)
    df.rename(columns={'total_copies': 'current_borrowers'}, inplace=True)
    df.sort_values(by=['current_borrowers', 'title'], ascending=[False, True], inplace=True)
    return df
