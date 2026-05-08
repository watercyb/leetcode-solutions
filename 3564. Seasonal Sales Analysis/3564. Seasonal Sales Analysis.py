#
# Problem: 3564. Seasonal Sales Analysis
# Difficulty: Medium
# Link: https://leetcode.com/problems/seasonal-sales-analysis/
# Language: python3
# Date: 2026-05-08


import pandas as pd

def seasonal_sales_analysis(products: pd.DataFrame, sales: pd.DataFrame) -> pd.DataFrame:
    cmb=pd.merge(products, sales, on='product_id', how='inner')
    seasons = ['Winter', 'Winter', 'Spring', 'Spring', 'Spring',
           'Summer', 'Summer', 'Summer', 'Fall', 'Fall', 'Fall', 'Winter']
    cmb['sale_date'] = cmb['sale_date'].dt.month.apply(lambda m: seasons[m - 1])
    cmb['price']=cmb['quantity']*cmb['price']
    grp = cmb.groupby(['category','sale_date']).agg({'quantity': 'sum','price': 'sum'}).reset_index()
    grp.rename(columns={'sale_date': 'season','quantity': 'total_quantity','price': 'total_revenue'}, inplace=True)
    grp = grp.sort_values(by=['season', 'total_quantity', 'total_revenue'], ascending=[True, False, False])
    grp = grp.groupby('season').head(1)
    return grp[['season', 'category', 'total_quantity', 'total_revenue']].sort_values(by='season', ascending=True)
