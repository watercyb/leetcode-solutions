#
# Problem: 1495. Friendly Movies Streamed Last Month
# Difficulty: Easy
# Link: https://leetcode.com/problems/friendly-movies-streamed-last-month/
# Language: python3
# Date: 2026-04-17


import pandas as pd

def friendly_movies(tv_program: pd.DataFrame, content: pd.DataFrame) -> pd.DataFrame:
    tv_program=tv_program[tv_program['program_date'].dt.strftime('%m-%Y')=='06-2020']
    tv_program['content_id'] = tv_program['content_id'].astype(str)
    content['content_id'] = content['content_id'].astype(str)
    content=content[(content['Kids_content']=='Y') & (content['content_type']=='Movies')]
    tv_program=pd.merge(tv_program, content, how='inner', on='content_id')[['title']]
    return tv_program.drop_duplicates()
