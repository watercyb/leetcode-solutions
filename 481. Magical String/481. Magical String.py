#
# Problem: 481. Magical String
# Difficulty: Medium
# Link: https://leetcode.com/problems/magical-string/
# Language: python3
# Date: 2026-04-03


class Solution:
    def magicalString(self, n: int) -> int:
        arr = [1,2]
        i = 1
        j = 1
        k = 2
        res = 1
        while i < n:
            res += 2 - arr[i]
            while k - j < arr[i]:
                arr.append(arr[j])
                k += 1
            arr.append(3 - arr[j])
            j = k
            k += 1
            i += 1
        return res

