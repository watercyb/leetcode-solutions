#
# Problem: 2362. Generate the Invoice
# Difficulty: Hard
# Link: https://leetcode.com/problems/generate-the-invoice/
# Language: python3
# Date: 2026-04-26


import pandas as pd

def generate_the_invoice(products: pd.DataFrame, purchases: pd.DataFrame) -> pd.DataFrame:
    purchases=pd.merge(purchases, products, how='inner', on='product_id')
    purchases['price']=purchases['quantity']*purchases['price']
    purchases['sum']=purchases.groupby('invoice_id')['price'].transform('sum')
    max_id=purchases.sort_values(by=['sum', 'invoice_id'], ascending=[False, True])['invoice_id'].iloc[0]
    return purchases[purchases['invoice_id']==max_id][['product_id', 'quantity', 'price']]
