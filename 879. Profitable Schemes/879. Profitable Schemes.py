#
# Problem: 879. Profitable Schemes
# Difficulty: Hard
# Link: https://leetcode.com/problems/profitable-schemes/
# Language: python3
# Date: 2026-04-09


class Solution:
    def profitableSchemes(
        self, n: int, minProfit: int, group: List[int], profit: List[int]
    ) -> int:
        mod = 10**9 + 7
        DP = [[0] * (minProfit + 1) for _ in range(n + 1)]
        DP[0][0] = 1
        for g, p in zip(group, profit):
            for j in range(n - g, -1, -1):
                for k in range(minProfit, -1, -1):
                    pNext = min(k + p, minProfit)
                    DP[j + g][pNext] += DP[j][k]
        res = 0
        for i in range(n + 1):
            res += DP[i][minProfit]
        return res % mod

