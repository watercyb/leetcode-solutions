#
# Problem: 615. Average Salary: Departments VS Company
# Difficulty: Hard
# Link: https://leetcode.com/problems/average-salary-departments-vs-company/
# Language: python3
# Date: 2026-04-05


import pandas as pd

def average_salary(salary: pd.DataFrame, employee: pd.DataFrame) -> pd.DataFrame:
    salary=pd.merge(salary, employee, how='inner', on='employee_id')
    salary['pay_month']=salary['pay_date'].dt.strftime('%Y-%m')
    salary['avg']=salary.groupby(['pay_month', 'department_id'])['amount'].transform('mean')
    salary['avg1']=salary.groupby('pay_month')['amount'].transform('mean')
    salary['comparison']=salary.apply(lambda x: 'higher' if x['avg']>x['avg1'] else 'same' if x['avg']==x['avg1'] else 'lower', axis=1)
    return salary[['pay_month', 'department_id', 'comparison']].drop_duplicates()
