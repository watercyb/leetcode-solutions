#
# Problem: 3931. Check Adjacent Digit Differences
# Difficulty: Easy
# Link: https://leetcode.com/problems/check-adjacent-digit-differences/
# Language: python3
# Date: 2026-05-18


class Solution:
    def isAdjacentDiffAtMostTwo(self, s: str) -> bool:
        prv=ord(s[0])
        for chr in s:
            num=ord(chr)
            if abs(prv-num)>2:
                return False
            prv=num
        return True
