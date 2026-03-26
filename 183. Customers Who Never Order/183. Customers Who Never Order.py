#
# Problem: 183. Customers Who Never Order
# Difficulty: Easy
# Link: https://leetcode.com/problems/customers-who-never-order/
# Language: python3
# Date: 2026-03-26


import pandas as pd

def find_customers(customers: pd.DataFrame, orders: pd.DataFrame) -> pd.DataFrame:
    customers=customers[~customers['id'].isin(orders['customerId'])]
    return customers.rename(columns={'name': 'Customers'})[['Customers']]
