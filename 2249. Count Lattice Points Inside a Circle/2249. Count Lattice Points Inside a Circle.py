#
# Problem: 2249. Count Lattice Points Inside a Circle
# Difficulty: Medium
# Link: https://leetcode.com/problems/count-lattice-points-inside-a-circle/
# Language: python3
# Date: 2026-04-25


class Solution:
    def countLatticePoints(self, circles: List[List[int]]) -> int:
        res = 0
        seens = [[False] * 301 for _ in range(301)]
        for x, y, r in circles:
            top = x + r
            bottom = x - r
            for i in range(bottom, top + 1):
                a = int(sqrt(r * r - (x - i) * (x - i)))
                for j in range(y - a, y + a + 1):
                    if not seens[i + 100][j + 100]:
                        seens[i + 100][j + 100] = True
                        res += 1
        return res

