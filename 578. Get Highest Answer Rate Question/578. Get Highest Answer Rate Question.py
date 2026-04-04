#
# Problem: 578. Get Highest Answer Rate Question
# Difficulty: Medium
# Link: https://leetcode.com/problems/get-highest-answer-rate-question/
# Language: python3
# Date: 2026-04-04


import pandas as pd

def get_the_question(survey_log: pd.DataFrame) -> pd.DataFrame:
    survey_log['a']=survey_log['action'].apply(lambda x: 1 if x=='show' else 0)
    survey_log['b']=survey_log['action'].apply(lambda x: 1 if x=='answer' else 0)
    survey_log=survey_log.groupby('question_id').agg({'a': 'sum', 'b': 'sum'}).reset_index()
    survey_log['c']=survey_log['b']/survey_log['a']
    survey_log=survey_log.sort_values(by=['c', 'question_id'], ascending=[False, True])
    return survey_log.head(1)[['question_id']].rename(columns={'question_id': 'survey_log'})
