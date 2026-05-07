#
# Problem: 3475. DNA Pattern Recognition
# Difficulty: Medium
# Link: https://leetcode.com/problems/dna-pattern-recognition/
# Language: python3
# Date: 2026-05-07


import pandas as pd

def analyze_dna_patterns(samples: pd.DataFrame) -> pd.DataFrame:
    samples['has_start']=samples['dna_sequence'].apply(lambda x: 1 if x.startswith("ATG") else 0)
    samples['has_stop']=samples['dna_sequence'].apply(lambda x: 1 if x.endswith(("TAA","TAG","TGA")) else 0)
    samples['has_atat']=samples['dna_sequence'].apply(lambda x: 1 if "ATAT" in x else 0)
    samples['has_ggg']=samples['dna_sequence'].apply(lambda x: 1 if "GGG" in x else 0)
    return samples
