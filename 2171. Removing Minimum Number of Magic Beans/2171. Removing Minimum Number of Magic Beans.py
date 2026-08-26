#
# Problem: 2171. Removing Minimum Number of Magic Beans
# Difficulty: Medium
# Link: https://leetcode.com/problems/removing-minimum-number-of-magic-beans/
# Language: python3
# Date: 2026-08-26


class Solution:
    def minimumRemoval(self, beans: List[int]) -> int:
        beans.sort()
        num_sum = sum(beans)
        idx = 0
        prv = 0
        res = num_sum
        length = len(beans)
        while idx < length:
            if beans[idx] == prv:
                num_sum += prv
            else:
                num_sum += prv - (length - idx) * (beans[idx] - prv)
                res = min(res, num_sum)
                prv = beans[idx]
            idx += 1
        return res

