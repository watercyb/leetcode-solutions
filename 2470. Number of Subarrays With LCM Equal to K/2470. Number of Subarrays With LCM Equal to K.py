#
# Problem: 2470. Number of Subarrays With LCM Equal to K
# Difficulty: Medium
# Link: https://leetcode.com/problems/number-of-subarrays-with-lcm-equal-to-k/
# Language: python3
# Date: 2026-04-27


class Solution:
    def subarrayLCM(self, nums: List[int], k: int) -> int:
        mp = {}
        res = 0
        for num in nums:
            mp_next = {}
            if num <= k:
                for key, val in mp.items():
                    lcm = math.lcm(key, num)
                    if lcm <= k:
                        mp_next[lcm] = mp_next.get(lcm, 0) + val
                        if lcm == k:
                            res += val
                mp_next[num] = mp_next.get(num, 0) + 1
                if num == k:
                    res += 1
            mp = mp_next
        return res

