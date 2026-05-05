#
# Problem: 3296. Minimum Number of Seconds to Make Mountain Height Zero
# Difficulty: Medium
# Link: https://leetcode.com/problems/minimum-number-of-seconds-to-make-mountain-height-zero/
# Language: python3
# Date: 2026-05-05


class Solution:
    def minNumberOfSeconds(self, mountainHeight: int, workerTimes: List[int]) -> int:
        left = 0
        right = min(workerTimes) * (mountainHeight + 1) * mountainHeight // 2
        while left < right:
            mid = (left + right) // 2
            count = 0
            for workerTime in workerTimes:
                count += (sqrt(1 + 8 * mid // workerTime) - 1) // 2
            if count >= mountainHeight:
                right = mid
            else:
                left = mid + 1
        return left

