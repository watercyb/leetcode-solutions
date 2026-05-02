#
# Problem: 788. Rotated Digits
# Difficulty: Medium
# Link: https://leetcode.com/problems/rotated-digits/?envType=daily-question&envId=2026-05-02
# Language: python3
# Date: 2026-05-02


class Solution:
    def rotatedDigits(self, n: int) -> int:
        arr = [1, 1, 2, 4, 4, 2, 2, 4, 1, 2]
        res = 0
        for i in range(1, n + 1):
            h = 0
            while i > 0:
                h |= arr[i % 10]
                i //= 10
            if h == 2 or h == 3:
                res += 1
        return res

