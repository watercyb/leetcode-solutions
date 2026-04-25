#
# Problem: 2253. Dynamic Unpivoting of a Table
# Difficulty: Hard
# Link: https://leetcode.com/problems/dynamic-unpivoting-of-a-table/
# Language: python3
# Date: 2026-04-25


import pandas as pd

def find_valid_users(products: pd.DataFrame) -> pd.DataFrame:
   products=pd.melt(products, id_vars=["product_id"], var_name="store", value_name="price")
   products=products[~products['price'].isna()]
   return products
