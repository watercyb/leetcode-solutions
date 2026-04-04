#
# Problem: 584. Find Customer Referee
# Difficulty: Easy
# Link: https://leetcode.com/problems/find-customer-referee/
# Language: python3
# Date: 2026-04-04


import pandas as pd

def find_customer_referee(customer: pd.DataFrame) -> pd.DataFrame:
    return customer[(customer['referee_id']!=2)|(customer['referee_id'].isnull())][['name']]
