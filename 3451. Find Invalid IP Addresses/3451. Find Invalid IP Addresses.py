#
# Problem: 3451. Find Invalid IP Addresses
# Difficulty: Hard
# Link: https://leetcode.com/problems/find-invalid-ip-addresses/?envType=problem-list-v2&envId=ne414q67
# Language: python3
# Date: 2026-04-13


import pandas as pd

def find_invalid_ips(logs: pd.DataFrame) -> pd.DataFrame:
    logs=logs[~logs['ip'].str.contains(r'^([0-9]|([1-9][0-9])|(1[0-9][0-9])|(2[0-4][0-9])|(25[0-5]))\.([0-9]|([1-9][0-9])|(1[0-9][0-9])|(2[0-4][0-9])|(25[0-5]))\.([0-9]|([1-9][0-9])|(1[0-9][0-9])|(2[0-4][0-9])|(25[0-5]))\.([0-9]|([1-9][0-9])|(1[0-9][0-9])|(2[0-4][0-9])|(25[0-5]))$')]
    logs=logs.groupby('ip').size().reset_index(name='invalid_count')
    return logs.sort_values(by=['invalid_count', 'ip'], ascending=[False, False])
