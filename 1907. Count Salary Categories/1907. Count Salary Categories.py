#
# Problem: 1907. Count Salary Categories
# Difficulty: Medium
# Link: https://leetcode.com/problems/count-salary-categories/
# Language: python3
# Date: 2026-04-22


import pandas as pd

def count_salary_categories(accounts: pd.DataFrame) -> pd.DataFrame:
    accounts['category']=accounts['income'].apply(lambda x: 'Low Salary' if x<20000 else 'Average Salary' if x<=50000 else 'High Salary')
    accounts=accounts.groupby('category').size().reset_index(name='accounts_count')
    accounts=pd.merge(pd.DataFrame({'category': ['Low Salary', 'Average Salary', 'High Salary']}), accounts, how='left', on='category').fillna(0)
    return accounts
