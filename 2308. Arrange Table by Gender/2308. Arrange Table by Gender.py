#
# Problem: 2308. Arrange Table by Gender
# Difficulty: Medium
# Link: https://leetcode.com/problems/arrange-table-by-gender/
# Language: python3
# Date: 2026-04-26


import pandas as pd

def arrange_table(genders: pd.DataFrame) -> pd.DataFrame:
    df1=genders[genders['gender']=='female'].sort_values(by='user_id')
    df1['rank']=[i*10 for i in range(df1.shape[0])]
    df2=genders[genders['gender']=='other'].sort_values(by='user_id')
    df2['rank']=[i*10+1 for i in range(df1.shape[0])]
    df3=genders[genders['gender']=='male'].sort_values(by='user_id')
    df3['rank']=[i*10+2 for i in range(df1.shape[0])]
    df=pd.concat([df1,df2,df3]).sort_values(by='rank')
    return df[['user_id', 'gender']]
