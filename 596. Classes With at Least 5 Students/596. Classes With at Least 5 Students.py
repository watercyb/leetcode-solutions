#
# Problem: 596. Classes With at Least 5 Students
# Difficulty: Easy
# Link: https://leetcode.com/problems/classes-with-at-least-5-students/
# Language: python3
# Date: 2026-04-04


import pandas as pd

def find_classes(courses: pd.DataFrame) -> pd.DataFrame:
    courses=courses.groupby('class')['student'].size().reset_index()
    return courses[courses['student']>=5][['class']]
