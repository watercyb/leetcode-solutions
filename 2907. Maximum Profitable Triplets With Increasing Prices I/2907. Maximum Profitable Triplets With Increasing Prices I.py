#
# Problem: 2907. Maximum Profitable Triplets With Increasing Prices I
# Difficulty: Medium
# Link: https://leetcode.com/problems/maximum-profitable-triplets-with-increasing-prices-i/
# Language: python3
# Date: 2026-05-02


class Solution:
    def maxProfit(self, prices: List[int], profits: List[int]) -> int:
        arr = []
        for i in range(len(prices)):
            arr.append([prices[i], profits[i], i])
        arr.sort(key=lambda x: (x[0], -x[2]))
        bit_1 = BIT(len(arr))
        bit_2 = BIT(len(arr))
        res = -1
        for i in range(len(arr)):
            profit = arr[i][1]
            idx = arr[i][2]
            res = max(res, bit_2.get(idx - 1) + profit)
            bit_2.insert(idx, bit_1.get(idx - 1) + profit)
            bit_1.insert(idx, profit)
        return res


class BIT:
    def __init__(self, n: int):
        self.n = n + 2
        self.bit = [-10000000000] * self.n

    def insert(self, i: int, num: int):
        i += 1
        while i < self.n:
            self.bit[i] = max(self.bit[i], num)
            i += i & -i

    def get(self, i: int) -> int:
        i += 1
        res = -10000000000
        while i > 0:
            res = max(res, self.bit[i])
            i -= i & -i
        return res

