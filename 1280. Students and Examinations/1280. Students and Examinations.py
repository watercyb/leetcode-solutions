#
# Problem: 1280. Students and Examinations
# Difficulty: Easy
# Link: https://leetcode.com/problems/students-and-examinations/
# Language: python3
# Date: 2026-04-15


import pandas as pd

def students_and_examinations(students: pd.DataFrame, subjects: pd.DataFrame, examinations: pd.DataFrame) -> pd.DataFrame:
    df = pd.merge(students, subjects, how="cross")
    examinations = (
        examinations.groupby(["student_id", "subject_name"])
        .size()
        .reset_index(name="attended_exams")
    )
    df = pd.merge(
        df, examinations, how="left", on=["student_id", "subject_name"]
    ).sort_values(by=["student_id", "subject_name"])
    df["attended_exams"] = df["attended_exams"].fillna(0)
    return df
