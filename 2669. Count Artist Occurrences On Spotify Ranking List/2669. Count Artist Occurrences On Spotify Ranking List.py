#
# Problem: 2669. Count Artist Occurrences On Spotify Ranking List
# Difficulty: Easy
# Link: https://leetcode.com/problems/count-artist-occurrences-on-spotify-ranking-list/
# Language: python3
# Date: 2026-04-29


import pandas as pd

def count_occurrences(spotify: pd.DataFrame) -> pd.DataFrame:
    spotify=spotify.groupby('artist').size().reset_index(name='occurrences')
    return spotify.sort_values(by=['occurrences', 'artist'], ascending=[False, True])
