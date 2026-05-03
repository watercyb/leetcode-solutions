#
# Problem: 3058. Friends With No Mutual Friends
# Difficulty: Medium
# Link: https://leetcode.com/problems/friends-with-no-mutual-friends/
# Language: python3
# Date: 2026-05-03


import pandas as pd

def friends_with_no_mutual_friends(friends: pd.DataFrame) -> pd.DataFrame:
    df=pd.concat([friends, friends.rename(columns={'user_id1': 'user_id2', 'user_id2': 'user_id1'})])
    df1=pd.merge(df, df, how='inner', on='user_id1')
    df1=pd.merge(df1, df, how='inner', left_on=['user_id2_x', 'user_id2_y'], right_on=['user_id1', 'user_id2'])
    df1=df1[['user_id1_x', 'user_id2_x']].drop_duplicates()
    friends = (
        pd.merge(
            friends,
            df1.rename(columns={'user_id1_x': 'user_id1', 'user_id2_x': 'user_id2'}),
            how='left',
            on=['user_id1', 'user_id2'],
            indicator=True
        )
        .query('_merge == "left_only"')
        .drop(columns='_merge')
    )
    return friends.sort_values(by=['user_id1', 'user_id2'])
