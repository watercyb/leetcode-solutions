#
# Problem: 2280. Minimum Lines to Represent a Line Chart
# Difficulty: Medium
# Link: https://leetcode.com/problems/minimum-lines-to-represent-a-line-chart/
# Language: python3
# Date: 2026-04-25


class Solution:
    def minimumLines(self, stockPrices: List[List[int]]) -> int:
        stockPrices.sort()
        i = 0
        res = 0

        def getSlope(x1: int, y1: int, x2: int, y2: int) -> List[int]:
            return [y1 - y2, x1 - x2]

        while i < len(stockPrices) - 1:
            res += 1
            x = stockPrices[i][0]
            y = stockPrices[i][1]
            a = y - stockPrices[i + 1][1]
            b = x - stockPrices[i + 1][0]
            j = i + 2
            while j < len(stockPrices):
                if a * (x - stockPrices[j][0]) != (y - stockPrices[j][1]) * b:
                    break
                j += 1
            i = j - 1
        return res

