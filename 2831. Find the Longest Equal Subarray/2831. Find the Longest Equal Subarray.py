#
# Problem: 2831. Find the Longest Equal Subarray
# Difficulty: Medium
# Link: https://leetcode.com/problems/find-the-longest-equal-subarray/
# Language: python3
# Date: 2026-05-01


class Solution:
    def longestEqualSubarray(self, nums: List[int], k: int) -> int:
        max_value = max(nums)
        counts = [0] * (max_value + 1)
        freqs = [0] * (len(nums) + 1)
        i = 0
        max_count = 0
        res = 0
        for j in range(len(nums)):
            freqs[counts[nums[j]]] -= 1
            counts[nums[j]] += 1
            freqs[counts[nums[j]]] += 1
            if counts[nums[j]] > max_count:
                max_count = counts[nums[j]]
            while j - i + 1 - max_count > k:
                cnt = counts[nums[i]]
                freqs[cnt] -= 1
                if cnt == max_count and freqs[cnt] == 0:
                    max_count -= 1
                counts[nums[i]] -= 1
                freqs[counts[nums[i]]] += 1
                i += 1
            res = max(res, max_count)
        return res

