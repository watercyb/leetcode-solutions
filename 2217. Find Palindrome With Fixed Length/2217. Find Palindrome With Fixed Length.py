#
# Problem: 2217. Find Palindrome With Fixed Length
# Difficulty: Medium
# Link: https://leetcode.com/problems/find-palindrome-with-fixed-length/
# Language: python3
# Date: 2026-04-25


class Solution:
    def kthPalindrome(self, queries: List[int], intLength: int) -> List[int]:
        length = (intLength + 1) // 2
        offset = 0
        if length > 1:
            offset = pow(10, length - 1) - 1
        lim = pow(10, length)
        res = []
        for query in queries:
            query += offset
            if query >= lim:
                res.append(-1)
            else:
                num = query
                if (intLength & 1) == 1:
                    query //= 10
                while query > 0:
                    num = num * 10 + query % 10
                    query //= 10
                res.append(num)
        return res

