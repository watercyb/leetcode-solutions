#
# Problem: 2844. Minimum Operations to Make a Special Number
# Difficulty: Medium
# Link: https://leetcode.com/problems/minimum-operations-to-make-a-special-number/
# Language: python3
# Date: 2026-05-01


class Solution:
    def minimumOperations(self, num: str) -> int:
        a = 0
        b = 0
        c = 0
        d = 0
        res = 0
        for i in range(len(num) - 1, -1, -1):
            digit = num[i]
            if digit == "0":
                if a == 1:
                    return len(num) - i - 2
                else:
                    a = 1
                c = 1
                res -= 1
            elif digit == "5":
                b = 1
                if c == 1:
                    return len(num) - i - 2
                d = 1
            elif digit == "2":
                if b == 1:
                    return len(num) - i - 2
            elif digit == "7":
                if d == 1:
                    return len(num) - i - 2
            res += 1
        return res

