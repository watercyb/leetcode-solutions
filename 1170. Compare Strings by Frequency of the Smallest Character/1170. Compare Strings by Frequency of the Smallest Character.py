#
# Problem: 1170. Compare Strings by Frequency of the Smallest Character
# Difficulty: Medium
# Link: https://leetcode.com/problems/compare-strings-by-frequency-of-the-smallest-character/
# Language: python3
# Date: 2026-04-14


class Solution:
    def numSmallerByFrequency(self, queries: List[str], words: List[str]) -> List[int]:
        counts = [0] * 12
        for word in words:
            counts[Counter(word)[min(word)]] += 1
        for i in range(len(counts) - 1, 0, -1):
            counts[i - 1] += counts[i]
        res = []
        for query in queries:
            res.append(counts[Counter(query)[min(query)] + 1])
        return res

