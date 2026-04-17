#
# Problem: 1473. Paint House III
# Difficulty: Hard
# Link: https://leetcode.com/problems/paint-house-iii/
# Language: python3
# Date: 2026-04-17


class Solution:
    def minCost(
        self, houses: List[int], cost: List[List[int]], m: int, n: int, target: int
    ) -> int:
        if n == 1:
            res = 0
            for i in range(m):
                if houses[i] == 0:
                    res += cost[i][0]
            return res
        maxNum = 1_000_000_000
        DP = [[maxNum] * n for _ in range(target + 1)]
        if houses[0] == 0:
            for i in range(n):
                DP[0][i] = cost[0][i]
        else:
            DP[0][houses[0] - 1] = 0
        for i in range(1, m):
            DPNext = [[maxNum] * n for _ in range(target + 1)]
            maxJ = min(target, i + 2)
            if houses[i] == 0:
                for j in range(maxJ):
                    min1 = maxNum
                    idx = -1
                    min2 = maxNum
                    for k in range(n):
                        if DP[j][k] < min1:
                            min2 = min1
                            min1 = DP[j][k]
                            idx = k
                        elif DP[j][k] < min2:
                            min2 = DP[j][k]
                    for k in range(n):
                        if k == idx:
                            DPNext[j + 1][k] = min(min2 + cost[i][k], DPNext[j + 1][k])
                        else:
                            DPNext[j + 1][k] = min(min1 + cost[i][k], DPNext[j + 1][k])
                        DPNext[j][k] = min(DP[j][k] + cost[i][k], DPNext[j][k])
            else:
                for j in range(target):
                    for k in range(n):
                        if k == houses[i] - 1:
                            DPNext[j][k] = min(DP[j][k], DPNext[j][k])
                        else:
                            DPNext[j + 1][houses[i] - 1] = min(
                                DP[j][k], DPNext[j + 1][houses[i] - 1]
                            )
            DP = DPNext
        res = maxNum
        for i in range(n):
            res = min(DP[target - 1][i], res)
        if res == maxNum:
            return -1
        return res

