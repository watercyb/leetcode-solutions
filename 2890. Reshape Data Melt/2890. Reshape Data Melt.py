#
# Problem: 2890. Reshape Data: Melt
# Difficulty: Easy
# Link: https://leetcode.com/problems/reshape-data-melt/
# Language: python3
# Date: 2026-05-01


import pandas as pd

def meltTable(report: pd.DataFrame) -> pd.DataFrame:
    return report.melt(id_vars=["product"], var_name="quarter", value_name="sales")
