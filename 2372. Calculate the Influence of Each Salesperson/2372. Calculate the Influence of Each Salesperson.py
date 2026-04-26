#
# Problem: 2372. Calculate the Influence of Each Salesperson
# Difficulty: Medium
# Link: https://leetcode.com/problems/calculate-the-influence-of-each-salesperson/
# Language: python3
# Date: 2026-04-26


import pandas as pd

def calculate_influence(salesperson: pd.DataFrame, customer: pd.DataFrame, sales: pd.DataFrame) -> pd.DataFrame:
    customer=pd.merge(customer, sales, how='inner', on='customer_id')
    customer=customer.groupby('salesperson_id')['price'].sum().reset_index(name='total')
    salesperson=pd.merge(salesperson, customer, how='left', on='salesperson_id').fillna(0)
    return salesperson
