#
# Problem: 1898. Maximum Number of Removable Characters
# Difficulty: Medium
# Link: https://leetcode.com/problems/maximum-number-of-removable-characters/
# Language: python3
# Date: 2026-04-21


class Solution:
    def maximumRemovals(self, s: str, p: str, removable: List[int]) -> int:
        mp = {}
        for i in range(len(removable)):
            mp[removable[i]] = i

        def chk(mid: int) -> bool:
            j = 0
            for i in range(len(s)):
                if mp.get(i, len(removable)) > mid and s[i] == p[j]:
                    j += 1
                    if j == len(p):
                        return True
            return False

        left = 0
        right = len(removable)
        while left < right:
            mid = (left + right) // 2
            if not chk(mid):
                right = mid
            else:
                left = mid + 1
        return left

