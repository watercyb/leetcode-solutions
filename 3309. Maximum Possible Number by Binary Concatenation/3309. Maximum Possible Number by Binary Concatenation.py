#
# Problem: 3309. Maximum Possible Number by Binary Concatenation
# Difficulty: Medium
# Link: https://leetcode.com/problems/maximum-possible-number-by-binary-concatenation/
# Language: python3
# Date: 2026-05-06


class Solution:
    def maxGoodNumber(self, nums: List[int]) -> int:
        res = 0
        for i in range(3):
            for j in range(3):
                if j == i:
                    continue
                for k in range(3):
                    if k == i or k == j:
                        continue
                    res = max(
                        res,
                        (
                            ((nums[i] << nums[j].bit_length()) + nums[j])
                            << nums[k].bit_length()
                        )
                        + nums[k],
                    )
        return res
    
