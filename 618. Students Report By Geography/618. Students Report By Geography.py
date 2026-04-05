#
# Problem: 618. Students Report By Geography
# Difficulty: Hard
# Link: https://leetcode.com/problems/students-report-by-geography/
# Language: python3
# Date: 2026-04-05


import pandas as pd

def geography_report(student: pd.DataFrame) -> pd.DataFrame:
    return pd.DataFrame({'America': student[student['continent']=='America']['name'].sort_values().reset_index(drop=True),
        'Asia': student[student['continent']=='Asia']['name'].sort_values().reset_index(drop=True),
        'Europe': student[student['continent']=='Europe']['name'].sort_values().reset_index(drop=True)})
