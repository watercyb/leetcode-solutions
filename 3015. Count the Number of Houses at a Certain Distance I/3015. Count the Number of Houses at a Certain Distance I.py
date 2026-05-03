#
# Problem: 3015. Count the Number of Houses at a Certain Distance I
# Difficulty: Medium
# Link: https://leetcode.com/problems/count-the-number-of-houses-at-a-certain-distance-i/
# Language: python3
# Date: 2026-05-03


class Solution:
    def countOfPairs(self, n: int, x: int, y: int) -> List[int]:
        if x > y:
            return self.countOfPairs(n, y, x)
        res = [0] * n
        if y - x <= 1:
            for i in range(n):
                res[i] = (n - 1 - i) * 2
            return res
        x -= 1
        y -= 1
        for i in range(0, n):
            for j in range(i + 1, n):
                res[min(j - i - 1, abs(y - j) + abs(i - x))] += 2
        return res

