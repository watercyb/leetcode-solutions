#
# Problem: 1364. Number of Trusted Contacts of a Customer
# Difficulty: Medium
# Link: https://leetcode.com/problems/number-of-trusted-contacts-of-a-customer/
# Language: python3
# Date: 2026-04-16


import pandas as pd

def count_trusted_contacts(customers: pd.DataFrame, contacts: pd.DataFrame, invoices: pd.DataFrame) -> pd.DataFrame:
    def chk(email):
        if email in customers['email'].values:
            return 1
        return 0
    contacts['trusted_contacts_cnt']=contacts['contact_email'].apply(chk)
    contacts=contacts.groupby('user_id').agg({'contact_name': 'size', 'trusted_contacts_cnt': 'sum'}).reset_index()
    customers=pd.merge(customers, contacts, how='left', left_on='customer_id', right_on='user_id').fillna(0)
    invoices=pd.merge(invoices, customers, how='inner', left_on='user_id', right_on='customer_id')
    return invoices.rename(columns={'contact_name': 'contacts_cnt'})[['invoice_id', 'customer_name', 'price', 'contacts_cnt', 'trusted_contacts_cnt']].sort_values(by='invoice_id', ascending=True)
