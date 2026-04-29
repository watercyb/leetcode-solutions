#
# Problem: 2653. Sliding Subarray Beauty
# Difficulty: Medium
# Link: https://leetcode.com/problems/sliding-subarray-beauty/
# Language: python3
# Date: 2026-04-29


class Solution:
    def getSubarrayBeauty(self, nums: List[int], k: int, x: int) -> List[int]:
        counts = [0] * 51
        idx = 50
        count = 0
        res = []
        for i in range(k):
            num = nums[i] + 50
            if num >= 50:
                continue
            counts[num] += 1
            if num <= idx:
                count += 1
            while count - counts[idx] >= x:
                count -= counts[idx]
                idx -= 1
        res.append(idx - 50)
        for i in range(k, len(nums)):
            num = nums[i - k] + 50
            if num < 50:
                counts[num] -= 1
                if num <= idx:
                    count -= 1
                while idx < 50 and count < x:
                    idx += 1
                    count += counts[idx]
            num = nums[i] + 50
            if num < 50:
                counts[num] += 1
                if num <= idx:
                    count += 1
                while count - counts[idx] >= x:
                    count -= counts[idx]
                    idx -= 1
            res.append(idx - 50)
        return res

