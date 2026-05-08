#
# Problem: 3586. Find COVID Recovery Patients
# Difficulty: Medium
# Link: https://leetcode.com/problems/find-covid-recovery-patients/
# Language: python3
# Date: 2026-05-08


import pandas as pd

def find_covid_recovery_patients(patients: pd.DataFrame, covid_tests: pd.DataFrame) -> pd.DataFrame:
    merge=pd.merge(covid_tests[covid_tests['result']=='Negative'], covid_tests[covid_tests['result']=='Positive'].groupby('patient_id').min().reset_index()[['patient_id','test_date']], how='left', on='patient_id')
    merge['recovery_time']=(pd.to_datetime(merge['test_date_x'])-pd.to_datetime(merge['test_date_y'])).dt.days
    return pd.merge(patients, merge[merge['recovery_time']>0].groupby('patient_id').min('recovery_time').reset_index(), how='inner', on='patient_id')[['patient_id', 'patient_name', 'age', 'recovery_time']].sort_values(by=['recovery_time', 'patient_name'], ascending=[True, True])
