#
# Problem: 1853. Convert Date Format
# Difficulty: Easy
# Link: https://leetcode.com/problems/convert-date-format/
# Language: python3
# Date: 2026-04-21


import pandas as pd

def convert_date_format(days: pd.DataFrame) -> pd.DataFrame:
    days['day']=days['day'].dt.strftime('%A, %B %-d, %Y')
    return days
