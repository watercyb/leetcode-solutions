#
# Problem: 1821. Find Customers With Positive Revenue this Year
# Difficulty: Easy
# Link: https://leetcode.com/problems/find-customers-with-positive-revenue-this-year/
# Language: python3
# Date: 2026-04-21


import pandas as pd

def find_customers(customers: pd.DataFrame) -> pd.DataFrame:
    customers=customers[customers['year']==2021]
    customers=customers.groupby('customer_id')['revenue'].sum().reset_index()
    customers=customers[customers['revenue']>0]
    return customers[['customer_id']]
