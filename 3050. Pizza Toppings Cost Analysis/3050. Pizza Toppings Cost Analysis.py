#
# Problem: 3050. Pizza Toppings Cost Analysis
# Difficulty: Medium
# Link: https://leetcode.com/problems/pizza-toppings-cost-analysis/
# Language: python3
# Date: 2026-05-03


import pandas as pd

def cost_analysis(toppings: pd.DataFrame) -> pd.DataFrame:
    df=pd.merge(toppings, toppings, how='cross')
    df=df[df['topping_name_x']<df['topping_name_y']]
    df=pd.merge(df, toppings, how='cross')
    df=df[df['topping_name']>df['topping_name_y']]
    df['pizza']=df['topping_name_x']+','+df['topping_name_y']+','+df['topping_name']
    df['total_cost']=(df['cost_x']+df['cost_y']+df['cost']).round(2)
    df = df.sort_values(by=['total_cost', 'pizza'], ascending=[False, True])
    return df[['pizza', 'total_cost']]
