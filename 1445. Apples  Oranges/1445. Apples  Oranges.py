#
# Problem: 1445. Apples & Oranges
# Difficulty: Medium
# Link: https://leetcode.com/problems/apples-oranges/
# Language: python3
# Date: 2026-04-17


import pandas as pd

def apples_oranges(sales: pd.DataFrame) -> pd.DataFrame:
    sales['sold_num']=sales.apply(lambda row: row['sold_num'] if row['fruit']=='apples' else -row['sold_num'],axis=1)
    sales=sales.groupby('sale_date')['sold_num'].sum().reset_index(name='diff')
    return sales
