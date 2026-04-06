#
# Problem: 665. Non-decreasing Array
# Difficulty: Medium
# Link: https://leetcode.com/problems/non-decreasing-array/
# Language: python3
# Date: 2026-04-06


class Solution:
    def checkPossibility(self, nums: List[int]) -> bool:
        nums.append(1000000)
        prv_1=-1000000
        prv_2=-1000000
        is_removed=False
        for i in range(len(nums)):
            num=nums[i]
            if num>=prv_1:
                prv_2=prv_1
                prv_1=num
            elif not is_removed and prv_1<=nums[i+1]:
                is_removed=True
            elif not is_removed and prv_2<=num:
                is_removed=True
                prv_1=num
            else:
                return False
        return True
