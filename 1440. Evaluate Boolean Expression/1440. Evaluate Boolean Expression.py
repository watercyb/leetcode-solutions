#
# Problem: 1440. Evaluate Boolean Expression
# Difficulty: Medium
# Link: https://leetcode.com/problems/evaluate-boolean-expression/
# Language: python3
# Date: 2026-04-17


import pandas as pd

def eval_expression(variables: pd.DataFrame, expressions: pd.DataFrame) -> pd.DataFrame:
    expressions=pd.merge(expressions, variables, how='inner', left_on='left_operand', right_on='name')
    expressions=pd.merge(expressions, variables, how='inner', left_on='right_operand', right_on='name')
    expressions['value']=expressions.apply(lambda row: row['value_x']<row['value_y'] if row['operator']=='<' else row['value_x']>row['value_y'] if row['operator']=='>' else row['value_x']==row['value_y'], axis=1).map({True: 'true', False: 'false'})
    return expressions[['left_operand', 'operator', 'right_operand', 'value']]
