#
# Problem: 2002. Maximum Product of the Length of Two Palindromic Subsequences
# Difficulty: Medium
# Link: https://leetcode.com/problems/maximum-product-of-the-length-of-two-palindromic-subsequences/
# Language: python3
# Date: 2026-04-22


class Solution:
    def maxProduct(self, s: str) -> int:
        @cache
        def dfs(h: int) -> int:
            if h == 0:
                return 0
            if h.bit_count() == 1:
                return 1
            low = (h & -h).bit_length() - 1
            high = h.bit_length() - 1
            if s[low] == s[high]:
                return dfs(h - (1 << low) - (1 << high)) + 2
            else:
                return max(dfs(h - (1 << low)), dfs(h - (1 << high)))

        res = 1
        mask = (1 << len(s)) - 1
        for i in range(mask):
            j = i ^ mask
            if j < i and i.bit_length() * j.bit_length() > res:
                res = max(res, dfs(i) * dfs(j))

        return res

