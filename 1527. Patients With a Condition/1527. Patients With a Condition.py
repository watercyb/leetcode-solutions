#
# Problem: 1527. Patients With a Condition
# Difficulty: Easy
# Link: https://leetcode.com/problems/patients-with-a-condition/
# Language: python3
# Date: 2026-04-18


import pandas as pd

def find_patients(patients: pd.DataFrame) -> pd.DataFrame:
    patients=patients[patients['conditions'].str.contains(r'(^DIAB1|\sDIAB1)')]
    return patients
