#
# Problem: 182. Duplicate Emails
# Difficulty: Easy
# Link: https://leetcode.com/problems/duplicate-emails/
# Language: python3
# Date: 2026-03-26


import pandas as pd

def duplicate_emails(person: pd.DataFrame) -> pd.DataFrame:
    return person[person.duplicated('email', keep='first')][['email']].drop_duplicates()
