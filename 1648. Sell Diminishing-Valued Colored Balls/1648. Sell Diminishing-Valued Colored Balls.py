#
# Problem: 1648. Sell Diminishing-Valued Colored Balls
# Difficulty: Medium
# Link: https://leetcode.com/problems/sell-diminishing-valued-colored-balls/
# Language: python3
# Date: 2026-04-19


class Solution:
    def maxProfit(self, inventory: List[int], orders: int) -> int:
        inventory.sort()
        total = sum(inventory)
        sums = [0]
        prv = 0
        for inv in inventory:
            sums.append(inv + prv)
            prv += inv
        left = 0
        right = inventory[-1]
        while left < right:
            mid = (left + right) // 2
            idx = bisect.bisect_left(inventory, mid)
            if total - sums[idx] - (len(inventory) - idx) * mid <= orders:
                right = mid
            else:
                left = mid + 1
        res = 0
        for inv in inventory:
            if inv > left:
                res += (left + 1 + inv) * (inv - left) // 2
                orders -= inv - left
        if orders > 0:
            res += orders * left
        return res % 1_000_000_007

