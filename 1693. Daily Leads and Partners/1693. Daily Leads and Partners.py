#
# Problem: 1693. Daily Leads and Partners
# Difficulty: Easy
# Link: https://leetcode.com/problems/daily-leads-and-partners/
# Language: python3
# Date: 2026-04-19


import pandas as pd

def daily_leads_and_partners(daily_sales: pd.DataFrame) -> pd.DataFrame:
    return daily_sales.groupby(['date_id','make_name']).agg({
        'lead_id': 'nunique',
        'partner_id': 'nunique'
    }).reset_index().rename(columns={'lead_id': 'unique_leads', 'partner_id': 'unique_partners'})
