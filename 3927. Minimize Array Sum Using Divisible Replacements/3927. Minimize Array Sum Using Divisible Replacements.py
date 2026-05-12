#
# Problem: 3927. Minimize Array Sum Using Divisible Replacements
# Difficulty: Medium
# Link: https://leetcode.com/problems/minimize-array-sum-using-divisible-replacements/
# Language: python3
# Date: 2026-05-12


class Solution:
    def minArraySum(self, nums: list[int]) -> int:
        counts = Counter(nums)
        if 1 in counts:
            return len(nums)
        nums.sort()
        res = 0
        for num in nums:
            if num in counts:
                res += num
                for i in range(num + num, nums[-1] + 1, num):
                    if i in counts:
                        res += counts[i] * num
                        del counts[i]
        return res

