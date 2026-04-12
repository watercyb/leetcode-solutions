#
# Problem: 1073. Adding Two Negabinary Numbers
# Difficulty: Medium
# Link: https://leetcode.com/problems/adding-two-negabinary-numbers/
# Language: python3
# Date: 2026-04-12


class Solution:
    def addNegabinary(self, arr1: List[int], arr2: List[int]) -> List[int]:
        res = []
        i = len(arr1) - 1
        j = len(arr2) - 1
        a = 0
        b = 0
        while i >= 0 or j >= 0 or a != 0 or b != 0:
            sum_num = b
            if i >= 0:
                sum_num += arr1[i]
            if j >= 0:
                sum_num += arr2[j]
            if sum_num == 4:
                a = 1
                b = a
                res.append(0)
            else:
                n = sum_num // 2
                b = n + a
                a = n
                res.append(sum_num % 2)
            i -= 1
            j -= 1
            if a == 1 and b == 2:
                a = 0
                b = 0
        i = 0
        j = len(res) - 1
        while j > i and res[j] == 0:
            j -= 1
        res1 = []
        while j >= i:
            res1.append(res[j])
            j -= 1
        return res1

