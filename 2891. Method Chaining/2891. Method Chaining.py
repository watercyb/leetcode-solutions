#
# Problem: 2891. Method Chaining
# Difficulty: Easy
# Link: https://leetcode.com/problems/method-chaining/
# Language: python3
# Date: 2026-05-01


import pandas as pd

def findHeavyAnimals(animals: pd.DataFrame) -> pd.DataFrame:
    return animals[animals['weight'] > 100].sort_values(by='weight', ascending=False)[['name']]
