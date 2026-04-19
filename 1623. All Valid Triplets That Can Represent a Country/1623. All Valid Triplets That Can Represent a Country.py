#
# Problem: 1623. All Valid Triplets That Can Represent a Country
# Difficulty: Easy
# Link: https://leetcode.com/problems/all-valid-triplets-that-can-represent-a-country/
# Language: python3
# Date: 2026-04-19


import pandas as pd

def find_valid_triplets(school_a: pd.DataFrame, school_b: pd.DataFrame, school_c: pd.DataFrame) -> pd.DataFrame:
    df=pd.merge(school_a, school_b, how='cross')
    df=df[(df['student_id_x']!=df['student_id_y']) & (df['student_name_x']!=df['student_name_y'])]
    df=pd.merge(df, school_c, how='cross')
    df=df[(df['student_id_x']!=df['student_id']) & (df['student_id_y']!=df['student_id']) & (df['student_name_x']!=df['student_name']) & (df['student_name_y']!=df['student_name'])]
    return df[['student_name_x', 'student_name_y', 'student_name']].rename(columns={'student_name_x': 'member_A', 'student_name_y': 'member_B', 'student_name': 'member_C'})
