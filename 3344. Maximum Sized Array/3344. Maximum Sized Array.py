#
# Problem: 3344. Maximum Sized Array
# Difficulty: Medium
# Link: https://leetcode.com/problems/maximum-sized-array/
# Language: python3
# Date: 2026-05-06


class Solution:
    def maxSizedArray(self, s: int) -> int:
        left = 0
        right = 1200
        while left < right:
            mid = (left + right) // 2
            counts = [0] * 12
            for i in range(mid):
                idx = 0
                while i > 0:
                    counts[idx] += i & 1
                    i >>= 1
                    idx += 1
            sm = 0
            for i in range(mid):
                idx = 0
                while idx < 12:
                    if (i & 1) == 0:
                        sm += counts[idx] << idx
                    else:
                        sm += mid << idx
                    i >>= 1
                    idx += 1
            if (mid - 1) * mid // 2 * sm > s:
                right = mid
            else:
                left = mid + 1
        return left - 1

