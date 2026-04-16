#
# Problem: 1393. Capital Gain/Loss
# Difficulty: Medium
# Link: https://leetcode.com/problems/capital-gainloss/
# Language: python3
# Date: 2026-04-16


import pandas as pd

def capital_gainloss(stocks: pd.DataFrame) -> pd.DataFrame:
    stocks['price']=stocks['price']*stocks['operation'].apply(lambda x: 1 if x=='Sell' else -1)
    stocks=stocks.groupby('stock_name')['price'].sum().reset_index(name='capital_gain_loss')
    return stocks
