#
# Problem: 1575. Count All Possible Routes
# Difficulty: Hard
# Link: https://leetcode.com/problems/count-all-possible-routes/
# Language: python3
# Date: 2026-04-18


class Solution:
    def countRoutes(
        self, locations: List[int], start: int, finish: int, fuel: int
    ) -> int:
        start = locations[start]
        finish = locations[finish]
        if abs(finish - start) > fuel:
            return 0
        arr = []
        for num in locations:
            if abs(finish - num) <= fuel:
                arr.append(num)
        arr.sort()
        idx_start = -1
        idx_finish = -1
        n = len(arr)
        for i in range(n):
            if arr[i] == start:
                idx_start = i
            if arr[i] == finish:
                idx_finish = i
        DP = [[0] * n for _ in range(fuel + 1)]
        DP[fuel][idx_start] = 1
        res = 0
        for i in range(fuel, -1, -1):
            for j in range(n):
                if DP[i][j] == 0:
                    continue
                idx = j - 1
                while idx >= 0 and arr[j] - arr[idx] <= i:
                    DP[i - arr[j] + arr[idx]][idx] += DP[i][j]
                    idx -= 1
                idx = j + 1
                while idx < n and arr[idx] - arr[j] <= i:
                    DP[i - arr[idx] + arr[j]][idx] += DP[i][j]
                    idx += 1
            res += DP[i][idx_finish]
        return res % 1_000_000_007

