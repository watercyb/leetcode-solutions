#
# Problem: 1647. Minimum Deletions to Make Character Frequencies Unique
# Difficulty: Medium
# Link: https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/
# Language: python3
# Date: 2026-04-19


class Solution:
    def minDeletions(self, s: str) -> int:
        count = Counter(s)
        counts = list(count.values())
        max_num = max(counts)
        freqs = [False] * (max_num + 1)
        res = 0
        for c in counts:
            while c > 0 and freqs[c]:
                c -= 1
                res += 1
            freqs[c] = True
        return res

