#
# Problem: 2333. Minimum Sum of Squared Difference
# Difficulty: Medium
# Link: https://leetcode.com/problems/minimum-sum-of-squared-difference/
# Language: python3
# Date: 2026-04-26


class Solution:
    def minSumSquareDiff(
        self, nums1: List[int], nums2: List[int], k1: int, k2: int
    ) -> int:
        diffs = [0]
        for i in range(len(nums1)):
            diffs.append(abs(nums1[i] - nums2[i]))
        diffs.sort()
        k = k1 + k2
        sum_num = 0
        idx = len(diffs) - 1
        while idx >= 0 and sum_num - diffs[idx] * (len(diffs) - idx - 1) <= k:
            sum_num += diffs[idx]
            idx -= 1
        if idx == -1:
            return 0
        rem = k - (sum_num - diffs[idx + 1] * (len(diffs) - idx - 1))
        a = rem // (len(diffs) - idx - 1)
        b = rem % (len(diffs) - idx - 1)
        res = (diffs[idx + 1] - a) * (diffs[idx + 1] - a) * (
            len(diffs) - idx - 1 - b
        ) + (diffs[idx + 1] - a - 1) * (diffs[idx + 1] - a - 1) * b
        while idx > 0:
            res += diffs[idx] * diffs[idx]
            idx -= 1
        return res

