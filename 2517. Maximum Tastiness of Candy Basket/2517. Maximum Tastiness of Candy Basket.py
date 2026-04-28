#
# Problem: 2517. Maximum Tastiness of Candy Basket
# Difficulty: Medium
# Link: https://leetcode.com/problems/maximum-tastiness-of-candy-basket/
# Language: python3
# Date: 2026-04-28


class Solution:
    def maximumTastiness(self, price: List[int], k: int) -> int:
        def chk(prices: List[int], k: int, mid: int) -> int:
            prv = -1000000000
            for price in prices:
                if price - prv >= mid:
                    k -= 1
                    if k == 0:
                        return True
                    prv = price
            return False

        price.sort()
        left = 1
        right = (price[-1] - price[0]) // (k - 1) + 1
        while left < right:
            mid = (left + right) >> 1
            if not chk(price, k, mid):
                right = mid
            else:
                left = mid + 1
        return left - 1

