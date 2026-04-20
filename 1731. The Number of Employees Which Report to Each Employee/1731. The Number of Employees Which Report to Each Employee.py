#
# Problem: 1731. The Number of Employees Which Report to Each Employee
# Difficulty: Easy
# Link: https://leetcode.com/problems/the-number-of-employees-which-report-to-each-employee/
# Language: python3
# Date: 2026-04-20


import pandas as pd

def count_employees(employees: pd.DataFrame) -> pd.DataFrame:
    employees=pd.merge(employees[['employee_id', 'name']], employees[['reports_to', 'age']], how='inner', left_on='employee_id', right_on='reports_to')
    employees=employees.groupby(['employee_id', 'name']).agg(reports_count=('reports_to', 'count'),
    average_age=('age', 'mean')).reset_index()
    employees['average_age']=np.floor(employees['average_age'] + 0.5)
    return employees
