#
# Problem: 3436. Find Valid Emails
# Difficulty: Easy
# Link: https://leetcode.com/problems/find-valid-emails/
# Language: python3
# Date: 2026-05-07


import pandas as pd

def find_valid_emails(users: pd.DataFrame) -> pd.DataFrame:
    users=users[users['email'].str.contains('^[a-zA-Z0-9_]+@[a-zA-Z]+\.com$')]
    return users
