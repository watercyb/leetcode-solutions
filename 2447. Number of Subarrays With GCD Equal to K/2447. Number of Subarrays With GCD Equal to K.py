#
# Problem: 2447. Number of Subarrays With GCD Equal to K
# Difficulty: Medium
# Link: https://leetcode.com/problems/number-of-subarrays-with-gcd-equal-to-k/
# Language: python3
# Date: 2026-04-27


class Solution:
    def subarrayGCD(self, nums: List[int], k: int) -> int:
        res = 0
        mp = {}
        for i in range(len(nums)):
            num = nums[i]
            if num % k != 0:
                mp.clear()
                continue
            mp_next = {num: 1}
            for key, val in mp.items():
                key_next = gcd(key, num)
                mp_next[key_next] = mp_next.get(key_next, 0) + val
            res += mp_next.get(k, 0)
            mp = mp_next
        return res

