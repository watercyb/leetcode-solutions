#
# Problem: 856. Score of Parentheses
# Difficulty: Medium
# Link: https://leetcode.com/problems/score-of-parentheses/
# Language: python3
# Date: 2026-04-09


class Solution:
    def scoreOfParentheses(self, s: str) -> int:
        self.idx = 0

        def dfs() -> int:
            count = 0
            sum = 0
            while self.idx < len(s):
                if s[self.idx] == "(":
                    count += 1
                    self.idx += 1
                    sum += dfs()
                else:
                    self.idx += 1
                    if count == 0:
                        return 1
                    else:
                        return 2 * sum
            return sum

        return dfs()

