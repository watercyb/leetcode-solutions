#
# Problem: 3172. Second Day Verification
# Difficulty: Easy
# Link: https://leetcode.com/problems/second-day-verification/
# Language: python3
# Date: 2026-05-04


import pandas as pd

def find_second_day_signups(emails: pd.DataFrame, texts: pd.DataFrame) -> pd.DataFrame:
    emails=pd.merge(emails, texts[texts['signup_action']=='Verified'], how='inner', on='email_id')
    emails=emails[(emails['action_date']-pd.Timedelta(days=1)).dt.strftime('%d%m%y')==emails['signup_date'].dt.strftime('%d%m%y')]
    return emails[['user_id']].sort_values(by='user_id')
