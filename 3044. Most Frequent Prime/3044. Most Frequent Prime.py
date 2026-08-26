#
# Problem: 3044. Most Frequent Prime
# Difficulty: Medium
# Link: https://leetcode.com/problems/most-frequent-prime/
# Language: python3
# Date: 2026-08-26


class Solution:
    def mostFrequentPrime(self, mat: List[List[int]]) -> int:
        def chk(num: int) -> bool:
            for i in range(2, int(math.sqrt(num)) + 1):
                if (num % i) == 0:
                    return False
            return True

        mp = {}

        def dfs(i: int, j: int, x: int, y: int, num: int):
            i += x
            j += y
            if i < 0 or i == len(mat) or j < 0 or j == len(mat[0]):
                return
            num = num * 10 + mat[i][j]
            if chk(num):
                mp[num] = mp.get(num, 0) + 1
            dfs(i, j, x, y, num)

        for i in range(len(mat)):
            for j in range(len(mat[0])):
                dfs(i, j, 1, 0, mat[i][j])
                dfs(i, j, 1, 1, mat[i][j])
                dfs(i, j, 1, -1, mat[i][j])
                dfs(i, j, 0, 1, mat[i][j])
                dfs(i, j, 0, -1, mat[i][j])
                dfs(i, j, -1, 0, mat[i][j])
                dfs(i, j, -1, 1, mat[i][j])
                dfs(i, j, -1, -1, mat[i][j])
        print(chk(91))
        max_val = 0
        res = -1
        for k, v in mp.items():
            if v > max_val or (v == max_val and res < k):
                max_val = v
                res = k
        return res

