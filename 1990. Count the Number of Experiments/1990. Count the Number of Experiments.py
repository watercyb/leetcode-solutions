#
# Problem: 1990. Count the Number of Experiments
# Difficulty: Medium
# Link: https://leetcode.com/problems/count-the-number-of-experiments/
# Language: python3
# Date: 2026-04-22


import pandas as pd

def count_experiments(experiments: pd.DataFrame) -> pd.DataFrame:
    df=pd.merge(pd.DataFrame({'platform': ['Android', 'IOS', 'Web']}), pd.DataFrame({'experiment_name': ['Reading', 'Sports', 'Programming']}), how='cross')
    df['num_experiments']=0
    experiments=experiments.groupby(['platform', 'experiment_name']).size().reset_index(name='num_experiments')
    df=pd.concat([df, experiments])
    df=df.groupby(['platform', 'experiment_name']).sum().reset_index()
    return df
