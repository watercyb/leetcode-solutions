#
# Problem: 569. Median Employee Salary
# Difficulty: Hard
# Link: https://leetcode.com/problems/median-employee-salary/
# Language: python3
# Date: 2026-04-04


import pandas as pd

def median_employee_salary(employee: pd.DataFrame) -> pd.DataFrame:
    if employee.shape[0]==0:
        return employee
    employee=employee.sort_values(['salary', 'id'])
    employee['rank'] = employee.groupby('company').cumcount()+1
    employee['max'] = employee.groupby('company')['rank'].transform('max')
    def f(row):
        if row['max']%2==0:
            return row['rank']==row['max']//2 or row['rank']==row['max']//2+1
        return row['rank']==(row['max']+1)//2
    employee=employee[employee.apply(f,axis=1)]
    return employee[['id', 'company', 'salary']]
