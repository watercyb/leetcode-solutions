#
# Problem: 2978. Symmetric Coordinates
# Difficulty: Medium
# Link: https://leetcode.com/problems/symmetric-coordinates/
# Language: python3
# Date: 2026-05-02


import pandas as pd

def symmetric_pairs(coordinates: pd.DataFrame) -> pd.DataFrame:
    coordinates=pd.merge(coordinates, coordinates, how='inner', left_on=['X', 'Y'], right_on=['Y', 'X'])
    coordinates=coordinates.groupby(['X_x', 'Y_x']).size().reset_index(name='count')
    coordinates=coordinates[(coordinates['X_x']<coordinates['Y_x']) | ((coordinates['X_x']==coordinates['Y_x']) & (coordinates['count']>1))]
    return coordinates.rename(columns={'X_x': 'x', 'Y_x': 'y'})[['x', 'y']].sort_values(by=['x', 'y'])
