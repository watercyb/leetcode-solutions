#
# Problem: 3764. Most Common Course Pairs
# Difficulty: Hard
# Link: https://leetcode.com/problems/most-common-course-pairs/
# Language: python3
# Date: 2026-05-10


import pandas as pd

def topLearnerCourseTransitions(course_completions: pd.DataFrame) -> pd.DataFrame:
    course_completions['count']=course_completions.groupby('user_id').transform('size')
    course_completions=course_completions[course_completions['count']>=5]
    course_completions['mean']=course_completions.groupby('user_id')['course_rating'].transform('mean')
    course_completions=course_completions[course_completions['mean']>=4]
    course_completions=course_completions.sort_values(by=['user_id', 'completion_date'])
    course_completions['next_id']=course_completions['user_id'].shift(-1)
    course_completions['second_course']=course_completions['course_name'].shift(-1)
    course_completions=course_completions[course_completions['user_id']==course_completions['next_id']][['course_name', 'second_course']].rename(columns={'course_name': 'first_course'})
    course_completions=course_completions.groupby(['first_course', 'second_course']).size().reset_index(name='transition_count')
    course_completions['a']=course_completions["first_course"].str.lower()
    course_completions['b']=course_completions["second_course"].str.lower()
    return course_completions.sort_values(by=['transition_count', 'a', 'b'], ascending=[False, True, True])[['first_course', 'second_course', 'transition_count']]
