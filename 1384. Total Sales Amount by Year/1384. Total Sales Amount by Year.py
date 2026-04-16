#
# Problem: 1384. Total Sales Amount by Year
# Difficulty: Hard
# Link: https://leetcode.com/problems/total-sales-amount-by-year/
# Language: python3
# Date: 2026-04-16


import pandas as pd

def total_sales(product: pd.DataFrame, sales: pd.DataFrame) -> pd.DataFrame:
    def func_2018(row):
        l=max(pd.to_datetime(row['period_start']), pd.to_datetime('2018-01-01'))
        r=min(pd.to_datetime('2018-12-31'), pd.to_datetime(row['period_end']))
        return max((r-l).days+1,0)*row['average_daily_sales']

    def func_2019(row):
        l=max(pd.to_datetime(row['period_start']), pd.to_datetime('2019-01-01'))
        r=min(pd.to_datetime('2019-12-31'), pd.to_datetime(row['period_end']))
        return max((r-l).days+1,0)*row['average_daily_sales']

    def func_2020(row):
        l=max(pd.to_datetime(row['period_start']), pd.to_datetime('2020-01-01'))
        r=min(pd.to_datetime('2020-12-31'), pd.to_datetime(row['period_end']))
        return max((r-l).days+1,0)*row['average_daily_sales']

    sales['2018']=sales.apply(func_2018,axis=1)
    sales['2019']=sales.apply(func_2019,axis=1)
    sales['2020']=sales.apply(func_2020,axis=1)
    df=pd.concat([pd.DataFrame({'product_id': sales['product_id'], 'report_year': '2018', 'total_amount': sales['2018']}), pd.DataFrame({'product_id': sales['product_id'], 'report_year': '2019', 'total_amount': sales['2019']}), pd.DataFrame({'product_id': sales['product_id'], 'report_year': '2020', 'total_amount': sales['2020']})])
    df=df[df['total_amount']!=0]
    df=pd.merge(product, df, how='inner', on='product_id')
    return df.sort_values(by=['product_id', 'report_year'])
