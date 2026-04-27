#
# Problem: 2450. Number of Distinct Binary Strings After Applying Operations
# Difficulty: Medium
# Link: https://leetcode.com/problems/number-of-distinct-binary-strings-after-applying-operations/
# Language: python3
# Date: 2026-04-27


class Solution:
    def countDistinctStrings(self, s: str, k: int) -> int:
        mod = 1_000_000_007
        res = 1
        base = 2
        n = len(s) - k + 1
        while n > 0:
            if (n & 1) == 1:
                res = res * base % mod
            base = base * base % mod
            n >>= 1
        return res

