#
# Problem: 4064. Longest Subarray Divisible by K with At Most One Negation II
# Difficulty: Hard
# Link: https://leetcode.com/problems/longest-subarray-divisible-by-k-with-at-most-one-negation-ii/
# Language: python3
# Date: 2026-09-26


class Solution:
    def longestSubarray(self, nums: list[int], k: int) -> int:
        n = len(nums)
        lefts = {0: -1}
        lefts[0] = -1
        rights = {}
        num_sum = 0
        for i, num in enumerate(nums):
            num_sum = (num_sum + num) % k
            rights[num_sum] = i
        lasts = [-1] * k
        lasts[0] = n
        num_sum = 0
        res = 0
        for i in range(n):
            num_sum = (num_sum + nums[i]) % k
            lasts[2 * nums[i] % k] = i
            if rights[num_sum] == i:
                for j, l in lefts.items():
                    if i - l > res:
                        m = (num_sum - j + k) % k
                        if lasts[m] > l:
                            res = i - l
            if num_sum not in lefts:
                lefts[num_sum] = i
        return res

