#
# Problem: 2186. Minimum Number of Steps to Make Two Strings Anagram II
# Difficulty: Medium
# Link: https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram-ii/
# Language: python3
# Date: 2026-04-24


class Solution:
    def minSteps(self, s: str, t: str) -> int:
        count_s = Counter(s)
        count_t = Counter(t)
        return sum(
            [
                abs(count_s[i] - count_t[i])
                for i in [chr(i) for i in range(ord("a"), ord("z") + 1)]
            ]
        )

