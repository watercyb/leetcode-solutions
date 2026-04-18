#
# Problem: 1517. Find Users With Valid E-Mails
# Difficulty: Easy
# Link: https://leetcode.com/problems/find-users-with-valid-e-mails/
# Language: python3
# Date: 2026-04-18


import pandas as pd

def valid_emails(users: pd.DataFrame) -> pd.DataFrame:
    users=users[users['mail'].str.match(r'^[a-zA-Z][a-zA-Z0-9_.-]*@leetcode\.com$')]
    return users
