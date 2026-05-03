#
# Problem: 3054. Binary Tree Nodes
# Difficulty: Medium
# Link: https://leetcode.com/problems/binary-tree-nodes/
# Language: python3
# Date: 2026-05-03


import pandas as pd

def binary_tree_nodes(tree: pd.DataFrame) -> pd.DataFrame:
    tree=pd.merge(tree, tree, how='left', left_on='N', right_on='P')
    tree['Type']=tree.apply(lambda row: 'Root' if pd.isna(row['P_x']) else 'Leaf' if pd.isna(row['N_y']) else 'Inner', axis=1)
    return tree[['N_x', 'Type']].drop_duplicates().rename(columns={'N_x': 'N'}).sort_values(by='N')
