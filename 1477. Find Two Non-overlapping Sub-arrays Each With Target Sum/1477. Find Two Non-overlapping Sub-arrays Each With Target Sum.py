#
# Problem: 1477. Find Two Non-overlapping Sub-arrays Each With Target Sum
# Difficulty: Medium
# Link: https://leetcode.com/problems/find-two-non-overlapping-sub-arrays-each-with-target-sum/
# Language: python3
# Date: 2026-04-17


class Solution:
    def minSumOfLengths(self, arr: List[int], target: int) -> int:
        lefts = []
        j = 0
        sum_num = 0
        min_len = 100000000
        for i in range(len(arr)):
            sum_num += arr[i]
            while j < i and sum_num > target:
                sum_num -= arr[j]
                j += 1
            if sum_num == target:
                min_len = min(min_len, i - j + 1)
            lefts.append(min_len)
        j = len(arr) - 1
        res = 100000000
        min_len = 100000000
        sum_num = 0
        for i in range(len(arr) - 1, 0, -1):
            sum_num += arr[i]
            while j > i and sum_num > target:
                sum_num -= arr[j]
                j -= 1
            if sum_num == target and res > j - i + 1 + lefts[i - 1]:
                res = min(res, j - i + 1 + lefts[i - 1])
        if res == 100000000:
            return -1
        return res

