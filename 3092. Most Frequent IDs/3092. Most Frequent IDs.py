#
# Problem: 3092. Most Frequent IDs
# Difficulty: Medium
# Link: https://leetcode.com/problems/most-frequent-ids/
# Language: python3
# Date: 2026-05-03


class Solution:
    def mostFrequentIDs(self, nums: List[int], freq: List[int]) -> List[int]:
        mp = {}
        arr = []
        heapq.heapify(arr)
        res = []
        for i in range(len(nums)):
            num = nums[i]
            fr = freq[i]
            mp[num] = mp.get(num, 0) + fr
            if mp[num] != 0:
                heapq.heappush(arr, (-mp[num], num))
            while len(arr) > 0 and mp[arr[0][1]] != -arr[0][0]:
                heapq.heappop(arr)
            if len(arr) == 0:
                res.append(0)
            else:
                res.append(-arr[0][0])
        return res

