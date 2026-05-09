#
# Problem: 3657. Find Loyal Customers
# Difficulty: Medium
# Link: https://leetcode.com/problems/find-loyal-customers/
# Language: python3
# Date: 2026-05-09


import pandas as pd

def find_loyal_customers(customer_transactions: pd.DataFrame) -> pd.DataFrame:
    customer_transactions['purchase']=customer_transactions['transaction_type'].apply(lambda x: 1 if x=='purchase' else 0)
    customer_transactions['refund']=customer_transactions['transaction_type'].apply(lambda x: 1 if x=='refund' else 0)
    customer_transactions=customer_transactions.groupby('customer_id').agg(purchase=('purchase', 'sum'), refund=('refund', 'sum'), min=('transaction_date', 'min'), max=('transaction_date', 'max')).reset_index()
    customer_transactions=customer_transactions[(customer_transactions['purchase']>=3) & ((pd.to_datetime(customer_transactions['max'])-pd.to_datetime(customer_transactions['min'])).dt.total_seconds()//(24*60*60)>=30) & (customer_transactions['refund']/(customer_transactions['refund']+customer_transactions['purchase'])<0.2)]
    return customer_transactions[['customer_id']].sort_values(by='customer_id')
