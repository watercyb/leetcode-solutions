#
# Problem: 1525. Number of Good Ways to Split a String
# Difficulty: Medium
# Link: https://leetcode.com/problems/number-of-good-ways-to-split-a-string/
# Language: python3
# Date: 2026-04-18


class Solution:
    def numSplits(self, s: str) -> int:
        counts = Counter(s)
        right = len(counts)
        rights = [0] * 26
        for k, v in counts.items():
            rights[ord(k) - ord("a")] = v
        left = 0
        lefts = [0] * 26
        res = 0
        for i in range(0, len(s) - 1):
            idx = ord(s[i]) - ord("a")
            rights[idx] -= 1
            if rights[idx] == 0:
                right -= 1
            lefts[idx] += 1
            if lefts[idx] == 1:
                left += 1
            if left == right:
                res += 1
        return res

