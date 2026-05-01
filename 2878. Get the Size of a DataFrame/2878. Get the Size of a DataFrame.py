#
# Problem: 2878. Get the Size of a DataFrame
# Difficulty: Easy
# Link: https://leetcode.com/problems/get-the-size-of-a-dataframe/
# Language: python3
# Date: 2026-05-01


import pandas as pd

def getDataframeSize(players: pd.DataFrame) -> List[int]:
    return list(players.shape)
