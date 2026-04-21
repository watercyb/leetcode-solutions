#
# Problem: 1888. Minimum Number of Flips to Make the Binary String Alternating
# Difficulty: Medium
# Link: https://leetcode.com/problems/minimum-number-of-flips-to-make-the-binary-string-alternating/
# Language: python3
# Date: 2026-04-21


class Solution:
    def minFlips(self, s: str) -> int:
        if len(s) % 2 == 0:
            zero = 0
            one = 0
            for char in s:
                if char == "0":
                    one += 1
                else:
                    zero += 1
                temp = zero
                zero = one
                one = temp
            return min(zero, one)
        else:
            lefts = []
            zero = 0
            one = 0
            for char in s:
                if char == "0":
                    one += 1
                else:
                    zero += 1
                lefts.append([zero, one])
                temp = zero
                zero = one
                one = temp
            res = len(s)
            zero = 0
            one = 0
            for i in range(len(s) - 1, -1, -1):
                res = min(res, lefts[i][0] + one, lefts[i][1] + zero)
                if s[i] == "0":
                    one += 1
                else:
                    zero += 1
                temp = zero
                zero = one
                one = temp
            return res

