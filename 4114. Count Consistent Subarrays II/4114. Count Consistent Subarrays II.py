#
# Problem: 4114. Count Consistent Subarrays II
# Difficulty: Hard
# Link: https://leetcode.com/problems/count-consistent-subarrays-ii/
# Language: python3
# Date: 2026-11-16


class Solution:
    def countConsistent(self, nums: list[int]) -> int:
        dp_1 = {}
        dp_2 = {}
        res = 0
        for num in nums:
            dp_1_next = {}
            dp_2_next = {}
            for k, v in dp_1.items():
                n = k & num
                if k <= num:
                    if n == k:
                        res += v
                        dp_1_next[k] = dp_1_next.get(k, 0) + v
                    else:
                        dp_2_next[n] = dp_2_next.get(n, 0) + v
                else:
                    if n == num:
                        res += v
                        dp_1_next[num] = dp_1_next.get(num, 0) + v
                    else:
                        dp_2_next[n] = dp_2_next.get(n, 0) + v
            for k, v in dp_2.items():
                n = k & num
                if k >= num:
                    if k & num == num:
                        res += v
                        dp_1_next[num] = dp_1_next.get(num, 0) + v
                    else:
                        dp_2_next[n] = dp_2_next.get(n, 0) + v
                else:
                    dp_2_next[n] = dp_2_next.get(n, 0) + v
            dp_1_next[num] = dp_1_next.get(num, 0) + 1
            res += 1
            dp_1 = dp_1_next
            dp_2 = dp_2_next
        return res

