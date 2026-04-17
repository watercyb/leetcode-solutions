#
# Problem: 1447. Simplified Fractions
# Difficulty: Medium
# Link: https://leetcode.com/problems/simplified-fractions/
# Language: python3
# Date: 2026-04-17


class Solution:
    def simplifiedFractions(self, n: int) -> List[str]:
        res = []

        def GCD(a: int, b: int) -> int:
            if b == 0:
                return a
            return GCD(b, a % b)

        for i in range(2, n + 1):
            for j in range(1, i):
                gcd = GCD(i, j)
                if gcd == 1:
                    res.append(str(j) + "/" + str(i))
        return res

