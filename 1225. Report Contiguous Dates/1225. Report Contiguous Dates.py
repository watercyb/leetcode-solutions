#
# Problem: 1225. Report Contiguous Dates
# Difficulty: Hard
# Link: https://leetcode.com/problems/report-contiguous-dates/
# Language: python3
# Date: 2026-04-15


import pandas as pd

def report_contiguous_dates(failed: pd.DataFrame, succeeded: pd.DataFrame) -> pd.DataFrame:
    failed=failed[failed['fail_date'].dt.year==2019]
    failed['rnk']=failed['fail_date']-pd.to_timedelta(range(0,failed.shape[0]),unit='D')
    failed=failed.groupby('rnk').agg(start_date=('fail_date', 'min'), end_date=('fail_date', 'max'))
    failed['period_state']='failed'
    succeeded=succeeded[succeeded['success_date'].dt.year==2019]
    succeeded['rnk']=succeeded['success_date']-pd.to_timedelta(range(0,succeeded.shape[0]),unit='D')
    succeeded=succeeded.groupby('rnk').agg(start_date=('success_date', 'min'), end_date=('success_date', 'max'))
    succeeded['period_state']='succeeded'
    return pd.concat([failed, succeeded])[['period_state', 'start_date', 'end_date']].sort_values(by='start_date')
