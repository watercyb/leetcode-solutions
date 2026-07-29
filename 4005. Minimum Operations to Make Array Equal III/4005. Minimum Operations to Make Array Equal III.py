#
# Problem: 4005. Minimum Operations to Make Array Equal III
# Difficulty: Medium
# Link: https://leetcode.com/problems/minimum-operations-to-make-array-equal-iii/
# Language: python3
# Date: 2026-07-29


class Solution:
    def minOperations(self, nums: List[int]) -> int:
        count = Counter(nums)
        counts = {}
        if count[1] == len(nums):
            return 0
        res = len(nums)
        count1 = count[1]
        count[1] = 0
        for k, v in count.items():
            count_sum = counts.get(k, 0) + count1
            for i in range(2, floor(sqrt(k)) + 1):
                if k % i == 0:
                    if count[i] > 0:
                        count_sum += count[i]
                        counts[i] = counts.get(i, 0) + v
                    n = k / i
                    if count[n] > 0 and n != i:
                        count_sum += count[n]
                        counts[n] = counts.get(n, 0) + v
            counts[k] = count_sum
        for k, v in count.items():
            cnt = counts.get(k, 0)
            res = min(res, (len(nums) - count[k]) * 2 - cnt)
        return res

