#
# Problem: 2988. Manager of the Largest Department
# Difficulty: Medium
# Link: https://leetcode.com/problems/manager-of-the-largest-department/
# Language: python3
# Date: 2026-05-02


import pandas as pd

def find_manager(employees: pd.DataFrame) -> pd.DataFrame:
    employees['size']=employees.groupby('dep_id').transform('size')
    employees=employees[(employees['size']==employees['size'].max()) & (employees['position']=='Manager')]
    return employees[['emp_name', 'dep_id']].rename(columns={'emp_name': 'manager_name'}).sort_values(by='dep_id')
