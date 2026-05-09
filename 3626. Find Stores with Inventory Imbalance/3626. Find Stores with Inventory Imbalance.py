#
# Problem: 3626. Find Stores with Inventory Imbalance
# Difficulty: Medium
# Link: https://leetcode.com/problems/find-stores-with-inventory-imbalance/
# Language: python3
# Date: 2026-05-09


import pandas as pd

def find_inventory_imbalance(stores: pd.DataFrame, inventory: pd.DataFrame) -> pd.DataFrame:
    inventory['max']=inventory.groupby('store_id')['price'].transform('max')
    inventory['min']=inventory.groupby('store_id')['price'].transform('min')
    inventory['sum']=inventory.groupby('store_id')['product_name'].transform('count')
    inventory=inventory[inventory['sum']>=3]
    inventory=pd.merge(inventory[inventory['price']==inventory['max']], inventory[inventory['price']==inventory['min']], how='inner', on='store_id')
    inventory['imbalance_ratio']=(inventory['quantity_y']/inventory['quantity_x']).round(2)
    inventory=inventory[inventory['imbalance_ratio']>1]
    inventory=inventory.rename(columns={'product_name_x': 'most_exp_product', 'product_name_y': 'cheapest_product'})
    df=pd.merge(stores, inventory, how='inner', on='store_id')
    df=df[['store_id', 'store_name', 'location', 'most_exp_product', 'cheapest_product', 'imbalance_ratio']].sort_values(by=['imbalance_ratio', 'store_name'], ascending=[False, True])
    return df
