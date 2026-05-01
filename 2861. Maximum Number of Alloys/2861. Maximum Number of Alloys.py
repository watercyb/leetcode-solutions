#
# Problem: 2861. Maximum Number of Alloys
# Difficulty: Medium
# Link: https://leetcode.com/problems/maximum-number-of-alloys/
# Language: python3
# Date: 2026-05-01


class Solution:
    def maxNumberOfAlloys(
        self,
        n: int,
        k: int,
        budget: int,
        composition: List[List[int]],
        stock: List[int],
        cost: List[int],
    ) -> int:
        res = 0
        for i in range(k):
            res = max(self.getNum(budget, composition[i], stock, cost), res)
        return res

    def getNum(
        self, budget: int, composition: List[int], stock: List[int], cost: List[int]
    ) -> int:
        sum = 0
        b = budget
        for i in range(len(composition)):
            sum += composition[i] * cost[i]
            b += stock[i] * cost[i]
        left = 0
        right = b // sum + 1
        while left < right:
            mid = (left + right) >> 1
            if not self.chk(budget, composition, stock, cost, mid):
                right = mid
            else:
                left = mid + 1
        return left - 1

    def chk(
        self,
        budget: int,
        composition: List[int],
        stock: List[int],
        cost: List[int],
        mid: int,
    ) -> bool:
        for i in range(len(composition)):
            if mid * composition[i] > stock[i]:
                budget -= (mid * composition[i] - stock[i]) * cost[i]
                if budget < 0:
                    return False
        return True

