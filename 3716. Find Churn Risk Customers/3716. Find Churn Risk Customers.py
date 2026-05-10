#
# Problem: 3716. Find Churn Risk Customers
# Difficulty: Medium
# Link: https://leetcode.com/problems/find-churn-risk-customers/
# Language: python3
# Date: 2026-05-10


import pandas as pd

def find_churn_risk_customers(subscription_events: pd.DataFrame) -> pd.DataFrame:
    subscription_events=subscription_events.sort_values(by='event_date', ascending=False)
    subscription_events = subscription_events.groupby('user_id').agg(
        current_plan=('plan_name', 'first'),
        current_monthly_amount=('monthly_amount', 'first'),
        max_historical_amount=('monthly_amount', 'max'),
        min_date=('event_date', 'min'),
        max_date=('event_date', 'max')
    ).reset_index()
    subscription_events['days_as_subscriber']=(pd.to_datetime(subscription_events['max_date'])-pd.to_datetime(subscription_events['min_date'])).dt.days
    subscription_events=subscription_events[(subscription_events['current_monthly_amount']!=0) & (subscription_events['current_monthly_amount']/subscription_events['max_historical_amount']<0.5) & (subscription_events['days_as_subscriber']>=60)]
    return subscription_events[['user_id', 'current_plan', 'current_monthly_amount', 'max_historical_amount', 'days_as_subscriber']].sort_values(by=['days_as_subscriber', 'user_id'], ascending=[False, True])
