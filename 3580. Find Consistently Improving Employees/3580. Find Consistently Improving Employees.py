#
# Problem: 3580. Find Consistently Improving Employees
# Difficulty: Medium
# Link: https://leetcode.com/problems/find-consistently-improving-employees/?envType=problem-list-v2&envId=ne414q67
# Language: python3
# Date: 2026-04-13


import pandas as pd

def find_consistently_improving_employees(employees: pd.DataFrame, performance_reviews: pd.DataFrame) -> pd.DataFrame:
    def check_decreasing(sub_df):
        top3 = sub_df.sort_values('review_date', ascending=False).head(3)
        b_values = top3['rating'].values
        if ((len(b_values) >= 3) and (b_values[0] > b_values[1]) and (b_values[1] > b_values[2])):
            return b_values[0]-b_values[2]
        return 0
    res = performance_reviews.groupby('employee_id').apply(check_decreasing).reset_index(name='improvement_score')
    res = res[res['improvement_score']>0]
    return pd.merge(res, employees, on='employee_id', how='inner')[['employee_id','name','improvement_score']].sort_values(['improvement_score','name'], ascending=[False, True])
