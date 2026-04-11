#
# Problem: 1003. Check If Word Is Valid After Substitutions
# Difficulty: Medium
# Link: https://leetcode.com/problems/check-if-word-is-valid-after-substitutions/
# Language: python3
# Date: 2026-04-11


class Solution:
    def isValid(self, s: str) -> bool:
        while len(s) > 0:
            if "abc" in s:
                s = s.replace("abc", "")
            else:
                return False
        return True

