#
# Problem: 2770. Maximum Number of Jumps to Reach the Last Index
# Difficulty: Medium
# Link: https://leetcode.com/problems/maximum-number-of-jumps-to-reach-the-last-index/?envType=problem-list-v2&envId=array
# Language: python3
# Date: 2026-03-31


class Solution:
    def maximumJumps(self, nums: List[int], target: int) -> int:
        mp = {nums[0]: 0}
        res = -1
        for i in range(1, len(nums)):
            mp_next = mp.copy()
            for k, v in mp.items():
                if abs(k - nums[i]) <= target:
                    mp_next[nums[i]] = max(mp_next.get(nums[i], 0), v + 1)
                    if i == len(nums) - 1:
                        res = max(res, v + 1)
            mp = mp_next
        return res

