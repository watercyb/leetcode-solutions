#
# Problem: 3230. Customer Purchasing Behavior Analysis
# Difficulty: Medium
# Link: https://leetcode.com/problems/customer-purchasing-behavior-analysis/
# Language: python3
# Date: 2026-05-05


import pandas as pd

def analyze_customer_behavior(transactions: pd.DataFrame, products: pd.DataFrame) -> pd.DataFrame:
    transactions = pd.merge(transactions, products, on='product_id').sort_values("transaction_date", ascending=False)
    transactions = transactions.groupby("customer_id", as_index=False).agg(
        total_amount=("amount", "sum"),
        transaction_count=("transaction_id", "count"),
        unique_categories=("category", "nunique"),
        avg_transaction_amount=("amount", "mean"),
        top_category=("category", lambda x: multimode(x)[0])
    )
    transactions['avg_transaction_amount']=(transactions['avg_transaction_amount']+0.00001).round(2)
    transactions['loyalty_score']=(transactions['transaction_count']*10+transactions['total_amount']/100+0.00001).round(2)
    return transactions.sort_values(by=['loyalty_score', 'customer_id'], ascending=[False, True])
