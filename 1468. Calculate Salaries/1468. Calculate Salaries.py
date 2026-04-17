#
# Problem: 1468. Calculate Salaries
# Difficulty: Medium
# Link: https://leetcode.com/problems/calculate-salaries/
# Language: python3
# Date: 2026-04-17


import pandas as pd

def calculate_salaries(salaries: pd.DataFrame) -> pd.DataFrame:
    tax=salaries.groupby('company_id')['salary'].max().reset_index()
    tax['p']=tax['salary'].apply(lambda x: 1 if x<1000 else 0.76 if x<=10000 else 0.51)
    salaries=pd.merge(salaries, tax, how='inner', on='company_id')
    salaries['salary']=(salaries['salary_x']*salaries['p']+0.000001).round(0)
    return salaries[['company_id', 'employee_id', 'employee_name', 'salary']]
