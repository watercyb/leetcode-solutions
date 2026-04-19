#
# Problem: 1616. Split Two Strings to Make Palindrome
# Difficulty: Medium
# Link: https://leetcode.com/problems/split-two-strings-to-make-palindrome/
# Language: python3
# Date: 2026-04-19


class Solution:
    def checkPalindromeFormation(self, a: str, b: str) -> bool:
        def chk(s: str, i: int, j: int) -> bool:
            while i < j:
                if s[i] != s[j]:
                    return False
                i += 1
                j -= 1
            return True

        i = 0
        j = len(a) - 1
        while i < j:
            if a[i] != b[j]:
                if chk(a, i, j) or chk(b, i, j):
                    return True
                break
            i += 1
            j -= 1
        if i >= j:
            return True
        i = 0
        j = len(a) - 1
        while i < j:
            if b[i] != a[j]:
                if chk(a, i, j) or chk(b, i, j):
                    return True
                break
            i += 1
            j -= 1
        return i >= j

