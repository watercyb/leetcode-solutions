#
# Problem: 3059. Find All Unique Email Domains
# Difficulty: Easy
# Link: https://leetcode.com/problems/find-all-unique-email-domains/
# Language: python3
# Date: 2026-05-03


import pandas as pd

def find_unique_email_domains(emails: pd.DataFrame) -> pd.DataFrame:
    emails["email_domain"] = emails["email"].str.split("@").str[1]
    emails=emails[emails['email_domain'].str.endswith('.com')]
    emails=emails.groupby('email_domain').size().reset_index(name='count')
    return emails.sort_values(by='email_domain')
