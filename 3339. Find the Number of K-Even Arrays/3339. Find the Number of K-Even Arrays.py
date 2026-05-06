#
# Problem: 3339. Find the Number of K-Even Arrays
# Difficulty: Medium
# Link: https://leetcode.com/problems/find-the-number-of-k-even-arrays/
# Language: python3
# Date: 2026-05-06


class Solution:
    def countOfArrays(self, n: int, m: int, k: int) -> int:
        mod = 1_000_000_007
        even_count = m // 2
        odd_count = m - m // 2
        dp_even = [0] * (k + 1)
        dp_odd = [0] * (k + 1)
        dp_even[0] = even_count
        dp_odd[0] = odd_count
        for _ in range(n - 1):
            for i in range(k - 1, -1, -1):
                sum_num = dp_even[i + 1] + dp_odd[i + 1]
                dp_even[i + 1] = (dp_odd[i + 1] + dp_even[i]) * even_count % mod
                dp_odd[i + 1] = sum_num * odd_count % mod
            sum_num = dp_even[0] + dp_odd[0]
            dp_even[0] = dp_odd[0] * even_count % mod
            dp_odd[0] = sum_num * odd_count % mod
        return (dp_even[-1] + dp_odd[-1]) % mod

