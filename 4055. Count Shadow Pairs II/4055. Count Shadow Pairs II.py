#
# Problem: 4055. Count Shadow Pairs II
# Difficulty: Hard
# Link: https://leetcode.com/problems/count-shadow-pairs-ii/
# Language: python3
# Date: 2026-10-23


from bisect import bisect_right


class Solution:
    def shadowPairs(self, nums: list[int]) -> int:
        nums_sort = list(set(nums))
        nums_sort.sort()
        mp = {}
        for num in nums_sort:
            mp[num] = len(mp)
        arr = []
        for i in range(len(nums)):
            arr.append(mp[nums[i]])
        return self.sort(arr)

    def sort(self, arr: list[int]) -> int:
        min_val = min(arr)
        max_val = max(arr)
        if min_val == max_val or len(arr) <= 1:
            return 0
        mid = (min_val + max_val) // 2
        left_vals = []
        right_vals = []
        left_mq = []
        right_mq = []
        res = 0
        for i, val in enumerate(arr):
            if val <= mid:
                while len(left_mq) > 0 and arr[left_mq[-1]] < val:
                    left_mq.pop()
                left_mq.append(i)
                left_vals.append(val)
            else:
                while len(right_mq) > 0 and arr[right_mq[-1]] >= val:
                    right_mq.pop()
                idx = bisect_right(left_mq, right_mq[-1] if len(right_mq) > 0 else -1)
                res += len(left_mq) - idx
                right_mq.append(i)
                right_vals.append(val)
        return res + self.sort(left_vals) + self.sort(right_vals)

