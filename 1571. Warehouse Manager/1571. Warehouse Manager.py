#
# Problem: 1571. Warehouse Manager
# Difficulty: Easy
# Link: https://leetcode.com/problems/warehouse-manager/
# Language: python3
# Date: 2026-04-18


import pandas as pd

def warehouse_manager(warehouse: pd.DataFrame, products: pd.DataFrame) -> pd.DataFrame:
    products['volume']=products['Width']*products['Length']*products['Height']
    warehouse=pd.merge(warehouse, products, how='inner', on='product_id')
    warehouse['volume']=warehouse['volume']*warehouse['units']
    warehouse=warehouse.groupby('name')['volume'].sum().reset_index()
    return warehouse.rename(columns={'name': 'warehouse_name'})
