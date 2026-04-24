#
# Problem: 2118. Build the Equation
# Difficulty: Hard
# Link: https://leetcode.com/problems/build-the-equation/
# Language: python3
# Date: 2026-04-24


import pandas as pd

def build_the_equation(terms: pd.DataFrame) -> pd.DataFrame:
    terms=terms[terms['factor']!=0]
    terms=terms.sort_values(by='power', ascending=False)
    terms['factor']=terms['factor'].apply(lambda x: '+'+str(x) if x>0 else str(x))
    terms['power']=terms['power'].apply(lambda x: 'X^'+str(x) if x>1 else 'X' if x==1 else '')
    terms['item']=terms['factor']+terms['power']
    string=terms['item'].str.cat()+'=0'
    return pd.DataFrame({'equation': [string]})
