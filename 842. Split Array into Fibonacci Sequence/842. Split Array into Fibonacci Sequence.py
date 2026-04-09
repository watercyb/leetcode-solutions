#
# Problem: 842. Split Array into Fibonacci Sequence
# Difficulty: Medium
# Link: https://leetcode.com/problems/split-array-into-fibonacci-sequence/
# Language: python3
# Date: 2026-04-09


class Solution:
    def splitIntoFibonacci(self, num: str) -> List[int]:
        if num[0] == "0" and num[1] == "0":
            for i in range(2, len(num)):
                if num[i] != "0":
                    return []
            return [0] * len(num)
        nums = []
        for i in range(len(num)):
            nums.append(ord(num[i]) - ord("0"))
        lim = 1 << 31
        a = 0
        for i in range(len(nums)):
            a = a * 10 + nums[i]
            if a > lim:
                break
            b = 0
            for j in range(i + 1, len(nums) - 1):
                b = b * 10 + nums[j]
                if b > lim:
                    break
                k = j + 1
                p1 = a
                p2 = b
                res = [a, b]
                while k < len(nums):
                    if p1 + p2 >= lim:
                        break
                    c = nums[k]
                    k += 1
                    if c == 0:
                        break
                    while k < len(nums) and c < p1 + p2:
                        c = c * 10 + nums[k]
                        k += 1
                    if c != p1 + p2:
                        break
                    res.append(c)
                    p1 = p2
                    p2 = c
                    if k == len(nums):
                        return res
                if b == 0:
                    break
            if a == 0:
                break
        return []

