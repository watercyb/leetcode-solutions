#
# Problem: 3521. Find Product Recommendation Pairs
# Difficulty: Medium
# Link: https://leetcode.com/problems/find-product-recommendation-pairs/
# Language: python3
# Date: 2026-05-08


import pandas as pd

def find_product_recommendation_pairs(product_purchases: pd.DataFrame, product_info: pd.DataFrame) -> pd.DataFrame:
    product_purchases=pd.merge(product_purchases, product_purchases, how="inner", on="user_id")
    product_purchases=product_purchases.loc[product_purchases["product_id_x"]<product_purchases["product_id_y"]]
    product_purchases=product_purchases[["user_id", "product_id_x", "product_id_y"]].rename(columns={"product_id_x": "product1_id", "product_id_y": "product2_id"})
    product_purchases=product_purchases.groupby(["product1_id", "product2_id"])["user_id"].nunique().reset_index(name="customer_count")
    product_purchases=product_purchases[product_purchases["customer_count"]>=3]
    product_purchases=pd.merge(product_purchases, product_info, how="inner", left_on="product1_id", right_on="product_id")
    product_purchases=pd.merge(product_purchases, product_info, how="inner", left_on="product2_id", right_on="product_id")
    product_purchases=product_purchases[["product1_id", "product2_id", "category_x", "category_y", "customer_count"]].rename(columns={"category_x": "product1_category", "category_y": "product2_category"})
    return product_purchases.sort_values(by=["customer_count", "product1_id", "product2_id"], ascending=[False, True, True])
