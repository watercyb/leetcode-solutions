#
# Problem: 3089. Find Bursty Behavior
# Difficulty: Medium
# Link: https://leetcode.com/problems/find-bursty-behavior/
# Language: python3
# Date: 2026-05-03


import pandas as pd

def find_bursty_behavior(posts: pd.DataFrame) -> pd.DataFrame:
    posts=posts[posts['post_date'].dt.strftime('%d-%m-%Y')!='29-02-2024']
    posts['avg_weekly_posts']=posts.groupby('user_id').transform('size')/4
    posts=posts.sort_values(by='post_date')
    posts=posts.groupby(['user_id', 'avg_weekly_posts']).rolling('7D', on='post_date')['post_id'].count().reset_index(name='max_7day_posts')
    posts=posts[posts['max_7day_posts']/2>=posts['avg_weekly_posts']]
    posts=posts.groupby(['user_id', 'avg_weekly_posts'])['max_7day_posts'].max().reset_index()
    return posts[['user_id', 'max_7day_posts', 'avg_weekly_posts']]
