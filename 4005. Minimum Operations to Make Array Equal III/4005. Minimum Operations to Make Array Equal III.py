#
# Problem: 4005. Minimum Operations to Make Array Equal III
# Difficulty: Hard
# Link: https://leetcode.com/problems/minimum-operations-to-make-array-equal-iii/
# Language: python3
# Date: 2026-08-19


class Solution:
    def minOperations(self, nums: List[int]) -> int:
        count = Counter(nums)
        counts = Counter()
        if len(count) == 1:
            return 0
        if count[1] == len(nums) - 1:
            return count[1]
        res = len(nums)
        max_num = max(nums)
        for k, v in count.items():
            if k == 1:
                continue
            for i in range(k + k, max_num + 1, k):
                counts[i] += v
                counts[k] += count[i]
        for k, v in count.items():
            if k == 1:
                continue
            res = min(res, (len(nums) - count[k]) * 2 - counts[k] - count[1])
        return res

