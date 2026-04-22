#
# Problem: 1978. Employees Whose Manager Left the Company
# Difficulty: Easy
# Link: https://leetcode.com/problems/employees-whose-manager-left-the-company/
# Language: python3
# Date: 2026-04-22


import pandas as pd

def find_employees(employees: pd.DataFrame) -> pd.DataFrame:
    employees=employees[((~employees['manager_id'].isnull()) & (~employees['manager_id'].isin(employees['employee_id']))) & (employees['salary']<30000)]
    return employees[['employee_id']].sort_values(by='employee_id')
