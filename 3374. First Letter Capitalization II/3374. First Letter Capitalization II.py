#
# Problem: 3374. First Letter Capitalization II
# Difficulty: Hard
# Link: https://leetcode.com/problems/first-letter-capitalization-ii/?envType=problem-list-v2&envId=ne414q67
# Language: python3
# Date: 2026-04-06


import pandas as pd

def capitalize_content(user_content: pd.DataFrame) -> pd.DataFrame:
    def fun(x):
        arr=x.split(' ')
        for i in range(len(arr)):
            ar=arr[i].split('-')
            if len(ar)==2 and len(ar[0])!=0:
                arr[i]=ar[0][:1].upper()+ar[0][1:].lower()+'-'+ar[1][:1].upper()+ar[1][1:].lower()
            else:
                arr[i]=arr[i][:1].upper()+arr[i][1:].lower()
        return ' '.join(arr)

    user_content['converted_text']=user_content['content_text'].apply(fun)
    return user_content.rename(columns={'content_text': 'original_text'})
