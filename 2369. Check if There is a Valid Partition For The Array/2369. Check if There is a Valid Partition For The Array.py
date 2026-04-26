#
# Problem: 2369. Check if There is a Valid Partition For The Array
# Difficulty: Medium
# Link: https://leetcode.com/problems/check-if-there-is-a-valid-partition-for-the-array/
# Language: python3
# Date: 2026-04-26


class Solution:
    def validPartition(self, nums: List[int]) -> bool:
        dp1 = True
        dp2 = False
        dp3 = nums[0] == nums[1]
        for i in range(2, len(nums)):
            dp_next = False
            if nums[i] == nums[i - 1] and dp2:
                dp_next = True
            elif (
                (nums[i] == nums[i - 1] and nums[i] == nums[i - 2])
                or (nums[i] == nums[i - 1] + 1 and nums[i - 1] == nums[i - 2] + 1)
            ) and dp1:
                dp_next = True
            dp1 = dp2
            dp2 = dp3
            dp3 = dp_next
        return dp3

