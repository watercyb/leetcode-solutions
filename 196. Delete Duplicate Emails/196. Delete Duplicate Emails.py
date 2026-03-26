#
# Problem: 196. Delete Duplicate Emails
# Difficulty: Easy
# Link: https://leetcode.com/problems/delete-duplicate-emails/
# Language: python3
# Date: 2026-03-26


import pandas as pd

def delete_duplicate_emails(person: pd.DataFrame) -> None:
    pd=person.groupby('email')['id'].min().reset_index()
    indexes_to_drop = person.loc[~person['id'].isin(pd['id'])].index
    person.drop(indexes_to_drop, inplace=True)
