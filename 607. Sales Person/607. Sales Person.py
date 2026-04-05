#
# Problem: 607. Sales Person
# Difficulty: Easy
# Link: https://leetcode.com/problems/sales-person/
# Language: python3
# Date: 2026-04-05


import pandas as pd

def sales_person(sales_person: pd.DataFrame, company: pd.DataFrame, orders: pd.DataFrame) -> pd.DataFrame:
    orders=orders[orders['com_id'].isin(company[company['name']=='RED']['com_id'])]
    sales_person = sales_person[~sales_person['sales_id'].isin(orders['sales_id'])]
    return sales_person[['name']]
