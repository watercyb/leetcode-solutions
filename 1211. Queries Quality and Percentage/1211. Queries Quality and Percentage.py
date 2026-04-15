#
# Problem: 1211. Queries Quality and Percentage
# Difficulty: Easy
# Link: https://leetcode.com/problems/queries-quality-and-percentage/
# Language: python3
# Date: 2026-04-15


import pandas as pd

def queries_stats(queries: pd.DataFrame) -> pd.DataFrame:
    queries['poor_query_percentage'] = queries['rating'].apply(lambda x: 1 if x<3 else 0)
    queries['quality'] = queries['rating']/queries['position']
    queries=queries.groupby('query_name').agg({'quality': 'mean', 'poor_query_percentage': 'mean'}).reset_index()
    queries['poor_query_percentage']=((queries['poor_query_percentage']+0.000001)*100).round(2)
    queries['quality']=(queries['quality']+0.000001).round(2)
    return queries
