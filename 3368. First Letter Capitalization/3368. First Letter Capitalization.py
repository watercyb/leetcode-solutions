#
# Problem: 3368. First Letter Capitalization
# Difficulty: Hard
# Link: https://leetcode.com/problems/first-letter-capitalization/
# Language: python3
# Date: 2026-05-06


import pandas as pd

def process_text(user_content: pd.DataFrame) -> pd.DataFrame:
    def func(text):
        strs=text.split(' ')
        for i in range(len(strs)):
            strs[i]=strs[i][0].upper()+strs[i][1:].lower()
        return ' '.join(strs)
    user_content['converted_text']=user_content['content_text'].apply(func)
    return user_content.rename(columns={'content_text': 'original_text'})
