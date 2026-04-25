#
# Problem: 2232. Minimize Result by Adding Parentheses to Expression
# Difficulty: Medium
# Link: https://leetcode.com/problems/minimize-result-by-adding-parentheses-to-expression/
# Language: python3
# Date: 2026-04-25


class Solution:
    def minimizeResult(self, expression: str) -> str:
        res = ""
        min_sum = 100000000

        def chk(left: int, right: int) -> int:
            a = 1
            if left > 0:
                a = 0
                for i in range(left):
                    a = a * 10 + ord(expression[i]) - ord("0")
            d = 1
            if right < len(expression) - 1:
                d = 0
                for i in range(right + 1, len(expression)):
                    d = d * 10 + ord(expression[i]) - ord("0")
            b = 0
            while expression[left] != "+":
                b = b * 10 + ord(expression[left]) - ord("0")
                left += 1
            c = 0
            left += 1
            while left <= right:
                c = c * 10 + ord(expression[left]) - ord("0")
                left += 1
            return a * (b + c) * d

        i = 0
        while expression[i] != "+":
            j = len(expression) - 1
            while expression[j] != "+":
                num_sum = chk(i, j)
                if num_sum < min_sum:
                    min_sum = num_sum
                    res = (
                        expression[:i]
                        + "("
                        + expression[i : j + 1]
                        + ")"
                        + expression[j + 1 :]
                    )
                j -= 1
            i += 1
        return res

