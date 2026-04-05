#
# Problem: 608. Tree Node
# Difficulty: Medium
# Link: https://leetcode.com/problems/tree-node/
# Language: python3
# Date: 2026-04-05


import pandas as pd

def tree_node(tree: pd.DataFrame) -> pd.DataFrame:
    tree['type']='Leaf'
    tree.loc[tree['id'].isin(tree['p_id']), 'type']='Inner'
    tree.loc[tree['p_id'].isna(), 'type']='Root'
    return tree[['id', 'type']]
