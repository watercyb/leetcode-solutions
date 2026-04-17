#
# Problem: 1416. Restore The Array
# Difficulty: Hard
# Link: https://leetcode.com/problems/restore-the-array/
# Language: python3
# Date: 2026-04-17


class Solution:
    def numberOfArrays(self, s: str, k: int) -> int:
        mod = 1_000_000_007
        DP = [0] * (len(s) + 1)
        DP[0] = 1
        count = 0
        for i in range(len(s)):
            sum = 0
            num = 0
            base = 1
            for j in range(i, -1, -1):
                num = num + (ord(s[j]) - ord("0")) * base
                if num > k or base > mod:
                    break
                if s[j] != "0":
                    sum += DP[j]
                base *= 10
            DP[i + 1] = sum % mod
            if sum == 0:
                count += 1
                if count == 10:
                    break
            else:
                count = 0
        return DP[len(DP) - 1] % mod

