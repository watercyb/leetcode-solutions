#
# Problem: 3832. Find Users with Persistent Behavior Patterns
# Difficulty: Hard
# Link: https://leetcode.com/problems/find-users-with-persistent-behavior-patterns/
# Language: python3
# Date: 2026-05-11


import pandas as pd

def find_behaviorally_stable_users(activity: pd.DataFrame) -> pd.DataFrame:
    # Ensure datetime & sort
    activity = activity.copy()
    activity['action_date'] = pd.to_datetime(activity['action_date'])
    activity = activity.sort_values(['user_id', 'action', 'action_date'])

    # Detect breaks in consecutive days
    activity['day_diff'] = (
        activity
        .groupby(['user_id', 'action'])['action_date']
        .diff()
        .dt.days
    )

    # Start a new streak when day_diff != 1
    activity['streak_id'] = (
        activity['day_diff'].ne(1)
        .groupby([activity['user_id'], activity['action']])
        .cumsum()
    )

    # Aggregate streaks
    streaks = (
        activity
        .groupby(['user_id', 'action', 'streak_id'])
        .agg(
            streak_length=('action_date', 'count'),
            start_date=('action_date', 'min'),
            end_date=('action_date', 'max')
        )
        .reset_index()
    )

    # Keep only streaks >= 5
    streaks = streaks[streaks['streak_length'] >= 5]

    # For each user, keep the longest streak
    streaks = (
        streaks
        .sort_values(['user_id', 'streak_length'], ascending=[True, False])
        .drop_duplicates('user_id')
    )

    # Final ordering
    return streaks[['user_id', 'action', 'streak_length', 'start_date', 'end_date']].sort_values(
        ['streak_length', 'user_id'],
        ascending=[False, True]
    ).reset_index(drop=True)
