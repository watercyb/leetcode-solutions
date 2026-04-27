#
# Problem: 2489. Number of Substrings With Fixed Ratio
# Difficulty: Medium
# Link: https://leetcode.com/problems/number-of-substrings-with-fixed-ratio/
# Language: python3
# Date: 2026-04-27


class Solution:
    def fixedRatio(self, s: str, num1: int, num2: int) -> int:
        mp = {0: 1}
        res = 0
        sum_num = 0
        for i in range(len(s)):
            if s[i] == "0":
                sum_num += num2
            else:
                sum_num -= num1
            count = mp.get(sum_num, 0)
            res += count
            mp[sum_num] = count + 1
        return res

