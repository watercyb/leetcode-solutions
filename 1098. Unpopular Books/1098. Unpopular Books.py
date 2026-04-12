#
# Problem: 1098. Unpopular Books
# Difficulty: Medium
# Link: https://leetcode.com/problems/unpopular-books/
# Language: python3
# Date: 2026-04-12


import pandas as pd

def unpopular_books(books: pd.DataFrame, orders: pd.DataFrame) -> pd.DataFrame:
    books=books[(pd.to_datetime('2019-06-23')-pd.to_datetime(books['available_from'])).dt.days>=30]
    orders=orders[pd.to_datetime(orders['dispatch_date'])>pd.to_datetime('2018-06-23')]
    books=pd.merge(books, orders, how='left', on='book_id').fillna(0)
    books=books.groupby(['book_id', 'name'])['quantity'].sum().reset_index()
    return books[books['quantity']<10][['book_id', 'name']]
