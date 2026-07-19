#
# Problem: 3998. Transform Binary String Using Subsequence Sort
# Difficulty: Medium
# Link: https://leetcode.com/problems/transform-binary-string-using-subsequence-sort/
# Language: python3
# Date: 2026-07-19


class Solution:
    def transformStr(self, s: str, strs: List[str]) -> List[bool]:
        res = []
        zero = s.count("0")
        for st in strs:
            zero_count = zero - st.count("0")
            if zero_count < 0:
                res.append(False)
                continue
            sum_val = 0
            isGood = True
            for i in range(len(s)):
                a = s[i]
                b = st[i]
                if b == "?":
                    if zero_count > 0:
                        zero_count -= 1
                        b = "0"
                    else:
                        b = "1"
                sum_val += ord(a) - ord(b)
                if sum_val < 0:
                    isGood = False
                    break
            res.append(isGood and zero_count == 0)
        return res

